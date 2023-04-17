package com.junit5.platform;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class WindowTest {

    @Test
    void shouldReturnTrueWhenRunOnWindow() {
        // only run on Window
        Assumptions.assumeTrue(System.getProperty("os.name").contains("Window"));
        Assertions.assertTrue(true);
    }
}
