package com.sofka.demoreactor.operador.filter;

import com.sofka.demoreactor.model.Person;
import com.sofka.demoreactor.operador.creacion.Creation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Filter {
    private final static Logger Log = LoggerFactory.getLogger(Creation.class);

    public void filter() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .filter(p -> p.getEdad() < 23)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void distinct() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(1, "Alex",29),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .distinct() //devuelve los valores repetidos, se necesita hascode y equals en objectos
                .subscribe(p -> Log.info(p.toString()));
    }

    public void take() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(1, "Alex",29),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .take(2) // toma los dos primeros elementos
                .subscribe(p -> Log.info(p.toString()));
    }

    public void takeLast() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(1, "Alex",29),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .takeLast(1) //Jinx
                .subscribe(p -> Log.info(p.toString()));
    }

    public void skip() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(1, "Alex",29),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .skip(1) //salta el primer elemento
                .subscribe(p -> Log.info(p.toString()));
    }

    public void skipLast() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(1, "Alex",29),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .skipLast(1)
                .subscribe(p -> Log.info(p.toString()));
    }
}
