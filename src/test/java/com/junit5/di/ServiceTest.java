package com.junit5.di;

import java.lang.reflect.Constructor;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceTest {

    @Test
    void ensureJSR330Constructor() {
        int count = 0;
        Constructor<?>[] constructors = Service.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            Inject annotation = constructor.getAnnotation(Inject.class);
            if (annotation != null) {
                count++;
            }
        }
        Assertions.assertEquals(2, count);
    }

}