package com.sofka.demoreactor.operador.merge;

import com.sofka.demoreactor.model.Person;
import com.sofka.demoreactor.model.Purchase;
import com.sofka.demoreactor.operador.creacion.Creation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;

public class Merge {
    private final static Logger Log = LoggerFactory.getLogger(Creation.class);

    public void merge() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        List<Purchase> purchase = List.of(
                new Purchase(1, LocalDate.of(2020,9,2)),
                new Purchase(2, LocalDate.of(2021,1,12)),
                new Purchase(1, LocalDate.of(2021,6,6))
        );

        Flux<Person> fx1 = Flux.fromIterable(people);
        Flux<Purchase> fx2 = Flux.fromIterable(purchase);

        //Puede haber mas flujos
        Flux.merge(fx1,fx2)
                .subscribe(p -> Log.info(p.toString()));

    }

    public void zip() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        List<Person> people2 = List.of(
                new Person(1, "Ekko",19),
                new Person(2, "Vik",26),
                new Person(3, "Powder",20)
        );

        List<Purchase> purchase = List.of(
                new Purchase(1, LocalDate.of(2020,9,2)),
                new Purchase(2, LocalDate.of(2021,1,12)),
                new Purchase(1, LocalDate.of(2021,6,6))
        );

        Flux<Person> fx1 = Flux.fromIterable(people);
        Flux<Person> fx2 = Flux.fromIterable(people2);
        Flux<Purchase> fx3 = Flux.fromIterable(purchase);

        //Puede haber mas flujos
        //Flux.zip(fx1,fx2, (p1,p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                //.subscribe(p -> Log.info(p.toString()));

        //devuleve un array por cada lista
        Flux.zip(fx1, fx2, fx3)
                .subscribe(p -> Log.info(p.toString()));

    }


    public void zipWith() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        List<Person> people2 = List.of(
                new Person(1, "Ekko",19),
                new Person(2, "Vik",26),
                new Person(3, "Powder",20)
        );

        List<Purchase> purchase = List.of(
                new Purchase(1, LocalDate.of(2020,9,2)),
                new Purchase(2, LocalDate.of(2021,1,12)),
                new Purchase(1, LocalDate.of(2021,6,6))
        );

        Flux<Person> fx1 = Flux.fromIterable(people);
        Flux<Person> fx2 = Flux.fromIterable(people2);
        Flux<Purchase> fx3 = Flux.fromIterable(purchase);

        //se parte desde un flujo (fx1)
        fx1.zipWith(fx2, (p, v) -> String.format("Flux1: %s, Flux2: %s", p, v))
                .subscribe(p -> Log.info(p.toString()));

    }

}
