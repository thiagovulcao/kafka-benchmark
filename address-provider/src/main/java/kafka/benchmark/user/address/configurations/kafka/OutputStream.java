package kafka.benchmark.user.address.configurations.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface OutputStream {

    String USER_ADDRESS = "user-address-output";

    @Input(OutputStream.USER_ADDRESS)
    MessageChannel userAddress();
}
