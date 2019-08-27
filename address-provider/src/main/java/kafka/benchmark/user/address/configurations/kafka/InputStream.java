package kafka.benchmark.user.address.configurations.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface InputStream {

    String USER_INPUT = "user-output";

    @Input(InputStream.USER_INPUT)
    SubscribableChannel userInput();
}
