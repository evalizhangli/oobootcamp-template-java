package org.oobootcamp.core;

import org.oobootcamp.core.exception.InvalidTicketException;
import org.oobootcamp.core.exception.NoAvailablePlaceException;
import org.oobootcamp.core.strategy.FindFirstFreeParkingLot;

import java.util.List;
import java.util.Optional;

public class ParkingManager{

    private final List<ParkingLot> parkingLots;
    private final List<ParkingBoy> parkingBoys;
    private final FindFirstFreeParkingLot findParkingLotStrategy = new FindFirstFreeParkingLot();

    public ParkingManager(List<ParkingBoy> parkingBoys, List<ParkingLot> parkingLots) {
        this.parkingBoys = parkingBoys;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        Optional<ParkingBoy> parkingBoy = parkingBoys.stream().filter(ParkingBoy::hasFreeParkingLot).findFirst();
        if (parkingBoy.isPresent()) {
            return parkingBoy.get().park(car);
        }
        Optional<ParkingLot> parkingLot = findParkingLotStrategy.findParkingLot(parkingLots);
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new NoAvailablePlaceException();
    }

    public Car pick(Ticket ticket) {
        Optional<ParkingBoy> findParkingBoy = parkingBoys.stream().filter(parkingBoy -> parkingBoy.hasCar(ticket)).findFirst();
        if (findParkingBoy.isPresent()) {
            return findParkingBoy.get().pick(ticket);
        }

        Optional<ParkingLot> findParkingLot = parkingLots.stream().filter(parkingLot -> parkingLot.hasCar(ticket)).findFirst();
        if (findParkingLot.isPresent()) {
            return findParkingLot.get().pick(ticket);
        }

        throw new InvalidTicketException();
    }
}
