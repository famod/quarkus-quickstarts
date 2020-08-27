package org.acme.validation.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SomeInterceptorBinding
//@Priority(199)
public class SomeInterceptor {

    @AroundInvoke
    public Object intercept(final InvocationContext ic) throws Exception {
        System.out.println("~~~ interceptor called for: " + ic.getMethod());
        ic.setParameters(new Object[] { "intercepted" });
        return ic.proceed();
    }
}
