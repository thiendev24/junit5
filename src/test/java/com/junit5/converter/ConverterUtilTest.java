package com.junit5.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

class ConverterUtilTest {

    int[][] celsiusFahrenheitMapping = new int[][]{{10, 50}, {40, 104}, {0, 32}};

    @TestFactory
    Stream<DynamicTest> ensureThatCelsiusConvertsToFahrenheit() {
        return Arrays.stream(celsiusFahrenheitMapping).map(entry -> {
            // access celsius and fahrenheit from entry
            int celsius = entry[0];
            int fahrenheit = entry[1];
            return DynamicTest.dynamicTest(
                    celsius + " celsius are " + fahrenheit,
                    () -> Assertions.assertEquals(fahrenheit, ConverterUtil.convertCelsiusToFahrenheit(celsius))
            );
            // return a dynamicTest which checks that the conversion from celsius to fahrenheit is correct
        });
    }

    @TestFactory
    Stream<DynamicTest> ensureThatFahrenheitToCelsiusConverts() {
        // TODO Write a similar test fahrenheit to celsius
        return Arrays.stream(celsiusFahrenheitMapping).map(item -> {
            int celsius = item[0];
            int fahrenheit = item[1];
            return DynamicTest.dynamicTest(
                    fahrenheit + " fahrenheit are " + celsius,
                    () -> Assertions.assertEquals(
                            celsius,
                            ConverterUtil.convertFahrenheitToCelsius(fahrenheit)
                    )
            );
        });
    }

}