package com.sofka.demoreactor;

import com.sofka.demoreactor.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just(new Person(1,"Alex", 29))
				.subscribe(p -> log.info("[Reactor] Person: " + p));
	}

	public void rxjava2() {
		Observable.just(new Person(1, "Alex",29))
				.subscribe(p -> log.info("[RxJava] Person: " + p));
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	//implemnetar CommandLineRunner - vamos a trabajar en consola
	@Override
	public void run(String... args) throws Exception {
		reactor();
		rxjava2();
	}
}
