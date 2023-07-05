package Reservation.Backend.services.implementor;

import Reservation.Backend.model.route;
import Reservation.Backend.repos.Busroute;
import Reservation.Backend.services.busroute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class busrouteimp implements busroute {

    @Autowired
    Busroute rou;
    @Override
    public List<route> getroutes() {
        return rou.findAll();
    }

    @Override
    public route addroute(route r) {
        return rou.save(r);
    }

    @Override
    public route getRouteByrouteName(String routename) {
        return rou.findByrouteName(routename).orElseThrow();
    }

    @Override
    public route getRouteBycity(String city) {
        return rou.findBycity(city).orElseThrow();
    }


}
