package Reservation.Backend.repos;

import Reservation.Backend.model.route;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface Busroute extends MongoRepository<route,String> {
    Optional<route> findByrouteName(String name);
    Optional<route> findBycity(String city);
}
