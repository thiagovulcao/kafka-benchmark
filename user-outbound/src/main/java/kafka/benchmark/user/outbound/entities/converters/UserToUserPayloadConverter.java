package kafka.benchmark.user.outbound.entities.converters;

import kafka.benchmark.user.outbound.entities.kafka.UserPayload;
import kafka.benchmark.user.outbound.entities.mongodb.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserPayloadConverter implements Converter<User, UserPayload> {

    @Override
    public UserPayload convert(final User input) {

        return UserPayload.builder()
            .id(input.getId())
            .firstName(input.getFirstName())
            .lastName(input.getLastName())
            .email(input.getEmail())
            .gender(input.getGender())
            .ipAddress(input.getIpAddress())
            .avatar(input.getAvatar())
            .race(input.getRace())
            .username(input.getUsername())
            .isClustered(input.getIsClustered())
            .dateClustered(input.getDateClustered())
            .build();
    }
}
