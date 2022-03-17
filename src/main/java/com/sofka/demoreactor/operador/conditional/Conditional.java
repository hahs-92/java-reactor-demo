package com.sofka.demoreactor.operador.conditional;

import com.sofka.demoreactor.model.Person;
import com.sofka.demoreactor.operador.creacion.Creation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Conditional {
    private final static Logger Log = LoggerFactory.getLogger(Creation.class);

    public void defaultIfEmpty() {
        //tambien puede ser un flux
        Mono.empty()
                .defaultIfEmpty(new Person()) // no es ejecutado si, hay datos
                .subscribe(p -> Log.info(p.toString()));
    }

    public void takeUntil() {
        List<Person> people = List.of(
                new Person(1, "Alex",19),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .takeUntil(p -> p.getEdad() > 22) //cuando la edad sea mayor a 22 para
                .subscribe(p -> Log.info(p.toString()));
    }

    public void timeout() throws InterruptedException {
        List<Person> people = List.of(
                new Person(1, "Alex",29),
                new Person(2, "Jess",24),
                new Person(3, "Jinx",20)
        );

        Flux.fromIterable(people)
                .delayElements(Duration.ofSeconds(3)) //si fuera 1, llegaria la info normal
                .timeout(Duration.ofSeconds(2)) // espera dos segundos y se lanza si no llega nada
                .subscribe(p -> Log.info(p.toString()));

        //se agrego para poder ver el resultado
        //ya que se esta trabajando con la consola
        Thread.sleep(10000);
    }
}

