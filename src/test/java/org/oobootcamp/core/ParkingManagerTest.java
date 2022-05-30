package org.oobootcamp.core;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.oobootcamp.core.exception.InvalidTicketException;
import org.oobootcamp.core.exception.NoAvailablePlaceException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingManagerTest {

    public static final String CAR_CODE = "鄂A 111222";

    @Nested
    class ParkingSuccessFreeSpaceParkingLotWithoutBoyTests {
        @Test
        void should_return_ticket_when_parking_given_single_parking_lot() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot(1);
            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), List.of(parkingLot));
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot.hasCar(ticket));
        }


        @Test
        void should_return_ticket_when_parking_given_two_parking_lot_free_at_second() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot1 = new ParkingLot(0);
            ParkingLot parkingLot2 = new ParkingLot(1);
            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), List.of(parkingLot1, parkingLot2));
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot2.hasCar(ticket));
        }
    }

    @Nested
    class ParkingSuccessManageBoysWithFreeParkingLotTests {

        @Test
        void should_return_ticket_when_parking_given_one_graduate_boy_with_one_free_space() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot(1);
            GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLot);
            ParkingManager parkingManager = new ParkingManager(List.of(graduateParkingBoy),new ArrayList<>());
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot.hasCar(ticket));
        }

        @Test
        void should_return_ticket_when_parking_given_two_graduate_boy_first_without_second_with_one_free_space() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot(1);
            GraduateParkingBoy graduateParkingBoy1 = new GraduateParkingBoy();
            GraduateParkingBoy graduateParkingBoy2 = new GraduateParkingBoy(parkingLot);
            ParkingManager parkingManager = new ParkingManager(List.of(graduateParkingBoy1, graduateParkingBoy2),new ArrayList<>());
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot.hasCar(ticket));
        }

        @Test
        void should_return_ticket_when_parking_given_one_smart_boy_with_one_free_space() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot(1);
            SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
            ParkingManager parkingManager = new ParkingManager(List.of(smartParkingBoy),new ArrayList<>());
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot.hasCar(ticket));
        }

        @Test
        void should_return_ticket_when_parking_given_two_smart_boy_first_with_one_second_with_two_free_space() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot1 = new ParkingLot(1);
            ParkingLot parkingLot2 = new ParkingLot(2);
            ParkingLot parkingLot3 = new ParkingLot(3);
            SmartParkingBoy smartParkingBoy1 = new SmartParkingBoy(parkingLot1, parkingLot2);
            SmartParkingBoy smartParkingBoy2 = new SmartParkingBoy(parkingLot3);
            ParkingManager parkingManager = new ParkingManager(List.of(smartParkingBoy1, smartParkingBoy2),new ArrayList<>());
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot2.hasCar(ticket));
        }


        @Test
        void should_return_ticket_when_parking_given_one_smart_boy_and_one_graduate_boy_with_one_free_space() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot1 = new ParkingLot(1);
            ParkingLot parkingLot2 = new ParkingLot(2);
            GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLot1);
            SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot2);
            ParkingManager parkingManager = new ParkingManager(List.of(graduateParkingBoy, smartParkingBoy),new ArrayList<>());
            Ticket ticket = parkingManager.park(car);
            assertNotNull(ticket);
            assertTrue(parkingLot1.hasCar(ticket));
        }
    }

    @Nested
    class ParkingFailedWithoutFreeParkingLotTests {

        @Test
        void should_failed_when_parking_given_no_parking_lot_no_boys() {
            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), new ArrayList<>());
            Car car = new Car(CAR_CODE);
            assertThrows(NoAvailablePlaceException.class, () -> parkingManager.park(car));
        }

        @Test
        void should_failed_when_parking_given_one_parking_without_free_space() {
            ParkingLot parkingLot = new ParkingLot(0);
            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), List.of(parkingLot));
            Car car = new Car(CAR_CODE);
            assertThrows(NoAvailablePlaceException.class, () -> parkingManager.park(car));
        }

        @Test
        void should_failed_when_parking_given_one_parking_boy_without_free_space() {
            ParkingLot parkingLot = new ParkingLot(0);
            GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLot);
            ParkingManager parkingManager = new ParkingManager(List.of(graduateParkingBoy), new ArrayList<>());
            Car car = new Car(CAR_CODE);
            assertThrows(NoAvailablePlaceException.class, () -> parkingManager.park(car));
        }

        @Test
        void should_failed_when_parking_given_no_free_space_and_one_parking_boy_without_free_space() {
            ParkingLot parkingLot1 = new ParkingLot(0);
            ParkingLot parkingLot2= new ParkingLot(0);
            GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLot1);
            ParkingManager parkingManager = new ParkingManager(List.of(graduateParkingBoy), List.of(parkingLot2));
            Car car = new Car(CAR_CODE);
            assertThrows(NoAvailablePlaceException.class, () -> parkingManager.park(car));
        }
    }


    @Nested
    class PickSuccessRightTicketTests {
        @Test
        void should_return_car_when_picking_give_right_ticket_and_parking_lot_contain_car() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot();
            Ticket ticket = parkingLot.park(car);

            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), List.of(parkingLot));

            assertEquals(car, parkingManager.pick(ticket));
        }


        @Test
        void should_return_car_when_picking_give_right_ticket_and_parking_boy_lot_contain_car() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot();
            Ticket ticket = parkingLot.park(car);

            GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLot);
            ParkingManager parkingManager = new ParkingManager(List.of(graduateParkingBoy), new ArrayList<>());

            assertEquals(car, parkingManager.pick(ticket));
        }
    }
    
    @Nested
    class PickFailedInvalidTicketTests {
        @Test
        void should_failed_when_picking_given_wrong_ticket_and_without_car_at_parkinglot() {
            String FAKE_TICKET = "鄂A fake";
            Ticket fakeTicket = new Ticket(FAKE_TICKET);

            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), new ArrayList<>());
            assertThrows(InvalidTicketException.class, () -> parkingManager.pick(fakeTicket));
        }

        @Test
        void should_failed_when_picking_given_used_ticket() {
            Car car = new Car(CAR_CODE);
            ParkingLot parkingLot = new ParkingLot();
            Ticket ticket = parkingLot.park(car);
            parkingLot.pick(ticket);

            ParkingManager parkingManager = new ParkingManager(new ArrayList<>(), List.of(parkingLot));
            assertThrows(InvalidTicketException.class, () -> parkingManager.pick(ticket));
        }
    }
}
