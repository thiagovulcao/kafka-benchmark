package kafka.benchmark.user.address.usercases;

import kafka.benchmark.user.address.entities.kafka.UserAddressPayload;

public interface AddressProvider {

    UserAddressPayload provide(UserAddressPayload payload);
}
