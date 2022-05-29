package org.oobootcamp.core;

import org.oobootcamp.core.exception.NoAvailablePlaceException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraduateParkingBoy {

    protected List<ParkingLot> parkingLots;

    public GraduateParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = List.of(parkingLots);
    }

    public Ticket park(Car car){
        ParkingLot availableParkingLot = parkingLots.stream().filter(parkingLot -> parkingLot.hasSpace()).findFirst().orElseThrow(() -> {
            throw new NoAvailablePlaceException();
        });
        return availableParkingLot.park(car);
    }

    public Car pick(Ticket ticket) {
        ParkingLot parkedLot = parkingLots.stream().filter(parkingLot -> parkingLot.hasCar(ticket)).findFirst().orElseThrow(() -> {
            throw new RuntimeException("invalid ticket");
        });
        return parkedLot.pick(ticket);
    }
}
