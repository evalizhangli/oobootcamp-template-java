package org.oobootcamp.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {

    public static final String CAR_CODE = "鄂A 111222";

    @Test
    void should_return_ticket_and_parking_first_parking_lot_when_parking_given_single_parking_lot_with_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car(CAR_CODE);
        Ticket parkedTicket = smartParkingBoy.park(car);
        assertNotNull(parkedTicket);
        assertTrue(parkingLot.hasCar(parkedTicket));
    }

    @Test
    void should_return_ticket_and_parking_first_parking_lot_when_parking_given_first_more_than_second_with_space() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car(CAR_CODE);

        Ticket parkedTicket = smartParkingBoy.park(car);

        assertNotNull(parkedTicket);
        assertTrue(parkingLot1.hasCar(parkedTicket));

    }

    @Test
    void should_return_ticket_and_parking_first_parking_lot_when_parking_given_first_less_than_second_with_space() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car(CAR_CODE);

        Ticket parkedTicket = smartParkingBoy.park(car);

        assertNotNull(parkedTicket);
        assertTrue(parkingLot2.hasCar(parkedTicket));

    }

    @Test
    void should_return_ticket_and_parking_first_parking_lot_when_parking_given_first_equal_second_with_space() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);

        Car car = new Car(CAR_CODE);

        Ticket parkedTicket = smartParkingBoy.park(car);

        assertNotNull(parkedTicket);
        assertTrue(parkingLot1.hasCar(parkedTicket));
    }

    @Test
    void should_return_ticket_and_parking_second_parking_lot_when_parking_given_first_less_than_second_equal_third_with_space() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot parkingLot3 = new ParkingLot(2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2, parkingLot3);

        Car car = new Car(CAR_CODE);

        Ticket parkedTicket = smartParkingBoy.park(car);

        assertNotNull(parkedTicket);
        assertTrue(parkingLot2.hasCar(parkedTicket));
    }
}
