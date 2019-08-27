package kafka.benchmark.user.address.gateways.impl;

import kafka.benchmark.user.address.entities.postgres.Address;
import kafka.benchmark.user.address.gateways.AddressGateway;
import kafka.benchmark.user.address.gateways.repository.postgresql.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressGatewayImpl implements AddressGateway {

    private final AddressRepository repository;

    @Override
    public List<Address> findByUserId(final String userId) {
        return repository.findByUserId(userId);
    }
}
