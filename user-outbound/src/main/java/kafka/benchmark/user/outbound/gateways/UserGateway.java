package kafka.benchmark.user.outbound.gateways;

import kafka.benchmark.user.outbound.entities.mongodb.User;
import org.springframework.data.domain.Page;

public interface UserGateway {

    Page<User> findAll(final int page, final int size);

    long count();
}
