package Reservation.Backend.Controller;


import Reservation.Backend.model.*;
import Reservation.Backend.services.implementor.busrouteimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/route")
public class busRouteController {
    @Autowired
    busrouteimp per;

    @PostMapping("/addRoute")
    public responsemodel<route> addRoute(@RequestBody route newRoute)
    {
        final route r = per.addroute(newRoute);
        return new responsemodel<>(HttpStatus.OK.value(),"New Route Added",r);
    }

    @GetMapping("/getRoutes")
    public List<route> getRoutes(){
        return per.getroutes();
    }

    @GetMapping("/Route/{rName}")
    public route getExactRoute(@PathVariable(name = "rName") String rName){
        return per.getRouteByrouteName(rName);
    }

    @GetMapping("/city/{cityName}")
    public route getExactCity(@PathVariable(name = "cityName") String cityName){
        return per.getRouteBycity(cityName);
    }
}
