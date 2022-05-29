package org.oobootcamp.core;

import org.oobootcamp.core.strategy.FindFirstMostFreeParkingLot;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ParkingLot... parkingLot) {
        super(new FindFirstMostFreeParkingLot(), List.of(parkingLot));
    }
}
