package cz.engeto.hotel;

public class Room {
    private int ID;
    private int beds;
    private int price;
    private boolean balcony;
    private boolean seaView;

    public Room(int ID, int beds, int price, boolean balcony, boolean seaView) {
        this.ID = ID;
        this.beds = beds;
        this.price = price;
        this.balcony = balcony;
        this.seaView = seaView;
    }

    public Room(int ID, int beds, int price)
    {
        this(ID,beds,price,false,false);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }
}
