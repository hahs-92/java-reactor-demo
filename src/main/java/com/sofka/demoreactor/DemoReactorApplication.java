package com.sofka.demoreactor;

import com.sofka.demoreactor.model.Person;
import com.sofka.demoreactor.operador.creacion.Creation;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just(new Person(1,"Alex", 29))
				.doOnNext(p -> {
					//logica Adicional
					log.info("[Reactor] Person: " + p);
				})
				.subscribe(p -> log.info("[Reactor] Person: " + p));
	}

	public void rxjava2() {
		Observable.just(new Person(1, "Alex",29))
				.doOnNext(p -> log.info("[RxJava] Person: " + p))
				.subscribe(p -> log.info("[RxJava] Person: " + p));
	}


	public void mono() {
		Mono.just(new Person(1,"Alex",29))
				.subscribe(p -> log.info(p.toString()));
	}

	public void flux() {
		List<Person> people = List.of(
				new Person(1, "Alex",29),
				new Person(2, "Jess",24),
				new Person(3, "Jinx",20)
		);

		Flux.fromIterable(people).subscribe(p -> log.info(p.toString()));
	}

	//devuleve un array(MONO)  y no elemento x elemento
	public void fluxToMono() {
		List<Person> people = List.of(
				new Person(1, "Alex",29),
				new Person(2, "Jess",24),
				new Person(3, "Jinx",20)
		);

		Flux<Person> fx = Flux.fromIterable(people);
		fx.collectList().subscribe(list -> log.info(list.toString()));
		//collectList devuelve un Mono
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	//implemnetar CommandLineRunner - vamos a trabajar en consola
	@Override
	public void run(String... args) throws Exception {
		//reactor();
		//rxjava2();

		//mono();
		//flux();

		//fluxToMono();


		//creacion
		Creation app = new Creation();
		app.range();
		app.repeact();

	}
}
