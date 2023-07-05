package Reservation.Backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class responsemodel<T> {

    private int statuscode;
    private String message;
    private T response;
}
