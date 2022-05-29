package org.oobootcamp.core.strategy;

import org.oobootcamp.core.ParkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindFirstMostFreeParkingLot implements FindParkingLotStrategy{


    @Override
    public Optional<ParkingLot> findParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().sorted(Comparator.comparing(ParkingLot::getAvailable).reversed()).toList().stream().findFirst();
    }
}
