package org.oobootcamp.core;

import org.oobootcamp.core.exception.NoAvailablePlaceException;
import org.oobootcamp.core.strategy.FindFirstFreeParkingLot;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ParkingManager{

    private List<ParkingLot> parkingLots;
    private List<ParkingBoy> parkingBoys;
    private FindFirstFreeParkingLot findParkingLotStrategy = new FindFirstFreeParkingLot();

    public ParkingManager(List<ParkingBoy> parkingBoys, List<ParkingLot> parkingLots) {
        this.parkingBoys = parkingBoys;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        Optional<ParkingLot> parkingLot = findParkingLotStrategy.findParkingLot(parkingLots);
        if (Objects.isNull(parkingLot)) {
            throw new NoAvailablePlaceException();
        }
        return parkingLot.get().park(car);
    }
}
