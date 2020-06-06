package com.Rasadnici.Rasadnici.Admin;

public interface UserApporvable {
    
    public void approveUserRegistration(String id);

    public void declineUserRegistration(String id);
}