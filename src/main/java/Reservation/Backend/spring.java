package Reservation.Backend;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "springtest")
public class spring {
    private String name;
    private String address;

    public spring(String name, String address) {
        
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
