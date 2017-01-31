package cabanas.garcia.ismael.examples.repository;

import cabanas.garcia.ismael.examples.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by XI317311 on 31/01/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
