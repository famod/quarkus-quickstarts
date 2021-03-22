package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestSseElementType;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/hello")
public interface ReactiveGreeting {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    @Blocking
    Uni<String> greeting(String name) throws InterruptedException;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{count}/{name}")
    Multi<String> greetings(int count, String name);

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestSseElementType(MediaType.TEXT_PLAIN)
    @Path("/stream/{count}/{name}")
    Multi<String> greetingsAsStream(int count, String name);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String hello();

}