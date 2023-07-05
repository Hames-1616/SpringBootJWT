package Reservation.Backend.repos;

import Reservation.Backend.model.busmodel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface test extends MongoRepository<busmodel, String> {

}
