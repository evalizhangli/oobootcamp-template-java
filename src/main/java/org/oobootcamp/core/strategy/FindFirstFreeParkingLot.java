package org.oobootcamp.core.strategy;

import org.oobootcamp.core.ParkingLot;

import java.util.List;
import java.util.Optional;

public class FindFirstFreeParkingLot implements FindParkingLotStrategy{


    @Override
    public Optional<ParkingLot> findParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().filter(ParkingLot::hasSpace).findFirst();
    }
}
