package cz.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();
    public void addBooking(Booking booking)
    {
        bookings.add(booking);
    }

    public Booking getBooking(int index)
    {
        return bookings.get(index);
    }

    public List<Booking> getBookings()
    {
        return bookings;
    }
    public void clearBookings()
    {
        bookings.clear();
    }
    
    public int getNumberOfWorkingBookings()
    {
        int count = 0;
        for (Booking booking : bookings) {
            if(booking.isBusinessTrip())
            {
                count++;
            }
        }
        return count;
    }

    public double getAverageGuests()
    {
        double count = 0;
        for (Booking booking : bookings) {
            count += booking.getGuests().size();
        }
        count /= bookings.size();
        return count;
    }

    public List<Booking> getTopNHolidayBookings(int max)
    {
        List<Booking> topBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if(!booking.isBusinessTrip())
            {
                topBookings.add(booking);
                if(topBookings.size()==max)
                {
                    break;
                }
            }
        }
        return topBookings;
    }

    public void printGuestStatistics()
    {
        int single = 0;
        int couple = 0;
        int many = 0;
        for (Booking booking : bookings) {
            switch (booking.getGuests().size())
            {
                case 1:
                    single++;
                    break;
                case 2:
                    couple++;
                    break;
                default:
                    many++;
            }
        }
        System.out.println("Statistiky hostů: ");
        if(single==0)
        {
            System.out.println("Žádná rezervace pro jednoho hosta");
        } else if (single<5) {
            System.out.println("" + single + " rezervace pro jednoho hosta");
        }
        else
        {
            System.out.println("" + single + " rezervací pro jednoho hosta");
        }
        if(couple==0)
        {
            System.out.println("Žádná rezervace pro dva hosty");
        } else if (couple<5) {
            System.out.println("" + couple + " rezervace pro dva hosty");
        }
        else
        {
            System.out.println("" + couple + " rezervací pro dva hosty");
        }
        if(many==0)
        {
            System.out.println("Žádná rezervace pro více hostů");
        } else if (many<5) {
            System.out.println("" + many + " rezervace pro více hostů");
        }
        else
        {
            System.out.println("" + many + " rezervací pro více hostů");
        }
    }

}
