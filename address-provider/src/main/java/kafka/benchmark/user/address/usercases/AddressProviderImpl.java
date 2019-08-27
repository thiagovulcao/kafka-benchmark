package kafka.benchmark.user.address.usercases;

import kafka.benchmark.user.address.configurations.kafka.InputStream;
import kafka.benchmark.user.address.configurations.kafka.OutputStream;
import kafka.benchmark.user.address.entities.kafka.UserAddressPayload;
import kafka.benchmark.user.address.entities.postgres.Address;
import kafka.benchmark.user.address.gateways.AddressGateway;
import kafka.benchmark.user.address.util.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.core.convert.converter.Converter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressProviderImpl implements AddressProvider {

    private final AddressGateway gateway;
    private final Validator validator;
    private final OutputStream outputStream;
    private final Converter<List<Address>, List<UserAddressPayload.AddressPayload>> converter;

    @Override
    public UserAddressPayload provide(final UserAddressPayload payload) {
        validator.validate(payload);
        final List<Address> addresses = gateway.findByUserId(payload.getId());
        if (!addresses.isEmpty()) {
            payload.setAddresses(converter.convert(addresses));
        }
        return payload;
    }

    @StreamListener(InputStream.USER_INPUT)
    public void listener(final UserAddressPayload payload) {
        final UserAddressPayload result = provide(payload);
        if (Objects.nonNull(result.getAddresses()) && !result.getAddresses().isEmpty()) {
            outputStream.userAddress().send(MessageBuilder.withPayload(result).build());
        }
    }
}
