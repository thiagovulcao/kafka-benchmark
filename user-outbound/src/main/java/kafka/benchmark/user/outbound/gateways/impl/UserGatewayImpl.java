package kafka.benchmark.user.outbound.gateways.impl;

import kafka.benchmark.user.outbound.entities.mongodb.User;
import kafka.benchmark.user.outbound.gateways.UserGateway;
import kafka.benchmark.user.outbound.gateways.repository.mongodb.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository repository;

    @Override
    public Page<User> findAll(final int page, final int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public long count() {
        return repository.count();
    }
}
