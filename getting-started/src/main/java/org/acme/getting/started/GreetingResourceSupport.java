package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")
public abstract class GreetingResourceSupport {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public abstract String greeting(@PathParam String name);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public abstract String hello();
}
