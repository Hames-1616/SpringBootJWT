package Reservation.Backend.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "bus")
public class busmodel {
//    private long Bus_id;
    private String busName;
    private Integer seat;
}
