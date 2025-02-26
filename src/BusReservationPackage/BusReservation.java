package BusReservationPackage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class BusReservation
{
    public static void main(String[] args){
      try {


          BusDataAccessObject BDAO = new BusDataAccessObject();
          BDAO.displayBusInfo();

          int userOpt = 1;
          Scanner scanner = new Scanner(System.in);

          while (userOpt == 1) {
              System.out.println("Enter 1 to Book and 2 to Exit");

              userOpt = scanner.nextInt();
              if (userOpt == 1)
              {
                  Booking booking = new Booking();
                  if (booking.isAvailable())
                  {
                      System.out.println("Available");
                      BookingDataAccessObject BoDAO = new BookingDataAccessObject();
                      BoDAO.addBooking(booking);
                      System.out.println("Booked Successful");
                  }
                  else {
                      System.out.println("Booking not possible");
                  }
              }

          }
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
    }
}
