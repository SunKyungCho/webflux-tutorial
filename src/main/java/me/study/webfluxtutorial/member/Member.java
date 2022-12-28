package me.study.webfluxtutorial.member;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.Flow;

@Slf4j
public class Member {


    public static void main(String[] args) throws InterruptedException {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Flux.fromIterable(integers)
//                .publishOn(Schedulers.boundedElastic())
//                .doOnNext(s -> log.info("onNext = {}", s))
                .flatMap(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return Mono.just(i);
                })
                .map(i -> {
                    log.info("i = {}", i);
                    return i + 1;
                })
                .subscribe();


        log.info("exit");
        Thread.sleep(10000);

    }
}
