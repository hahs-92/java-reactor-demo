package com.sofka.demoreactor.operador.transformation;

import com.sofka.demoreactor.model.Person;
import com.sofka.demoreactor.operador.creacion.Creation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Transformation {
    private final static Logger Log = LoggerFactory.getLogger(Creation.class);

    public void map() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .map(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return p;
                })
                .subscribe(p -> Log.info(p.toString()));

        //Flux<Integer> fx = Flux.range(0,10);
        //Flux<Integer> fx2 = fx.map(x -> x + 10);
        //fx2.subscribe(x -> Log.info("x: " + x));
    }

    public void flatMap() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .flatMap(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return Mono.just(p); //debemos devolver otro flujo de datos
                })
                .subscribe(p -> Log.info(p.toString()));
    }

    public void groupBy() {
        List<Person> people = List.of(
                new Person(1, "Alex",20),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .groupBy(Person::getEdad)
                .flatMap(idFlux -> idFlux.collectList()) //agrupa a los de 20 y si no hay repetidos devuleve cada uno x separado
                .subscribe(p -> Log.info(p.toString()));
    }
}
