import java.sql.*;
public class Main {
    public static void main(String[] args)
    {
       insertRecord();

    }
      public static void readRecord()
      {
          String url="jdbc:mysql://localhost:3306/nithish";
          String userName="root";
          String passWord="password";
          String query="select * from employee ";

          try {


              // connection is a interface ,drivermanager is a class
              Connection con = DriverManager.getConnection(url, userName, passWord);

              //    - `Statement` is an interface in the `java.sql` package that acts as a vehicle to send SQL statements
              Statement st = con.createStatement();

              //rs is like a pointer
              ResultSet rs = st.executeQuery(query);
              rs.next();//move to next record

              System.out.println("name is " + rs.getInt(1));
              System.out.println("string is " + rs.getString(2));
              System.out.println("date is " + rs.getDouble(3));

              con.close();
          }
          catch(SQLException e)
          {
              System.out.println("Database error: "+e.getMessage());
              e.printStackTrace();//helps to deug the isssue
          }
      }
    public static void insertRecord()
    {
        String url="jdbc:mysql://localhost:3306/nithish";
        String userName="root";
        String passWord="password";
        String query="insert into employee values(1,'nithish',80000000.00)";

        try{

        Connection con=DriverManager.getConnection(url,userName,passWord);
        Statement st=con.createStatement();
        int rows=st.executeUpdate(query);
        System.out.println("Record inserted"+rows);
        con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database error:"+e);
        }


    }
}