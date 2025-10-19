package cz.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private LocalDate arrival;
    private LocalDate departure;
    private Room room;
    private List<Guest> guests = new ArrayList<>();
    private boolean isBusinessTrip;

    public Booking(LocalDate arrival, LocalDate departure, Room room, Guest mainGuest, boolean isBusinessTrip) {
        this.arrival = arrival;
        this.departure = departure;
        this.room = room;
        guests.add(mainGuest);
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

    public int getBookingLength()
    {
        return departure.compareTo(arrival);
    }

    public int getTotalPrice()
    {
        return getBookingLength() * room.getPrice();
    }

    public void getFormattedSummary()
    {
        Guest mainGuest = guests.get(0);
        DateTimeFormatter czechFormat = DateTimeFormatter.ofPattern("d. M. yyyy");
        String output = arrival.format(czechFormat) + " až " + departure.format(czechFormat)
                + ": " + mainGuest.getDescription() + "[" + guests.size() + ", " + room.isSeaView() + "] "
                + "za " + getTotalPrice() + " Kč";
        System.out.println();
    }

}
