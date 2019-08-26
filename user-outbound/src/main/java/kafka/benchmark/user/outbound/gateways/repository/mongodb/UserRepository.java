package kafka.benchmark.user.outbound.gateways.repository.mongodb;

import kafka.benchmark.user.outbound.entities.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
