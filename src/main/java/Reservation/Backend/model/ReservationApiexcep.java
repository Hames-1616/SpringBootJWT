package Reservation.Backend.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationApiexcep extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public ReservationApiexcep(HttpStatus status , String message)
    {
        this.status = status;
        this.message=message;
    }
}
