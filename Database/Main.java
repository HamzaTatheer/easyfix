package com.company;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main implements DB_interface {

    public boolean does_customer_exist(int id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from customers where id = "+id);
            if(!rs.next())
            {
                return false;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public int does_customer_exist(String email,String password)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from customers where email = "+email+"and password = "+password);
            if(!rs.next())
            {
                return -1;
            }
            else {
                while (rs.next()) {
                    return rs.getInt("id");
                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
     return 0;
    }

    public boolean store_customer(String name, String email, String password, String credit_no, float wallet, String city, String area, ArrayList<Integer> favourite)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO customers(name,email,password,credit_no,wallet,city,area) " + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setString(2,email);
            pstmt.setString(3,password);
            pstmt.setString(4,credit_no);
            pstmt.setFloat(5,wallet);
            pstmt.setString(6,city);
            pstmt.setString(7,area);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                String sql2 = "INSERT INTO favorite(id,favourite) " + "VALUES(?,?)";
                PreparedStatement pstmt2 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ArrayList<Integer> a;
                int iid=does_customer_exist(email,password);
               for(int i=0;i<favourite.size();i++)
               {

                   pstmt2.setInt(1, iid);
                   pstmt2.setInt(2,favourite.get(i));
                   int rowAffected2 = pstmt2.executeUpdate();
               }



               return true;
            }





        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }//id given by default by DB



    public boolean update_customer_city(int id,String city)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update customers set city = ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,city);
            pstmt.setInt(2,id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update_customer_area(int id,String area)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update customers set area = ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,area);
            pstmt.setInt(2,id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update_customerPayment(int id,String payment)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update customers set credit_no = ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,payment);
            pstmt.setInt(2,id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public CustomerModel get_customer(int id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from customers where id = "+ id);

            CustomerModel c1=new CustomerModel();
                while (rs.next()) {

                    c1.id=id;
                    c1.name=rs.getString("name");
                    c1.email=rs.getString("email");
                    c1.password=rs.getString("password");
                    c1.creditno=rs.getString("credit_no");
                    c1.wallet=rs.getFloat("wallet");
                    c1.city=rs.getString("city");
                    c1.area=rs.getString("area");


            }

            Statement mystmt2 = conn.createStatement();

            ResultSet rs2 = mystmt2.executeQuery("select * from favorite where id = "+id  );

            int workerid;


            int j=0;
            while (rs2.next())
            {
                workerid=rs2.getInt("favourite");

                c1.Favourite.add(get_worker(workerid));// get funtion
            }

            return c1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean store_worker(String name,String email,String password,float average_rating,float hourly_rate,String city,String area,String speciality)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO customers(name,email,password,average_rating,hourly_rate,city,area,speciality) " + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setString(2,email);
            pstmt.setString(3,password);
            pstmt.setFloat(4,average_rating);
            pstmt.setFloat(5,hourly_rate);
            pstmt.setString(6,city);
            pstmt.setString(7,area);
            pstmt.setString(8,speciality);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {

                return true;
            }





        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }//id given by default by DB



    public WorkerModel get_worker(int id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from worker where wid = "+ id);
            WorkerModel c1=new WorkerModel();

            while (rs.next()) {

                c1.id=id;
                c1.name=rs.getString("name");
                c1.email=rs.getString("email");
                c1.password=rs.getString("password");
                c1.avgRating=rs.getFloat("average_rating");
                c1.hourlyRate=rs.getFloat("wallet");
                c1.city=rs.getString("city");
                c1.area=rs.getString("area");
                c1.speciality=rs.getString("speciality");


            }
            return c1;




        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public int does_worker_exist(String email,String password)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from worker where email = "+email+"and password = "+password);
            if(!rs.next())
            {
                return -1;
            }
            else {
                while (rs.next()) {
                    return rs.getInt("wid");
                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean does_worker_exist(int id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from worker where wid = "+id);
            if(!rs.next())
            {
                return false;
            }
            else return true;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }


    public ArrayList<WorkerModel> get_worker(String city,String area)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from worker where city = "+ city + "and area = "+area);
            //WorkerModel c1=new WorkerModel();
            ArrayList<WorkerModel> c1=new ArrayList<WorkerModel>();
            int i=0;
            while (rs.next()) {

                c1.get(i).id= rs.getInt("id");
                c1.get(i).name=rs.getString("name");
                c1.get(i).email=rs.getString("email");
                c1.get(i).password=rs.getString("password");
                c1.get(i).avgRating=rs.getFloat("average_rating");
                c1.get(i).hourlyRate=rs.getFloat("wallet");
                c1.get(i).city=rs.getString("city");
                c1.get(i).area=rs.getString("area");
                c1.get(i).speciality=rs.getString("speciality");
                i++;


            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<WorkerModel> get_all_worker()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from worker ");
            //WorkerModel c1=new WorkerModel();
            ArrayList<WorkerModel> c1=new ArrayList<WorkerModel>();
            int i=0;
            while (rs.next()) {

                c1.get(i).id= rs.getInt("id");
                c1.get(i).name=rs.getString("name");
                c1.get(i).email=rs.getString("email");
                c1.get(i).password=rs.getString("password");
                c1.get(i).avgRating=rs.getFloat("average_rating");
                c1.get(i).hourlyRate=rs.getFloat("wallet");
                c1.get(i).city=rs.getString("city");
                c1.get(i).area=rs.getString("area");
                c1.get(i).speciality=rs.getString("speciality");
                i++;


            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public boolean update_Worker_city(int id,String city)
    {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update worker set city = ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,city);
            pstmt.setInt(2,id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
    public boolean update_Worker_area(int id,String area)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update worker set area = ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,area);
            pstmt.setInt(2,id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean update_hourly_rate(int id,float rate)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update worker set hourly_rate = ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setFloat(1,rate);
            pstmt.setInt(2,id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public int get_bid(int customer_id, int worker_id, String text)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where customer_id = "+customer_id+"and worker_id = "+worker_id+"and booking_text = "+text);
            if(!rs.next())
            {
                return -1;
            }
            else {
                while (rs.next()) {
                    return rs.getInt("bid");
                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean store_booking(int customer_id, int worker_id, String text, String status, LocalDateTime start_time, LocalDateTime end_time, ArrayList<Integer> spareParts)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO customers(customer_id,worker_id,booking_text,booking_status,) " + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, customer_id);
            pstmt.setInt(2,worker_id);
            pstmt.setString(3,text);
            pstmt.setString(4,status);
            pstmt.setTimestamp(5, Timestamp.valueOf(start_time));
            pstmt.setTimestamp(6, Timestamp.valueOf(end_time));



            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                String sql2 = "INSERT INTO spare_booking(bid,part_id) " + "VALUES(?,?)";
                PreparedStatement pstmt2 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ArrayList<Integer> a;
                int iid=get_bid(customer_id,worker_id,text);
                for(int i=0;i<spareParts.size();i++)
                {

                    pstmt2.setInt(1, iid);
                    pstmt2.setInt(2,spareParts.get(i));
                    int rowAffected2 = pstmt2.executeUpdate();
                }
                return true;
            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }//bid given by default by DB


    public  ArrayList<BookingModel> get_booking(int customer_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where customer_id = "+ customer_id );
            //WorkerModel c1=new WorkerModel();
            ArrayList<BookingModel> c1=new ArrayList<BookingModel>();

            int i=0;
            while (rs.next()) {

                c1.get(i).id= rs.getInt("bid");
                c1.get(i).customerName=get_customer(rs.getInt("customer_id"));
                c1.get(i).workerName=get_worker(rs.getInt("worker_id"));
                c1.get(i).text=rs.getString("booking_text");
                c1.get(i).status=rs.getString("booking_status");
                c1.get(i).startTime=rs.getTimestamp("start_time");
                c1.get(i).endTime=rs.getTimestamp("end_time");

                i++;

                Statement mystmt2 = conn.createStatement();

                ResultSet rs2 = mystmt2.executeQuery("select * from booking_sparepart where bid = "+rs.getInt("bid")  );

                SparePartModel s1=new SparePartModel();
                int partid;


                int j=0;
                while (rs2.next())
                {
                    partid=rs2.getInt("part_id");

                    c1.get(i).spareParts.add(get_spare_part(partid));// get spare part function
                }




            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add_favourite(int customer_id,int worker_id)
    {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

                String sql = "INSERT INTO favorite(id,favourite) " + "VALUES(?,?)";
                PreparedStatement pstmt2 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


                    pstmt2.setInt(1, customer_id);
                    pstmt2.setInt(2,worker_id);
                    int rowAffected2 = pstmt2.executeUpdate();


                return true;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    public boolean remove_favourite(int customer_id,int worker_id)
    {

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "DELETE FROM favorite where customer_id = ? and worker_id = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt2.setInt(1, customer_id);
            pstmt2.setInt(2,worker_id);
            int rowAffected2 = pstmt2.executeUpdate();


            return true;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    public ArrayList<BookingModel> get_booking(int customer_id,String status)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where customer_id = "+ customer_id + "and status = " + status);
            //WorkerModel c1=new WorkerModel();
            ArrayList<BookingModel> c1=new ArrayList<BookingModel>();

            int i=0;
            while (rs.next()) {

                c1.get(i).id= rs.getInt("bid");
                c1.get(i).customerName=get_customer(rs.getInt("customer_id"));
                c1.get(i).workerName=get_worker(rs.getInt("worker_id"));
                c1.get(i).text=rs.getString("booking_text");
                c1.get(i).status=rs.getString("booking_status");
                c1.get(i).startTime=rs.getTimestamp("start_time");
                c1.get(i).endTime=rs.getTimestamp("end_time");

                i++;

                Statement mystmt2 = conn.createStatement();

                ResultSet rs2 = mystmt2.executeQuery("select * from booking_sparepart where bid = "+rs.getInt("bid")  );

                SparePartModel s1=new SparePartModel();
                int partid;


                int j=0;
                while (rs2.next())
                {
                    partid=rs2.getInt("part_id");

                    c1.get(i).spareParts.add(get_spare_part(partid));// get spare part function
                }




            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean store_customer_billing(int booking_id,int worker_id,int cost)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO billing(bid,totalcost) " + "VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, booking_id);
            pstmt.setInt(2,cost);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {

                return true;
            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }//int billing_id, given by DB


    public ArrayList<BillingModel> get_customer_billing(int booking_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from billing where bid = "+ booking_id );

            ArrayList<BillingModel> c1=new ArrayList<BillingModel>();

            int i=0;
            while (rs.next()) {

                c1.get(i).id= rs.getInt("id");
                c1.get(i).bid=rs.getInt("bid");
                c1.get(i).totalCost=rs.getInt("totalcost");

                i++;

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public boolean store_complaint(int customer_id,int worker_id,String complain_text)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO complain(cid,bid,complain_text) " + "VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, customer_id);
            pstmt.setInt(2,worker_id);
            pstmt.setString(3,complain_text);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {

                return true;
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }//int complain_id, given by DB


    public  ComplainModel get_complaint(int complaint_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from complain where id = "+ complaint_id );

            //ArrayList<ComplainModel> c1=new ArrayList<ComplainModel>();
            ComplainModel c1=new ComplainModel();


            while (rs.next()) {

                c1.id= rs.getInt("id");
                c1.cid=rs.getInt("cid");
                c1.wid=rs.getInt("wid");
                c1.text=rs.getString("complain_text");


            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<ComplainModel> show_all_complaint(int customer_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from complain where cid = "+ customer_id );

            ArrayList<ComplainModel> c1=new ArrayList<ComplainModel>();

            int i=0;
            while (rs.next()) {

                c1.get(i).id= rs.getInt("id");
                c1.get(i).cid=rs.getInt("cid");
                c1.get(i).wid=rs.getInt("wid");
                c1.get(i).text=rs.getString("complain_text");

                i++;

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean store_spar_parts(String name,float cost,int quantity)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO sparepart(part_name,cost,quantity) " + "VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setFloat(2,cost);
            pstmt.setInt(3,quantity);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {

                return true;
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }//int spare_id, given by DB



    public static Connection getconnection() throws Exception
{
    try {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/easyfix";
        String username = "root";
        String password = "elektra";

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("connected");
        return conn;

    } catch (Exception e){ System.out.println(e); }




    return null;
}

    public  SparePartModel get_spare_part(int part_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from sparepart where id = "+ part_id );

            //ArrayList<ComplainModel> c1=new ArrayList<ComplainModel>();
            SparePartModel c1=new SparePartModel();


            while (rs.next()) {

                c1.id= rs.getInt("id");
                c1.name=rs.getString("part_name");
                c1.cost=rs.getFloat("cost");
                c1.quantity=rs.getInt("quantity");


            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<SparePartModel> get_all_parts()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from sparepart where quantity > 0 " );

            ArrayList<SparePartModel> c1=new ArrayList<SparePartModel>();

            int i=0;
            while (rs.next()) {

                c1.get(i).id= rs.getInt("id");
                c1.get(i).name=rs.getString("part_name");
                c1.get(i).cost=rs.getFloat("cost");
                c1.get(i).quantity=rs.getInt("quantity");


                i++;

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }//for quantity>0

    public boolean deduct_part(int spare_id,int quantity)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update sparepart set quantity = quantity - ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1,quantity);
            pstmt.setInt(2,spare_id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }


    public boolean store_rating(int customer_id,int worker_id,int rating)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO rating(cid,wid,rate) " + "VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, customer_id);
            pstmt.setInt(2,worker_id);
            pstmt.setInt(3,rating);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {

                return true;
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public float get_avg_rating(int worker_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select avg(rating) from rating where wid = "+ worker_id );


            float i=0;
            while (rs.next()) {

                i= rs.getFloat(0);

            }
            return i;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }


    public ArrayList<RatingModel> getAllRatings(int customer_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from rating where cid = "+ customer_id );

            ArrayList<RatingModel> c1=new ArrayList<RatingModel>();

            int i=0;
            while (rs.next()) {


                c1.get(i).cid=rs.getInt("cid");
                c1.get(i).wid=rs.getInt("wid");
                c1.get(i).rating=rs.getInt("rate");

                i++;

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public  boolean store_chat( int senderId, int receiverId, String senderName, String receiverName, String message)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO char(senderId,receiverId,senderName,receiverName,message) " + "VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, senderId);
            pstmt.setInt(2,receiverId);
            pstmt.setString(3,senderName);
            pstmt.setString(4,receiverName);
            pstmt.setString(5,message);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {

                return true;
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<ChatMessageModel> get_chat_history(int customer_id,int worker_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from chat where senderId = "+ customer_id +"and receiverId = "+worker_id);

            ArrayList<ChatMessageModel> c1=new ArrayList<ChatMessageModel>();

            int i=0;
            while (rs.next()) {


                c1.get(i).senderId=rs.getInt("senderId");
                c1.get(i).receiverId=rs.getInt("receiverId");
                c1.get(i).senderName=rs.getString("senderName");
                c1.get(i).receiverName=rs.getString("receiverName");
                c1.get(i).message=rs.getString("message");

                i++;

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) {
	// write your code here


        ArrayList<Integer> fav=new ArrayList<Integer>();
        fav.add(100);
        fav.add(200);
        int id=1;
        String city="islamabad";




    }
}
