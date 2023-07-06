package Reservation.Backend.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class errorModel {
    private int errorCode;
    private String errorMessage;
    private String devErrorMessage;
    private long timeStamp;
}
