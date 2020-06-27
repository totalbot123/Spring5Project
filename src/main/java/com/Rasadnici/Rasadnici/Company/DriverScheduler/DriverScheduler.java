package com.Rasadnici.Rasadnici.Company.DriverScheduler;

import java.util.List;

import com.Rasadnici.Rasadnici.Company.Driver.DriverData.Driver;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class DriverScheduler<T extends Driver> implements Runnable {

    List<T> driversQueue;
    boolean input;
    T driver;

    public DriverScheduler(List<T> driverQueue, boolean input) {
        this.driversQueue = driverQueue;
        this.input = input;
        this.driver = null;
    }

    public void setInput() {
        input = true;
    }

    public void clearInput() {
        input = false;
    }

    // What happens if scheduler wakes up at the same time that someone set input to
    // true?
    public void run() {
        try {
            while (true) {
                while (!input) {
                    wait();
                }
                recalculateQueue();
                putDriverToWait(driver);
                clearInput();
                pause();
                takeAction();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract void recalculateQueue();

    abstract void putDriverToWait(T driver);

    abstract void pause();

    void takeAction() {
        if (input) {
            return;
        }
        freeDriver();
    }

    abstract void freeDriver();

}