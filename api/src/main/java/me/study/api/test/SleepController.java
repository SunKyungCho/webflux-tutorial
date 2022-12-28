package me.study.api.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class SleepController {

    @GetMapping("/")
    public String get(int idx) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
        log.info("request {}", idx);
        return "Rest " + idx;
    }

}
