package BusReservationPackage;
import java.sql.*;
import java.util.*;
public class BusDataAccessObject {

      public void displayBusInfo()throws SQLException
      {
          String query="select * from bus";

          Connection con=DBConnection.getConnection();
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery(query);

          while(rs.next())
          {
              System.out.println("Bus No: "+rs.getInt(1));
              if(rs.getInt(2)==0)
              {
                  System.out.println("AC: NO");
              }
              else{
                  System.out.println("AC: Yes");

              }
              System.out.println("Bus capacity: "+rs.getInt(3));
          }
          System.out.println();
//          System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//          System.out.println();

      }

      public int getCapacity(int busId)throws SQLException
      {
          String query="select capacity from bus where busId="+busId;
          Connection con=DBConnection.getConnection();
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery(query);
          rs.next();
          return rs.getInt(1);
      }
}
