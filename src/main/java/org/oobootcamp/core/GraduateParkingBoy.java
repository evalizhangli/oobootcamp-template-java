package org.oobootcamp.core;

import org.oobootcamp.core.strategy.FindFirstFreeParkingLot;

import java.util.List;

public class GraduateParkingBoy extends ParkingBoy{

    public GraduateParkingBoy(ParkingLot... parkingLots) {
        super(new FindFirstFreeParkingLot(), List.of(parkingLots));
    }
}
