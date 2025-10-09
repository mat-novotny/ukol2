package cz.engeto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private LocalDate arrival;
    private LocalDate departure;
    private Room room;
    private Guest mainGuest;
    private List<Guest> guests = new ArrayList<>();
    private boolean isBusinessTrip;

    public Booking(LocalDate arrival, LocalDate departure, Room room, Guest mainGuest, boolean isBusinessTrip) {
        this.arrival = arrival;
        this.departure = departure;
        this.room = room;
        this.mainGuest = mainGuest;
        this.isBusinessTrip = isBusinessTrip;
    }

    public Booking(LocalDate arrival, LocalDate departure, Room room, Guest mainGuest) {
        this(arrival,departure,room,mainGuest,false);
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }


    public boolean isBusinessTrip() {
        return isBusinessTrip;
    }

    public void setBusinessTrip(boolean businessTrip) {
        isBusinessTrip = businessTrip;
    }

    public Guest getMainGuest() {
        return mainGuest;
    }

    public void setMainGuest(Guest mainGuest) {
        this.mainGuest = mainGuest;
    }
}
