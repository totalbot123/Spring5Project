package com.Rasadnici.Rasadnici.Admin;

import com.Rasadnici.Rasadnici.Security.Data.Farmer;

public interface FarmerUserManager {

    public void addFarmer(Farmer farmer);

    public void modifyFarmer(Long id, Farmer farmer);

}