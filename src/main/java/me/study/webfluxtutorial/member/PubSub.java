package me.study.webfluxtutorial.member;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.*;

@Slf4j
public class PubSub {

    public static void main(String[] args) {

        Iterable<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // Publisher 데이터를 주는 쪽이다.
        Publisher p = new Flow.Publisher<>() {
            @Override
            public void subscribe(Subscriber subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {

                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber subscriber = new Subscriber() {

            @Override
            public void onSubscribe(Subscription subscription) {
                log.info("onSubscribe");
            }

            @Override
            public void onNext(Object item) {
                log.info("onNext = {}", item);
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("onError");
            }

            @Override
            public void onComplete() {
                log.info("onComplete");

            }
        };
        p.subscribe(subscriber);

    }
}
