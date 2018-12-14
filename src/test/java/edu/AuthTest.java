package edu;

import org.junit.Test;

public class AuthTest {
    private Auth auth = new Auth();

    public void setAuth(Auth auth){
        this.auth = auth;
    }

    @Test
    public void tAuthAccessAccessTest() {
        org.junit.Assert.assertEquals("Access", auth.getAuth("Admin", "Admin"));
    }

    @Test
    public void tAuthAccessDeniedTest() {
        org.junit.Assert.assertEquals("Denied", auth.getAuth("Admin", "aaaaa"));
    }
}
