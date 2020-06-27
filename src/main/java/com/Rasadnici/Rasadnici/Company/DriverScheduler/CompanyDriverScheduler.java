package com.Rasadnici.Rasadnici.Company.DriverScheduler;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Objects;

import com.Rasadnici.Rasadnici.Company.Driver.DriverData.Driver;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Component
@Slf4j
public class CompanyDriverScheduler extends DriverScheduler<Driver> {

    public CompanyDriverScheduler() {
        super(new LinkedList<Driver>(), false);
    }

    LocalTime time;

    @Override
    void recalculateQueue() {
        log.debug("CompanyDriverScheduler::recalcualteQueue - Start");
        LocalTime currentTime = LocalTime.now();
        long totalTime = 0;
        for (Driver driver : driversQueue) {
            long driverWaitingTime = driver.getWaitingTime();
            totalTime += driverWaitingTime;
            driverWaitingTime = totalTime - currentTime.minusNanos(time.toNanoOfDay()).toNanoOfDay();
            log.debug("CompanyDriverScheduler::recalcualteQueue - Driver waiting time recalculated to: "
                    + driverWaitingTime);
            driver.setWaitingTime(driverWaitingTime);
        }
        log.debug("CompanyDriverScheduler::recalcualteQueue - End");
    }

    // Implementation of waiting queue, waiting time of an element is subtracted by
    // all elements before it, because all elements are waiting for some time to
    // pass
    @Override
    void putDriverToWait(Driver driver) {
        log.debug("CompanyDriverScheduler::putDriverToWait - Start");
        Driver checkedDriver = Objects.requireNonNull(driver,
                "CompanyDriverScheduler::putDriverToWait - Invalid driver!");
        time = LocalTime.now();
        if (driversQueue.isEmpty()) {
            driversQueue.add(checkedDriver);
            return;
        }

        long totalTime = 0;
        int i;
        for (i = 0; i < driversQueue.size(); ++i) {
            Driver currentDriver = driversQueue.get(i);
            totalTime = currentDriver.getWaitingTime();
            if (checkedDriver.getWaitingTime() < totalTime) {
                break;
            }
        }
        long driversWaitingTime = checkedDriver.getWaitingTime();
        driversWaitingTime -= (totalTime - driversQueue.get(i).getWaitingTime());
        checkedDriver.setWaitingTime(driversWaitingTime);
        driversQueue.add(i, checkedDriver);
        log.debug("CompanyDriverScheduler::putDriverToWait - Start");
    }

    @Override
    void freeDriver() {
        driversQueue.remove(0);
        pause();
    }

    @Override
    void pause() {
        try {
            long pauseTime = driversQueue.get(0).getWaitingTime();
            this.wait(pauseTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}