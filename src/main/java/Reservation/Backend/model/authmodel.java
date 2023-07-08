package Reservation.Backend.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class authmodel {
    private int statusCode;
    private String message;
    private String accessToken;
    private Long loginTime;
    private Long expTime;
}
