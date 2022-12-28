package me.study.webfluxtutorial.member;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    WebClient client = WebClient.create("http://localhost:8900");

    @GetMapping("/")
    public Mono<String> get(String name) {

        return client.get()
                .retrieve()
                .bodyToMono(String.class)
                .map(memberService::addWorld);

    }
}
