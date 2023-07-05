package Reservation.Backend.repos;

import Reservation.Backend.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface userrepo extends MongoRepository<user,String> {
//    user findByuserName(String username);
    Optional<user> findByName(String username);
}
