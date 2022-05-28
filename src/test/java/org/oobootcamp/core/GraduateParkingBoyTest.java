package org.oobootcamp.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GraduateParkingBoyTest {
    public static final String TICKET_NUMBER = "鄂A 111222";


    @Test
    void should_park_success_in_number_1_parking_lot_and_return_ticket_when_attendant_park_given_number_1_parking_lot_available() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(parkingLot1, new ParkingLot(1), new ParkingLot(1));
        Car car = new Car(TICKET_NUMBER);

        Ticket ticket = parkingAttendant.park(car);

        assertNotNull(ticket);
        Car pickedCar = parkingLot1.pick(ticket);
        assertEquals(car, pickedCar);
    }

    @Test
    void should_park_success_in_number_2_parking_lot_and_return_ticket_when_attendant_park_given_number_2_parking_lot_available() {
        ParkingLot parkingLot2 = new ParkingLot(1);

        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(new ParkingLot(0),
            parkingLot2,
            new ParkingLot(1));
        Car car = new Car(TICKET_NUMBER);

        Ticket ticket = parkingAttendant.park(car);

        assertNotNull(ticket);
        Car pickedCar = parkingLot2.pick(ticket);
        assertEquals(car, pickedCar);
    }

    @Test
    void should_park_success_in_number_3_parking_lot_and_return_ticket_when_attendant_park_given_number_3_parking_lot_available() {
        ParkingLot parkingLot3 = new ParkingLot(1);

        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(new ParkingLot(0),
            new ParkingLot(0),
            parkingLot3);
        Car car = new Car(TICKET_NUMBER);

        Ticket ticket = parkingAttendant.park(car);

        assertNotNull(ticket);
        Car pickedCar = parkingLot3.pick(ticket);
        assertEquals(car, pickedCar);
    }

    @Test
    void should_park_success_in_number_1_parking_lot_and_return_ticket_when_attendant_park_given_number_1_3_parking_lot_available() {
        ParkingLot parkingLot1 = new ParkingLot(1);

        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(parkingLot1,
            new ParkingLot(0),
            new ParkingLot(1));
        Car car = new Car(TICKET_NUMBER);

        Ticket ticket = parkingAttendant.park(car);

        assertNotNull(ticket);
        Car pickedCar = parkingLot1.pick(ticket);
        assertEquals(car, pickedCar);
    }

    @Test
    void should_park_fail_when_attendant_park_given_no_available_parking_lot() {
        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(new ParkingLot(0),
            new ParkingLot(0),
            new ParkingLot(0));
        Car car = new Car(TICKET_NUMBER);

        assertThrows(RuntimeException.class, () -> {
            parkingAttendant.park(car);
        });

    }

    @Test
    void should_pick_up_success_at_first_parking_lot_when_pick_up_given_ticket_with_available_car() {
        HashMap<Ticket, Car> carMap = new HashMap<>();
        Ticket ticket = new Ticket(TICKET_NUMBER);
        carMap.put(ticket, new Car(TICKET_NUMBER));
        ParkingLot parkingLot = new ParkingLot(1, carMap);

        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(parkingLot, new ParkingLot(1), new ParkingLot());

        Car pickUpCar = parkingAttendant.pick(ticket);

        Assertions.assertNotNull(pickUpCar);
    }
/*
    @Test
    void should_pick_up_success_at_second_parking_lot_when_pick_up_given_ticket_with_available_car() {
        HashMap<String, Car> carMap = new HashMap<>();
        carMap.put(TICKET_NUMBER, new Car(TICKET_NUMBER));
        ParkingLot parkingLot = new ParkingLot(1, carMap);
        Ticket ticket = new Ticket(TICKET_NUMBER, 2);

        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(parkingLots);
        parkingAttendant.addParkingLot(1, new ParkingLot(1));
        parkingAttendant.addParkingLot(2, parkingLot);
        parkingAttendant.addParkingLot(3, new ParkingLot(1));

        Car pickUpCar = parkingAttendant.pick(ticket);

        Assertions.assertNotNull(pickUpCar);
    }

    @Test
    void should_pick_up_failed_when_pick_up_given_ticket_with_unavailable_car() {
        GraduateParkingBoy parkingAttendant = new GraduateParkingBoy(parkingLots);
        parkingAttendant.addParkingLot(1, new ParkingLot(1));
        parkingAttendant.addParkingLot(2, new ParkingLot(1));
        parkingAttendant.addParkingLot(3, new ParkingLot(1));

        assertThrows(RuntimeException.class, () -> {
            parkingAttendant.pick(new Ticket(TICKET_NUMBER, 1));
        });
    }


 */

}