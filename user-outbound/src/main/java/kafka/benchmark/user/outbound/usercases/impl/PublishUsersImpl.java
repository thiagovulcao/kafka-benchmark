package kafka.benchmark.user.outbound.usercases.impl;

import kafka.benchmark.user.outbound.configurations.kafka.OutputStream;
import kafka.benchmark.user.outbound.entities.kafka.UserPayload;
import kafka.benchmark.user.outbound.entities.mongodb.User;
import kafka.benchmark.user.outbound.gateways.UserGateway;
import kafka.benchmark.user.outbound.usercases.PublishUsers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublishUsersImpl implements PublishUsers {

    @Value("${application.variables.page-size}")
    private Integer pageSize;
    private final UserGateway gateway;
    private final OutputStream outputStream;
    private final Converter<User, UserPayload> converter;

    @Override
    public void publish() {
        log.info("pubish started at ", Instant.now());
        final long totalUsers = gateway.count();
        for (int i = 0; i <= totalUsers / pageSize; i++) {
            gateway.findAll(i, pageSize)
                .getContent()
                .parallelStream()
                .forEach(x -> {
                    final UserPayload payload = converter.convert(x);
                    outputStream.userOutput().send(MessageBuilder.withPayload(payload).build());
                });
        }
        log.info("publish completed at {} with {} users published", Instant.now(), totalUsers);
    }
}