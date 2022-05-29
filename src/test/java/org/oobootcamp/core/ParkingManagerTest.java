package org.oobootcamp.core;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingManagerTest {

    public static final String CAR_CODE = "鄂A 111222";

    @Nested
    class FreeSpaceParkingLot {
        @Test
        void should_return_ticket_when_parking_given_without_boy() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot(1);
            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), List.of(parkingLot));
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot.hasCar(ticket));
        }


        @Test
        void should_return_ticket_when_parking_given_with_one_graduate_boy_with_one_free_space() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot(1);
            GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLot);
            ParkingManager parkingManager = new ParkingManager(List.of(graduateParkingBoy),new ArrayList<>());
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot.hasCar(ticket));
        }
    }
}
