package org.oobootcamp.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ParkingLotTest {

    public static final String CAR_CODE_A = "A";
    public static final int PARKING_LOT_SIZE = 20;

    @Test
    void should_park_success_and_return_ticket_when_parking_given_one_car_with_available_space(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(CAR_CODE_A);

        Ticket ticket = parkingLot.park(car);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_park_failed_when_parking_given_one_car_with_unavailable_space(){
        Car car = new Car(CAR_CODE_A);
        HashMap<Ticket, Car> carMap = new HashMap<>();
        Ticket ticket = new Ticket(CAR_CODE_A);
        carMap.put(ticket, car);
        ParkingLot parkingLot = new ParkingLot(1, carMap);
        Assertions.assertThrows(RuntimeException.class, () -> {
            parkingLot.park(car);
        });
    }

    @Test
    void should_pick_up_success_when_pick_up_given_ticket_with_available_car(){
        HashMap<Ticket, Car> carMap = new HashMap<>();
        Ticket ticket = new Ticket(CAR_CODE_A);
        Car car = new Car(CAR_CODE_A);
        carMap.put(ticket, car);
        ParkingLot parkingLot = new ParkingLot(PARKING_LOT_SIZE, carMap);

        Car pickedCar = parkingLot.pick(ticket);

        Assertions.assertNotNull(pickedCar);
    }

    @Test
    void should_pick_up_failed_when_pick_up_given_ticket_with_unavailable_car(){
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = new Ticket(CAR_CODE_A);
        Assertions.assertThrows(RuntimeException.class, () -> {
            parkingLot.pick(ticket);
        });
    }



}
