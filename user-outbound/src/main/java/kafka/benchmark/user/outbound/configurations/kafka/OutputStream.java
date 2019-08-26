package kafka.benchmark.user.outbound.configurations.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputStream {

    String USER_OUTPUT = "user-output";

    @Output(OutputStream.USER_OUTPUT)
    MessageChannel userOutput();
}
