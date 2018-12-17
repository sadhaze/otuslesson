package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthTest {
    private Auth auth = new Auth();

    public void setAuth(Auth auth){
        this.auth = auth;
    }

    @Test
    public void tAuthAccessTest_1() {
        Assertions.assertEquals("Access", auth.getAuth("Admin", "Admin"));
    }

    @Test
    public void tAuthDeniedTest_1() {
        Assertions.assertEquals("Denied", auth.getAuth("Admin", "User01"));
    }

    @Test
    public void tAuthAccessTest_2() {
        Assertions.assertEquals("Access", auth.getAuth("User01", "User01"));
    }

    @Test
    public void tAuthDeniedTest_2() {
        Assertions.assertEquals("Denied", auth.getAuth("User02", "User01"));
    }

}
