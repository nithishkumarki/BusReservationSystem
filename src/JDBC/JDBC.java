package JDBC;

import java.sql.*;
public class JDBC
{
    public static void main(String[] args)
    {
//       insertRecord();
//       insertRecordByPreparedStatement();
        try {


//            DeleteRecord();
//            readRecord();
//            sp();
            sp2();
        }
        catch (Exception e)
        {e.printStackTrace();}

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
            //move to next record
            while(rs.next())
            {
                System.out.println("id :     " + rs.getInt(1));
                System.out.println("name :   " + rs.getString(2));
                System.out.println("salary : " + rs.getDouble(3));

            }

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

        /* String query="insert into employee values(1,'nithish',80000000.00)";*/
        int id=2;
        String name="MalarSelvi";
        double salary=10000000.00;
        String query="insert into employee values("+id+",'"+name+"',"+salary+")";


        try{

            Connection con=DriverManager.getConnection(url,userName,passWord);
            Statement st=con.createStatement();// like con to statemtement ->statemt is readign sql statement
            int rows=st.executeUpdate(query);
            System.out.println("Record inserted"+rows);
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database error:"+e);
        }


    }

    public static void DeleteRecord()
    {
        String url="jdbc:mysql://localhost:3306/nithish";
        String userName="root";
        String passWord="password";

        /* String query="insert into employee values(1,'nithish',80000000.00)";*/
        int id=3;
        String query="delete from employee where rollno = "+id;


        try{

            Connection con=DriverManager.getConnection(url,userName,passWord);
            Statement st=con.createStatement();// like con to statemtement ->statemt is readign sql statement
            int rows=st.executeUpdate(query);
            System.out.println("Record deleted"+rows);
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database error:"+e);
        }


    }
    public static void insertRecordByPreparedStatement()
    {
        String url="jdbc:mysql://localhost:3306/nithish";
        String userName="root";
        String passWord="password";

        /* String query="insert into employee values(1,'nithish',80000000.00)";*/
        int id=3;
        String name="Keerthivasan";
        double salary=10000000.00;
        String query="insert into employee values(?,?,?);";


        try{

            Connection con=DriverManager.getConnection(url,userName,passWord);
            PreparedStatement ps=con.prepareStatement(query);// like con to statemtement ->statemt is readign sql statement

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setDouble(3,salary);
            int rows=ps.executeUpdate();
            System.out.println("Record inserted"+rows);
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database error:"+e);
        }


    }

    public static void sp() throws Exception
    {
        String url="jdbc:mysql://localhost:3306/nithish";
        String userName="root";
        String passWord="password";


        Connection con=DriverManager.getConnection(url,userName,passWord);
        CallableStatement cst=con.prepareCall("{call GetEmp()}");
        ResultSet rs=cst.executeQuery();
        while(rs.next())
        {
            System.out.println("id :     " + rs.getInt(1));
            System.out.println("name :   " + rs.getString(2));
            System.out.println("salary : " + rs.getDouble(3));

        }

        con.close();
    }
    public static void sp2() throws Exception
    {
        String url="jdbc:mysql://localhost:3306/nithish";
        String userName="root";
        String passWord="password";


        Connection con=DriverManager.getConnection(url,userName,passWord);
        CallableStatement cst=con.prepareCall("{call GetEmpByIdOutputName(?,?)}");
        cst.setInt(1,2);
        cst.registerOutParameter(2,Types.VARCHAR);
        cst.executeUpdate();
        System.out.println(cst.getString(2));

        con.close();
    }
}