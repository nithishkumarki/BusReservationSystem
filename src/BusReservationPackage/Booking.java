package BusReservationPackage;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
    String passengerName;
    int busId;
    Date date;

    Booking()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter passenger name");
        passengerName=scanner.nextLine();
        System.out.println("Enter Bus Id");
        busId=scanner.nextInt();

        System.out.println("Enter the date(format dd-mm-yyy)");
        String StringDate=scanner.next();

        try{

            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            date=dateFormat.parse(StringDate);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }

    }




    public boolean isAvailable() throws SQLException
    {
        BusDataAccessObject BDAO=new BusDataAccessObject();
        int capacity=BDAO.getCapacity(busId);

        BookingDataAccessObject BoDAO=new BookingDataAccessObject();
        int booked=BoDAO.getBookedCount(busId,date);


            return booked<capacity ?true:false;
    }

}
