import java.sql.*;
public class Main {
    public static void main(String[] args)
    {
        String url="jdbc:mysql://localhost:3306/nithish";
        String userName="root";
        String passWord="password";
        String query="select * from fruit ";

        try {


            // connection is a interface ,drivermanager is a class
            Connection con = DriverManager.getConnection(url, userName, passWord);

            //    - `Statement` is an interface in the `java.sql` package that acts as a vehicle to send SQL statements
            Statement st = con.createStatement();

            //rs is like a pointer
            ResultSet rs = st.executeQuery(query);
            rs.next();//move to next record

            System.out.println("name is " + rs.getString(1));
            System.out.println("string is " + rs.getString(3));
            System.out.println("date is " + rs.getDate(4));

            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database error: "+e.getMessage());
            e.printStackTrace();//helps to deug the isssue
        }

    }
}