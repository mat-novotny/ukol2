import cz.engeto.hotel.Guest;
import cz.engeto.hotel.Booking;
import cz.engeto.hotel.Room;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("Adéla","Malíková", LocalDate.of(1993,3,13));
        Guest guest2 = new Guest("Jan", "Dvořáček",LocalDate.of(1995,5,5));
        guest2.setBirthDate(LocalDate.of(1995,5,4));
        DateTimeFormatter czechFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
        System.out.println(guest2.getFirstName() + " " + guest2.getLastName() + " (" + guest2.getBirthDate().format(czechFormat) + ")");

        Room room1 = new Room(1,1,1000,true,true);
        Room room2 = new Room(2,1,1000,true,true);
        Room room3 = new Room(3,3,2400,false,true);


        Booking booking1 = new Booking(LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), room1, guest1);
        Booking booking2 = new Booking(LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), room3, guest1);
        booking2.addGuest(guest2);
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking1);
        bookingList.add(booking2);

        for(Booking booking : bookingList)
        {
            if(booking.isBusinessTrip())
            {
                System.out.println("Pracovní pobyt");
            }
            else
            {
                System.out.println("Rekreační pobyt");
            }
            System.out.println("Začátek pobytu: " + booking.getArrival().format(czechFormat));
            System.out.println("Konec pobytu: " + booking.getDeparture().format(czechFormat));
            System.out.println("Pokoj: " + booking.getRoom().getID());
            System.out.println("Celková cena: " + booking.getDeparture().compareTo(booking.getArrival()) * booking.getRoom().getPrice() + " Kč");
            System.out.println("Hosté:");
            Guest mainGuest = booking.getMainGuest();
            System.out.println("- " + mainGuest.getFirstName() + " " + booking.getMainGuest().getLastName());
            for (Guest guest : booking.getGuests())
            {
                System.out.println("- " + guest.getFirstName() + " " + guest.getLastName());
            }
            System.out.println();

        }

    }
}