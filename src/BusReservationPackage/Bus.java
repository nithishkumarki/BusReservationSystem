package BusReservationPackage;

public class Bus {
    private int busId;
    private boolean AC;
    private int capacity;

    Bus(int busId,boolean AC,int capacity)
    {
        this.busId=busId;
        this.AC=AC;
        this.capacity=capacity;
    }

    public int getBusId()
    {
        return busId;
    }

    public boolean isAc()
    {
        return AC;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setAc(boolean val) {
      AC = val;
    }
    public void displayBusInfo(){
        System.out.println("Bus Id: "+busId+" AC: "+AC+" Capacity: "+capacity);
    }
}
