package edu.service;

import edu.configs.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    //@Autowired
    //private AppConfig props;

    //@MockBean
    //private GreetingController greetingController;

    @Test
    public void getGreetingTest(){
        final String lname = "Lit";
        final String fname = "Ant";

        //when(greetingController.getGreeting(lname, fname, props)).thenReturn(Collections.singletonMap(fname, lname));

        //ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port +"/greeting?lname=" + lname + "&fname=" + fname, Map.class);

        ResponseEntity<String> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "greeting?lname=Lit&fname=Ant", String.class);

        System.out.println(entity);
        System.out.println(entity.getBody());
        System.out.println(lname);
        System.out.println(fname);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertNotNull(entity.getBody(), "body not null");
        assertTrue(entity.getBody().contains("Hello, " + lname + " " + fname + "!"));
    }
}
