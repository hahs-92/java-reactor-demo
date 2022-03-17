package com.sofka.demoreactor.operador.error;

import com.sofka.demoreactor.model.Person;
import com.sofka.demoreactor.operador.creacion.Creation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class ErrorOp {
    private final static Logger Log = LoggerFactory.getLogger(Creation.class);

    public void retry() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .retry(1) //tras el error trata de hacer nuevamente la accion del flujo
                .doOnNext(x -> Log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorReturn(new Person())//retornamos una nueva persona
                .subscribe(x -> Log.info(x.toString()));

    }

    public void errorResumen() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorResume(ex -> Mono.just(new Person()))
                .subscribe(x -> Log.info(x.toString()));

    }

    public void errorMap() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> Log.info(x.toString()));

    }
}
