package edu;

import org.junit.Test;

public class AuthTest {
    private Auth auth = new Auth();

    public void setAuth(Auth auth){
        this.auth = auth;
    }

    @Test
    public void tAuthAccessAccessTest_1() {
        org.junit.Assert.assertEquals("Access", auth.getAuth("Admin", "Admin"));
    }

    @Test
    public void tAuthAccessDeniedTest_1() {
        org.junit.Assert.assertEquals("Denied", auth.getAuth("Admin", "User01"));
    }

    @Test
    public void tAuthAccessAccessTest_2() {
        org.junit.Assert.assertEquals("Access", auth.getAuth("User01", "User01"));
    }

    @Test
    public void tAuthAccessDeniedTest_2() {
        org.junit.Assert.assertEquals("Denied", auth.getAuth("User02", "User01"));
    }

}
