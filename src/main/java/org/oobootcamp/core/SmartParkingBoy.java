package org.oobootcamp.core;

import org.oobootcamp.core.exception.NoAvailablePlaceException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends GraduateParkingBoy{

    public SmartParkingBoy(ParkingLot... parkingLot) {
        this.parkingLots = List.of(parkingLot);
    }

    @Override
    public Ticket park(Car car){
        ParkingLot parkingLot = parkingLots.stream().sorted(Comparator.comparing(ParkingLot::getAvailable).reversed()).collect(Collectors.toList()).get(0);
        return parkingLot.park(car);
    }
}
