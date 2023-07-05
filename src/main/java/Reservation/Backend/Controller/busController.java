package Reservation.Backend.Controller;


import Reservation.Backend.model.busmodel;
import Reservation.Backend.model.responsemodel;
import Reservation.Backend.services.busservice;
import Reservation.Backend.services.implementor.busimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("/api")
public class busController
{
    @Autowired
    busimp imp;

    @PostMapping("/addbus")
    public responsemodel<busmodel> add(@RequestBody busmodel bus)
    {
        final busmodel result = imp.addbuss(bus);
        return new responsemodel<>(HttpStatus.OK.value(),"Bus added",result);
    }


    @GetMapping("/getbus")
    public List<busmodel> get(){
        return imp.getbuss();
    }




}
