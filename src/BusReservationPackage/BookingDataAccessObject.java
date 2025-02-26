package BusReservationPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class BookingDataAccessObject {

    public int getBookedCount(int busId,Date date)throws SQLException
    {
        String query="select count(name) from booking where bus_Id=? and travel_date=?";

        Connection co=DBConnection.getConnection();
        PreparedStatement ps=co.prepareStatement(query);

        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        ps.setInt(1,busId);
        ps.setDate(2,sqldate);

        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);

    }

    public void addBooking(Booking booking)throws  SQLException
    {
        String query="insert into booking values(?,?,?)";
        Connection co=DBConnection.getConnection();
        PreparedStatement ps=co.prepareStatement(query);
        ps.setString(1,booking.passengerName);
        ps.setInt(2,booking.busId);
        java.sql.Date sqlDate=new java.sql.Date(booking.date.getTime());
        ps.setDate(3,sqlDate);
        ps.executeUpdate();
    }
}
