package com.Rasadnici.Rasadnici.Admin.AdminController;

public interface UserApporvable {

    public void approveUserRegistration(Long id);

    public void declineUserRegistration(Long id);
}