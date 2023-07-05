package Reservation.Backend.services;

import Reservation.Backend.model.busmodel;

import java.util.List;

public interface busservice{
    busmodel addbuss(busmodel model);
    List<busmodel> getbuss();
}
