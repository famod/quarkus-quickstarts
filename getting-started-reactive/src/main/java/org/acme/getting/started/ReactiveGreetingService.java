package org.acme.getting.started;

import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ReactiveGreetingService {

    @Inject
    EntityManager em;

    public Uni<String> greeting(String name) {
        em.getCriteriaBuilder();
        return Uni.createFrom().item(name)
                .onItem().transform(n -> String.format("hello %s", name));
    }

    public Multi<String> greetings(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .onItem().transform(n -> String.format("hello %s - %d", name, n))
                .transform().byTakingFirstItems(count);

    }

}
