package org.oobootcamp.core;

import org.oobootcamp.core.exception.NoAvailablePlaceException;

import java.util.HashMap;

public class ParkingLot {
    private int available;
    private int size;

    private HashMap<Ticket, Car> cars;

    public ParkingLot() {
        this.size = 20;
        this.cars = new HashMap<>();
        this.available = this.size;
    }

    public ParkingLot(int size) {
        this.size = size;
        this.cars = new HashMap<>();
        this.available = size - cars.size();
    }

    public ParkingLot(int size, HashMap<Ticket, Car> cars) {
        this.size = size;
        this.cars = cars;
        this.available = size - cars.size();
    }

    public Ticket park(Car car) {
        if (available <= 0) {
            throw new NoAvailablePlaceException();
        }
        Ticket ticket = new Ticket(car.getCode());
        cars.put(ticket, car);
        this.available --;
        return ticket;
    }

    public Car pick(Ticket ticket) {
        Car car = cars.get(ticket);
        if(car == null){
            throw new RuntimeException("can not pick up ticket");
        }
        cars.remove(ticket);
        return car;
    }

    public boolean hasSpace() {
        return available > 0;
    }

    public boolean hasCar(Ticket ticket) {
        return cars.containsKey(ticket);
    }

    public int getAvailable() {
        return available;
    }
}
