package cz.engeto.hotel;

import java.time.LocalDate;
import java.util.List;

public class Booking {

    private LocalDate arrival;
    private LocalDate departure;
    private Room room;
    private List<Guest> guests;
    private boolean isBusinessTrip;

    public Booking(LocalDate arrival, LocalDate departure, Room room, List<Guest> guests, boolean isBusinessTrip) {
        this.arrival = arrival;
        this.departure = departure;
        this.room = room;
        this.guests = guests;
        this.isBusinessTrip = isBusinessTrip;
    }

    public Booking(LocalDate arrival, LocalDate departure, Room room, List<Guest> guests) {
        this(arrival,departure,room,guests,false);
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

    public void addGuest(Guest guest)
    {
        this.guests.add(guest);
    }
    public void removeGuest(Guest guest)
    {
        this.guests.remove(guest);
    }

    public boolean isBusinessTrip() {
        return isBusinessTrip;
    }

    public void setBusinessTrip(boolean businessTrip) {
        isBusinessTrip = businessTrip;
    }
}
