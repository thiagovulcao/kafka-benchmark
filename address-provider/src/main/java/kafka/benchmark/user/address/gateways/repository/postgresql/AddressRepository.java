package kafka.benchmark.user.address.gateways.repository.postgresql;

import kafka.benchmark.user.address.entities.postgres.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByUserId(String userId);
}
