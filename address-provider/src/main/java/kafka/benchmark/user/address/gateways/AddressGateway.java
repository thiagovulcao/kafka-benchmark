package kafka.benchmark.user.address.gateways;

import kafka.benchmark.user.address.entities.postgres.Address;

import java.util.List;

public interface AddressGateway {

    List<Address> findByUserId(String userId);
}
