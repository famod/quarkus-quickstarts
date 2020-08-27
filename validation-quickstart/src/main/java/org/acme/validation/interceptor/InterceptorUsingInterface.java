package org.acme.validation.interceptor;

import javax.validation.Valid;

public interface InterceptorUsingInterface {

    String withoutValidOrBinding(String in);

    @SomeInterceptorBinding
    String withoutValidButWithBinding(String in);

    @SomeInterceptorBinding
    String withValidAndBinding(@Valid String in);

    String withValidAndBindingInImpl(@Valid String in);

    @SomeInterceptorBinding
    String withValidAndBindingAndInterceptorsInImpl(@Valid String in);
}