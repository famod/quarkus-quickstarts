package org.acme.getting.started;

import javax.inject.Inject;

public class GreetingResource extends GreetingResourceSupport {

    @Inject
    GreetingService service;

    @Override
    public String greeting(String name) {
        return service.greeting(name);
    }

    @Override
    public String hello() {
        return "hello";
    }
}