package com.Rasadnici.Rasadnici.Admin;

public interface UserApporvable {

    public void approveUserRegistration(Long id);

    public void declineUserRegistration(Long id);
}