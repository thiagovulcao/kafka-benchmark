package kafka.benchmark.user.outbound.http.controller;

import kafka.benchmark.user.outbound.usercases.PublishUsers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserOutboundController {

    private final PublishUsers publishUsers;

    @GetMapping("/publish")
    public void publish() {
        publishUsers.publish();
    }
}
