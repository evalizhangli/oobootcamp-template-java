package org.oobootcamp.core;

import org.oobootcamp.core.exception.InvalidTicketException;
import org.oobootcamp.core.exception.NoAvailablePlaceException;
import org.oobootcamp.core.strategy.FindParkingLotStrategy;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private final FindParkingLotStrategy findParkingLotStrategy;
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(FindParkingLotStrategy findParkingLotStrategy, List<ParkingLot> parkingLots) {
        this.findParkingLotStrategy = findParkingLotStrategy;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        Optional<ParkingLot> parkingLot = findParkingLotStrategy.findParkingLot(parkingLots);
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new NoAvailablePlaceException();
    }

    public Car pick(Ticket ticket) {
        ParkingLot parkedLot = parkingLots.stream().filter(parkingLot -> parkingLot.hasCar(ticket)).findFirst().orElseThrow(() -> {
            throw new InvalidTicketException();
        });
        return parkedLot.pick(ticket);
    }

    public boolean hasFreeParkingLot() {
        return parkingLots.stream().anyMatch(ParkingLot::hasSpace);
    }

    public boolean hasCar(Ticket ticket) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.hasCar(ticket));
    }
}
