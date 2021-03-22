package org.acme.getting.started;

import javax.inject.Inject;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

//@Path("/hello")
public class ReactiveGreetingResource implements ReactiveGreeting {

    @Inject
    ReactiveGreetingService service;

    @Override
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/greeting/{name}")
    @Blocking
    public Uni<String> greeting(String name) throws InterruptedException {
        return service.greeting(name);
    }

    @Override
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/greeting/{count}/{name}")
    public Multi<String> greetings(int count, String name) {
        return service.greetings(count, name);
    }

    @Override
//    @GET
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    @RestSseElementType(MediaType.TEXT_PLAIN)
//    @Path("/stream/{count}/{name}")
    public Multi<String> greetingsAsStream(int count, String name) {
        return service.greetings(count, name);
    }

    @Override
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
