package org.acme.validation.interceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptors;
import javax.validation.Valid;

@ApplicationScoped
public class InterceptorUsingService implements InterceptorUsingInterface {

    @Override
    public String withoutValidOrBinding(String in) {
        return in;
    }

    @Override
    public String withoutValidButWithBinding(String in) {
        return in;
    }

    @Override
    public String withValidAndBinding(String in) {
        return in;
    }

    @Override
    @SomeInterceptorBinding
    public String withValidAndBindingInImpl(String in) {
        return in;
    }

    @Override
    @Interceptors(SomeInterceptor.class)    // does not make a difference (same as withValidAndBinding())
    public String withValidAndBindingAndInterceptorsInImpl(@Valid String in) {
        return in;
    }
}
