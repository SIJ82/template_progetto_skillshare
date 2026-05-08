package it.unibo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingTest {

    private Greeting service;

    @Before
    public void setUp() {
        service = new Greeting();
    }

    @Test
    public void greetServer_shouldReturnHelloWithName() {
        String result = service.greet("World");
        assertEquals("Hello, from server World!", result);
    }

    @Test
    public void greetServer_shouldNotReturnNull() {
        assertNotNull(service.greet("Test"));
    }
}