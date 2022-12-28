package me.study.webfluxtutorial.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {


    public String addWorld(String name) {
        log.info("service : {}", name);
        return name + " world";
    }

}

