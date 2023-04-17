package com.junit5.nested;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class NestedTests {

    private List<String> list;

    @BeforeEach
    void setup() {
        list = Arrays.asList("JUnit 5", "Mockito");
    }

    @Test
    void listSizeTests() {
        Assertions.assertEquals(2, list.size());
    }

    // TODO define inner class with @Nestled
    // write one tests named checkFirstElement() to check that the first list element is "JUnit 5"
    // write one tests named checkSecondElement() to check that the first list element is "Mockito"
    @DisplayName("Grouped tests for checking members")
    @Nested
    class CheckMembers {
        @Test
        void checkFirstElement() {
            Assertions.assertEquals(("JUnit 5"), list.get(0));
        }

        @Test
        void checkSecondElement() {
            Assertions.assertEquals(("Mockito"), list.get(1));
        }

    }
}
