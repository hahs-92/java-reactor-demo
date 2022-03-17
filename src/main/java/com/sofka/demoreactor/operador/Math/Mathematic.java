package com.sofka.demoreactor.operador.Math;

import com.sofka.demoreactor.DemoReactorApplication;
import com.sofka.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Mathematic {
    private static final Logger Log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void average() {
        List<Person> people = List.of(
                new Person(1, "Alex",19),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .collect(Collectors.averagingInt(Person::getEdad))
                .subscribe(p -> Log.info(p.toString()));
    }

    public void count() {
        List<Person> people = List.of(
                new Person(1, "Alex",19),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .count()
                .subscribe(p -> Log.info(p.toString()));
    }

    public void min() {
        List<Person> people = List.of(
                new Person(1, "Alex",19),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .collect(Collectors.minBy(Comparator.comparing(Person::getEdad)))
                .subscribe(p -> Log.info(p.get().toString()));
    }

    public void sum() {
        List<Person> people = List.of(
                new Person(1, "Alex",19),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .collect(Collectors.summingInt(Person::getEdad))
                .subscribe(p -> Log.info(p.toString()));
    }

    public void summarizing() {
        List<Person> people = List.of(
                new Person(1, "Alex",19),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .collect(Collectors.summarizingInt(Person::getEdad))
                .subscribe(p -> Log.info("Resumen: " + p));
    }
}
