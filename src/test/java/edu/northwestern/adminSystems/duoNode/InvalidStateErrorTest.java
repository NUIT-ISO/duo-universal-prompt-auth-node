package edu.northwestern.adminSystems.duoNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidStateErrorTest {
    @Test
    void constructs()
    {
        String message = "Test message";
        InvalidStateError e = new InvalidStateError(message);

        assertEquals(message, e.getMessage());
        assertEquals(1, 2);
    }

}
