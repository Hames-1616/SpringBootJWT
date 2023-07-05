package Reservation.Backend.services;

import Reservation.Backend.model.route;

import java.util.List;

public interface busroute {
    List<route> getroutes();
    route addroute(route r);
    route getRouteByrouteName(String routename);
    route getRouteBycity(String city);
}
