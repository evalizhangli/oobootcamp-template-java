package org.oobootcamp.core;

import org.junit.jupiter.api.Test;
import org.oobootcamp.core.exception.NoAvailablePlaceException;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_parking_failed_when_parking_given_fulled_parking_lot() {
        ParkingLot parkingLot1 = new ParkingLot(0);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1);

        Car car = new Car(CAR_CODE);

        assertThrows(NoAvailablePlaceException.class, () -> smartParkingBoy.park(car));
    }

    @Test
    void should_return_my_car_when_picking_given_the_parking_lot_with_my_car_and_my_ticket() {
        Car car = new Car(CAR_CODE);
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car pickedCar = smartParkingBoy.pick(ticket);

        assertEquals(car, pickedCar);
    }

    @Test
    void should_return_my_car_when_picking_given_the_first_parking_lot_with_my_car_and_my_ticket() {
        Car car = new Car(CAR_CODE);
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        Ticket ticket = parkingLot1.park(car);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car pickedCar = smartParkingBoy.pick(ticket);

        assertEquals(car, pickedCar);
    }

    @Test
    void should_pick_failed_when_picking_given_fake_ticked_no_parking_lot_with_my_car() {
        ParkingLot parkingLot1 = new ParkingLot();
        Ticket fakeTicket = new Ticket("fake");

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1);
        assertThrows(RuntimeException.class, () -> smartParkingBoy.pick(fakeTicket));

    }

    @Test
    void should_pick_failed_when_picking_given_used_ticked_first_parking_lot_with_my_car() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        Car car = new Car(CAR_CODE);
        Car other_car = new Car("other car");
        Ticket ticket = parkingLot1.park(car);
        parkingLot2.park(other_car);
        parkingLot1.pick(ticket);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        assertThrows(RuntimeException.class, () -> smartParkingBoy.pick(ticket));

    }
}
