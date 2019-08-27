package kafka.benchmark.user.address.entities.converter;

import kafka.benchmark.user.address.entities.kafka.UserAddressPayload;
import kafka.benchmark.user.address.entities.postgres.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressToAddressPayloadConverter implements Converter<List<Address>, List<UserAddressPayload.AddressPayload>> {

    @Override
    public List<UserAddressPayload.AddressPayload> convert(final List<Address> input) {
        return input.parallelStream().map(this::convert).collect(Collectors.toList());
    }

    public UserAddressPayload.AddressPayload convert(final Address input) {
        return UserAddressPayload.AddressPayload.builder()
            .id(input.getId())
            .country(input.getCountry())
            .state(input.getState())
            .city((input.getCity()))
            .postalCode(input.getPostalCode())
            .street(input.getStreet())
            .streetNumber(input.getStreetNumber())
            .build();
    }
}
