package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AuthTest {
    private Auth auth = new Auth();

    public void setAuth(Auth auth){
        this.auth = auth;
    }

    @Test
    void tAuthAccessTest_1() {
        Assertions.assertEquals("Access", auth.getAuth("Admin", "Admin"));
    }

    @Test
    void tAuthDeniedTest_1() {
        Assertions.assertEquals("Denied", auth.getAuth("Admin", "User01"));
    }

    @Test
    void tAuthAccessTest_2() {
        Assertions.assertEquals("Access", auth.getAuth("User01", "User01"));
    }

    @Test
    void tAuthDeniedTest_2() {
        Assertions.assertEquals("Denied", auth.getAuth("User02", "User01"));
    }

}
