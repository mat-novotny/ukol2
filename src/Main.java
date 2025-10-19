import cz.engeto.hotel.BookingManager;
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
    public static BookingManager bookingManager = new BookingManager();
    public static void main(String[] args) {
        /* Guest guest1 = new Guest("Adéla","Malíková", LocalDate.of(1993,3,13));
        Guest guest2 = new Guest("Jan", "Dvořáček",LocalDate.of(1995,5,5));
        guest2.setBirthDate(LocalDate.of(1995,5,4));
        DateTimeFormatter czechFormat = DateTimeFormatter.ofPattern("d. M. yyyy");
        System.out.println(guest2.getDescription());

        Room room1 = new Room(1,1,1000,true,true);
        Room room2 = new Room(2,1,1000,true,true);
        Room room3 = new Room(3,3,2400,false,true);


        Booking booking1 = new Booking(LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), room1, guest1);
        Booking booking2 = new Booking(LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), room3, guest1);
        booking2.getGuests().add(guest2);
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
            System.out.println("Celková cena: " + booking.getTotalPrice() + " Kč");
            System.out.println("Hosté:");
            for (Guest guest : booking.getGuests())
            {
                System.out.println("- " + guest.getDescription());
            }
            System.out.println();

        }*/
        int max = 8;

        fillBookings();
        System.out.println("Počet pracovních pobytů: " + bookingManager.getNumberOfWorkingBookings());
        System.out.println();
        System.out.println("Průměrný počet hostů na rezervaci: " + bookingManager.getAverageGuests());
        System.out.println();
        System.out.println("Prvních " + max + " rekreačních rezervací: ");
        for (Booking booking : bookingManager.getTopNHolidayBookings(max))
        {
            System.out.println(booking.getFormattedSummary());
        }
        System.out.println();
        bookingManager.printGuestStatistics();
        System.out.println();
        System.out.println("Formátovaný výpis všech rezervací v systému:");
        for (Booking booking : bookingManager.getBookings())
        {
            System.out.println(booking.getFormattedSummary());
        }

    }
    public static void fillBookings()
    {
        Guest guest1 = new Guest("Karel","Dvořák", LocalDate.of(1990,5,15));
        Guest guest2 = new Guest("Karel", "Dvořák",LocalDate.of(1979,1,3));
        Guest guest3 = new Guest("Karolína", "Tmavá");
        Room room1 = new Room(1,1,1000,true,true);
        Room room2 = new Room(2,1,1000,true,true);
        Room room3 = new Room(3,3,2400,false,true);
        bookingManager.addBooking(new Booking(LocalDate.of(2023,6,1),LocalDate.of(2023,6,7),room3,guest1,true));
        bookingManager.addBooking(new Booking(LocalDate.of(2023,7,18),LocalDate.of(2023,7,21),room2,guest2,false));
        Booking sideBooking = new Booking(LocalDate.of(2023,8,1),LocalDate.of(2023,8,31),room3,guest3,true);
        sideBooking.getGuests().add(guest1);
        bookingManager.addBooking(sideBooking);
        for (int i = 1; i < 20; i = i + 2) {
            bookingManager.addBooking(new Booking(LocalDate.of(2023,8,i),LocalDate.of(2023,8,i+1),room2,guest3,false));
        }
    }
}

