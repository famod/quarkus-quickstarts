package org.acme.validation.interceptor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class InterceptorUsingServiceTest {

    @Inject
    InterceptorUsingInterface service;

    @Test
    public void testWithoutValidOrBinding() {
        assertEquals("initial", service.withoutValidOrBinding("initial"));
    }

    @Test
    public void testWithoutValidButWithBinding() {
        assertEquals("intercepted", service.withoutValidButWithBinding("initial"));
    }

    @Test
    public void testWithValidAndBinding() {
        assertEquals("intercepted", service.withValidAndBinding("initial"));
    }

    @Test
    public void testWithValidAndBindingInImpl() {
        assertEquals("intercepted", service.withValidAndBindingInImpl("initial"));
    }

    @Test
    public void testWithValidAndBindingAndInterceptorsInImpl() {
        assertEquals("intercepted", service.withValidAndBindingAndInterceptorsInImpl("initial"));
    }
}
