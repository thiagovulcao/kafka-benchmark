package kafka.benchmark.user.address;

import kafka.benchmark.user.address.configurations.kafka.InputStream;
import kafka.benchmark.user.address.configurations.kafka.OutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableAutoConfiguration
@EnableBinding(value = {InputStream.class, OutputStream.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
