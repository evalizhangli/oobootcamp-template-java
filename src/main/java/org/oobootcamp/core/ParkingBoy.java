package org.oobootcamp.core;

import org.oobootcamp.core.exception.InvalidTicketException;
import org.oobootcamp.core.exception.NoAvailablePlaceException;
import org.oobootcamp.core.strategy.FindParkingLotStrategy;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ParkingBoy {

    private FindParkingLotStrategy findParkingLotStrategy;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(FindParkingLotStrategy findParkingLotStrategy, List<ParkingLot> parkingLots) {
        this.findParkingLotStrategy = findParkingLotStrategy;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        Optional<ParkingLot> parkingLot = findParkingLotStrategy.findParkingLot(parkingLots);
        if (Objects.isNull(parkingLot)) {
            throw new NoAvailablePlaceException();
        }
        return parkingLot.get().park(car);
    }

    public Car pick(Ticket ticket) {
        ParkingLot parkedLot = parkingLots.stream().filter(parkingLot -> parkingLot.hasCar(ticket)).findFirst().orElseThrow(() -> {
            throw new InvalidTicketException();
        });
        return parkedLot.pick(ticket);
    }
}
