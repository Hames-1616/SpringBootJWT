package Reservation.Backend.services.implementor;

import Reservation.Backend.model.busmodel;
import Reservation.Backend.repos.test;
import Reservation.Backend.services.busservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class busimp implements busservice {

    @Autowired
    test db;
    @Override
    public busmodel addbuss(busmodel model) {
        return db.save(model);
    }

    @Override
    public List<busmodel> getbuss() {
        return db.findAll();
    }
}
