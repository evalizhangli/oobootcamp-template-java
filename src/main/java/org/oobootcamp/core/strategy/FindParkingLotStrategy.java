package org.oobootcamp.core.strategy;

import org.oobootcamp.core.ParkingLot;

import java.util.List;
import java.util.Optional;

public interface FindParkingLotStrategy {
    public Optional<ParkingLot> findParkingLot(List<ParkingLot> parkingLots);
}
