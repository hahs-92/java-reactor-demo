package com.sofka.demoreactor.operador.creacion;

import com.sofka.demoreactor.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

//contiene operadores de creacion
public class Creation {

    private final static Logger Log = LoggerFactory.getLogger(Creation.class);

    public void justFrom() {
        Mono.just(new Person(1, "Alex", 29));
        //o utilizar Flux
    }

    public void empty() {
        Mono.empty();
        Flux.empty();
        //rx
        Observable.empty();
    }

    public void range() {
        Flux.range(0,3)
                .doOnNext(i -> Log.info("i: " + i))
                .subscribe();
    }

    //repetir flujos de datos
    public void repeact() {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .repeat(3)
                .subscribe(p -> Log.info("P: " + p.toString()));

        //tambien se podria hacer con un mono
    }
}
