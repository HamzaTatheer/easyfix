package com.easyfix.Application.db.sqlDb;

import com.easyfix.Application.models.*;
import com.easyfix.Application.db.services.DbService;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class SqlDbManager implements DbService {


    public  ArrayList<BookingModel> get_booking(int bid)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where bid = "+ bid);
            //WorkerModel c1=new WorkerModel();
            ArrayList<BookingModel> c1=new ArrayList<BookingModel>();


            int i=0;
            while (rs.next()) {
                BookingModel c2=new BookingModel();
                c2.id= rs.getInt("bid");
                c2.cid=rs.getInt("customer_id");
                c2.wid=rs.getInt("worker_id");
                c2.text=rs.getString("booking_text");
                c2.status=rs.getString("booking_status");

                Time st=rs.getTime("start_time");
                Time et=rs.getTime("end_time");
                Date sd=rs.getDate("start_date");
                Date ed=rs.getDate("end_date");
                String ss= String.valueOf(sd)+" "+String.valueOf(st);
                String ee= String.valueOf(ed)+" "+String.valueOf(et);


                DateTimeFormatter formator=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                c2.startTime=LocalDateTime.parse(ss,formator);
                c2.endTime=LocalDateTime.parse(ee,formator);
                c1.add(c2);

                //i++;

                Statement mystmt2 = conn.createStatement();

                ResultSet rs2 = mystmt2.executeQuery("select * from booking_spareparts where bid = "+rs.getInt("bid")  );

                //SparePartModel s1=new SparePartModel();
                int partid;


                c2.spareParts=new ArrayList<Integer>();

                while (rs2.next())
                {
                    partid=rs2.getInt("part_id");

                    //c1.get(i).spareParts.add(get_spare_part(partid));// get spare part function
                    c2.spareParts.add(partid);
                    c1.add(c2);
                }




            }

            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean update_average_rating(int id, float rate)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update worker set average_rating = ? where wid = ?" ;
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

    public boolean does_customer_exist(int id)//done
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

    public int does_customer_exist(String email,String password)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from customers where email = '" + email + "' and password = '" + password + "' ");

            while (rs.next())
            {
                System.out.println( rs.getInt("id"));
                return rs.getInt("id");

            }

            if(!rs.next())
            {
                return -1;
            }




        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean store_customer(String name, String email, String password, String credit_no,String paymentMethod, float wallet, String city, String area, ArrayList<Integer> favourite)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO customers(name,email,password,credit_no,wallet,city,area) " + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setString(2,email);
            pstmt.setString(3,password);
            pstmt.setString(4,paymentMethod);
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



    public boolean update_customer_city(int id,String city)//done
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

    public boolean update_customer_area(int id,String area)//done
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

    public boolean update_customerPayment(int id,String payment)//done
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


    public CustomerModel get_customer(int id)//done
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
                c1.paymentMethod=rs.getString("credit_no");

            }

            Statement mystmt2 = conn.createStatement();

            ResultSet rs2 = mystmt2.executeQuery("select * from favorite where id = "+id  );
            int workerid;

            int j=0;
            c1.Favourite=new ArrayList<Integer>();
            while (rs2.next())
            {
                workerid=rs2.getInt("favourite");

                c1.Favourite.add(workerid);// get funtion
            }

            return c1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean store_worker(String name,String email,String password,float average_rating,float hourly_rate,String city,String area,String speciality)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO worker(name,email,password,average_rating,hourly_rate,city,area,speciality) " + "VALUES(?,?,?,?,?,?,?,?)";
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



    public WorkerModel get_worker(int id)//done
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
                c1.hourlyRate=rs.getFloat("hourly_rate");
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


    public int does_worker_exist(String email,String password)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from worker where email = '"+email+"' and password = '"+password+"'");

            if (rs.next()) {
                return rs.getInt("wid");
            }


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
    public boolean does_worker_exist(int id)//done
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


    public ArrayList<WorkerModel> get_worker(String city,String area)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from worker where city = '"+ city + "' and area = '"+area + "'");
            //WorkerModel c1=new WorkerModel();
            ArrayList<WorkerModel> c1=new ArrayList<WorkerModel>();
            WorkerModel c2=new WorkerModel();

            int i=0;
            while (rs.next()) {

                c2.id= rs.getInt("wid");

                System.out.println("id "+c2.id);
                c2.name=rs.getString("name");
                c2.email=rs.getString("email");
                c2.password=rs.getString("password");
                c2.avgRating=rs.getFloat("average_rating");
                c2.hourlyRate=rs.getFloat("hourly_rate");
                c2.city=rs.getString("city");
                c2.area=rs.getString("area");
                c2.speciality=rs.getString("speciality");
                c1.add(c2);

                //i++;


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
                WorkerModel c2=new WorkerModel();
                //System.out.println("id "+c2.id);
                c2.id=rs.getInt("wid");
                c2.name=rs.getString("name");
                c2.email=rs.getString("email");
                c2.password=rs.getString("password");
                c2.avgRating=rs.getFloat("average_rating");
                c2.hourlyRate=rs.getFloat("hourly_rate");
                c2.city=rs.getString("city");
                c2.area=rs.getString("area");
                c2.speciality=rs.getString("speciality");
                c1.add(c2);
                //System.out.println(c1.get(i).id);
                //i++;



            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    public boolean update_Worker_city(int id,String city)//done
    {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update worker set city = ? where wid = ?" ;
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
    public boolean update_Worker_area(int id,String area)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update worker set area = ? where wid = ?" ;
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
    public boolean update_hourly_rate(int id,float rate)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update worker set hourly_rate = ? where wid = ?" ;
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


    public int get_bid(int customer_id, int worker_id, String text)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where customer_id = '" + customer_id+"'" + " and worker_id = '" + worker_id +" ' and booking_text = '"+text+"'" );
            if(rs.next())
            {
                return rs.getInt("bid");
            }
            if(!rs.next())
            {
                return -1;
            }
            else {
                System.out.println("else");
                while (rs.next()) {
                    System.out.println("while loop");
                    return rs.getInt("bid");
                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int store_booking(int customer_id, int worker_id, String text, String status, LocalDateTime start_time, LocalDateTime end_time, ArrayList<Integer> spareParts)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO booking(customer_id,worker_id,booking_text,booking_status,start_time,end_time,start_date,end_date) " + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, customer_id);
            pstmt.setInt(2,worker_id);
            pstmt.setString(3,text);
            pstmt.setString(4,status);
            pstmt.setTime(5, Time.valueOf(start_time.toLocalTime()));
            pstmt.setTime(6, Time.valueOf(end_time.toLocalTime()));
            pstmt.setDate(7, Date.valueOf(start_time.toLocalDate()));
            pstmt.setDate(8, Date.valueOf(end_time.toLocalDate()));


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
                return get_bid(customer_id,worker_id,text);
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }//bid given by default by DB


    public ArrayList<BookingModel> get_booking_of_customer(int customer_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where customer_id = "+ customer_id );
            //WorkerModel c1=new WorkerModel();
            ArrayList<BookingModel> c1=new ArrayList<BookingModel>();


            int i=0;
            while (rs.next()) {
                BookingModel c2=new BookingModel();
                c2.id= rs.getInt("bid");
                c2.cid=rs.getInt("customer_id");
                c2.wid=rs.getInt("worker_id");
                c2.text=rs.getString("booking_text");
                c2.status=rs.getString("booking_status");

                Time st=rs.getTime("start_time");
                Time et=rs.getTime("end_time");
                Date sd=rs.getDate("start_date");
                Date ed=rs.getDate("end_date");
                String ss= String.valueOf(sd)+" "+String.valueOf(st);
                String ee= String.valueOf(ed)+" "+String.valueOf(et);


                DateTimeFormatter formator=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                c2.startTime=LocalDateTime.parse(ss,formator);
                c2.endTime=LocalDateTime.parse(ee,formator);


                c1.add(c2);

                //i++;

                Statement mystmt2 = conn.createStatement();

                ResultSet rs2 = mystmt2.executeQuery("select * from booking_spareparts where bid = "+rs.getInt("bid")  );

                //SparePartModel s1=new SparePartModel();
                int partid;


                c2.spareParts=new ArrayList<Integer>();
                while (rs2.next())
                {
                    partid=rs2.getInt("part_id");

                    //c1.get(i).spareParts.add(get_spare_part(partid));// get spare part function
                    c2.spareParts.add(partid);
                    c1.add(c2);
                }




            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<BookingModel> get_booking_of_customer(int customer_id,String status)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where customer_id = "+ customer_id + " and booking_status = '" + status+"'");
            //WorkerModel c1=new WorkerModel();
            ArrayList<BookingModel> c1=new ArrayList<BookingModel>();


            int i=0;
            while (rs.next()) {
                BookingModel c2=new BookingModel();
                c2.id= rs.getInt("bid");
                c2.cid=rs.getInt("customer_id");
                c2.wid=rs.getInt("worker_id");
                c2.text=rs.getString("booking_text");
                c2.status=rs.getString("booking_status");

                Time st=rs.getTime("start_time");
                Time et=rs.getTime("end_time");
                Date sd=rs.getDate("start_date");
                Date ed=rs.getDate("end_date");
                String ss= String.valueOf(sd)+" "+String.valueOf(st);
                String ee= String.valueOf(ed)+" "+String.valueOf(et);


                DateTimeFormatter formator=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                c2.startTime=LocalDateTime.parse(ss,formator);
                c2.endTime=LocalDateTime.parse(ee,formator);
                c1.add(c2);

                //i++;

                Statement mystmt2 = conn.createStatement();

                ResultSet rs2 = mystmt2.executeQuery("select * from booking_spareparts where bid = "+rs.getInt("bid")  );

                //SparePartModel s1=new SparePartModel();
                int partid;


                c2.spareParts=new ArrayList<Integer>();

                while (rs2.next())
                {
                    partid=rs2.getInt("part_id");

                    //c1.get(i).spareParts.add(get_spare_part(partid));// get spare part function
                    c2.spareParts.add(partid);
                    c1.add(c2);
                }




            }

            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<BookingModel> get_booking_of_worker(int worker_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where worker_id = "+ worker_id );
            //WorkerModel c1=new WorkerModel();
            ArrayList<BookingModel> c1=new ArrayList<BookingModel>();
            BookingModel c2=new BookingModel();

            int i=0;
            while (rs.next()) {

                c2.id= rs.getInt("bid");
                c2.cid=rs.getInt("customer_id");
                c2.wid=rs.getInt("worker_id");
                c2.text=rs.getString("booking_text");
                c2.status=rs.getString("booking_status");

                Time st=rs.getTime("start_time");
                Time et=rs.getTime("end_time");
                Date sd=rs.getDate("start_date");
                Date ed=rs.getDate("end_date");
                String ss= String.valueOf(sd)+" "+String.valueOf(st);
                String ee= String.valueOf(ed)+" "+String.valueOf(et);


                DateTimeFormatter formator=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                c2.startTime=LocalDateTime.parse(ss,formator);
                c2.endTime=LocalDateTime.parse(ee,formator);
                c1.add(c2);

                //i++;

                Statement mystmt2 = conn.createStatement();

                ResultSet rs2 = mystmt2.executeQuery("select * from booking_spareparts where bid = "+rs.getInt("bid")  );

                //SparePartModel s1=new SparePartModel();
                int partid;


                c2.spareParts=new ArrayList<Integer>();
                while (rs2.next())
                {
                    partid=rs2.getInt("part_id");

                    //c1.get(i).spareParts.add(get_spare_part(partid));// get spare part function
                    c2.spareParts.add(partid);
                    c1.add(c2);
                }




            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<BookingModel> get_booking_of_worker(int worker_id, String status)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from booking where worker_id = "+ worker_id + " and booking_status = '" + status+"'");
            //WorkerModel c1=new WorkerModel();
            ArrayList<BookingModel> c1=new ArrayList<BookingModel>();
            BookingModel c2=new BookingModel();

            int i=0;
            while (rs.next()) {

                c2.id= rs.getInt("bid");
                c2.cid=rs.getInt("customer_id");
                c2.wid=rs.getInt("worker_id");
                c2.text=rs.getString("booking_text");
                c2.status=rs.getString("booking_status");

                Time st=rs.getTime("start_time");
                Time et=rs.getTime("end_time");
                Date sd=rs.getDate("start_date");
                Date ed=rs.getDate("end_date");
                String ss= String.valueOf(sd)+" "+String.valueOf(st);
                String ee= String.valueOf(ed)+" "+String.valueOf(et);


                DateTimeFormatter formator=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                c2.startTime=LocalDateTime.parse(ss,formator);
                c2.endTime=LocalDateTime.parse(ee,formator);
                c1.add(c2);

                //i++;

                Statement mystmt2 = conn.createStatement();

                ResultSet rs2 = mystmt2.executeQuery("select * from booking_spareparts where bid = "+rs.getInt("bid")  );

                //SparePartModel s1=new SparePartModel();
                int partid;


                c2.spareParts=new ArrayList<Integer>();

                while (rs2.next())
                {
                    partid=rs2.getInt("part_id");

                    //c1.get(i).spareParts.add(get_spare_part(partid));// get spare part function
                    c2.spareParts.add(partid);
                    c1.add(c2);
                }




            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean add_favourite(int customer_id,int worker_id)//done
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



    public boolean remove_favourite(int customer_id,int worker_id)//done
    {

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "DELETE FROM favorite where id = ? and favourite = ?";
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




    public boolean store_customer_billing(int booking_id,String title,int cid,int wid,String status,Float totalCost)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO billing(bid,title,cid,wid,status,totalcost) " + "VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, booking_id);
            pstmt.setString(2,title);
            pstmt.setInt(3, cid);
            pstmt.setInt(4,wid);
            pstmt.setString(5,status);
            pstmt.setFloat(6,totalCost);


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
                BillingModel c2=new BillingModel();
                c2.bookingId= rs.getInt("bid");
                c2.title=rs.getString("title");
                c2.cid= rs.getInt("cid");
                c2.wid= rs.getInt("wid");
                c2.status=rs.getString("status");
                c2.totalCost=rs.getFloat("totalcost");
                c1.add(c2);

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public  BillingModel get_bill(int booking_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from billing where bid = "+ booking_id );

            //ArrayList<BillingModel> c1=new ArrayList<BillingModel>();
            BillingModel c2=new BillingModel();

            int i=0;
            if(!rs.next())
            {
                return null;
            }

            while (rs.next()) {

                c2.bookingId= rs.getInt("bid");
                c2.title=rs.getString("title");
                c2.cid= rs.getInt("cid");
                c2.wid= rs.getInt("wid");
                c2.status=rs.getString("status");
                c2.totalCost=rs.getFloat("totalcost");
                //c1.add(c2);

            }
            return c2;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean store_complaint(int customer_id,int worker_id,String complain_text)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO complain(cid,wid,complain_text) " + "VALUES(?,?,?)";
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


    public  ComplainModel get_complaint(int complaint_id)//done
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



            while (rs.next()) {
                ComplainModel c2=new ComplainModel();

                c2.id= rs.getInt("id");
                c2.cid=rs.getInt("cid");
                c2.wid=rs.getInt("wid");
                c2.text=rs.getString("complain_text");
                c1.add(c2);

            }
            return c1;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean store_spar_parts(String name,float cost,int quantity)//done
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

    public  SparePartModel get_spare_part(int part_id)//done
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


    public ArrayList<SparePartModel> get_all_parts()//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from sparepart where quantity > 0 " );

            ArrayList<SparePartModel> c1=new ArrayList<SparePartModel>();


            int i=0;
            while (rs.next()) {
                SparePartModel c2=new SparePartModel();

                c2.id= rs.getInt("id");
                c2.name=rs.getString("part_name");
                c2.cost=rs.getFloat("cost");
                c2.quantity=rs.getInt("quantity");
                c1.add(c2);


            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }//for quantity>0

    public boolean deduct_part(int spare_id,int quantity)//done
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


    public boolean store_rating(int customer_id,int worker_id,int rating) //done
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

    public float get_avg_rating(int worker_id)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select avg(rate) from rating where wid = "+ worker_id );


            float i=0;
            if(rs.next())
            {
                return rs.getFloat(1);
            }
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


    public ArrayList<RatingModel> getAllRatings(int customer_id)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from rating where cid = "+ customer_id );

            ArrayList<RatingModel> c1=new ArrayList<RatingModel>();


            int i=0;
            while (rs.next()) {

                RatingModel c2=new RatingModel();
                c2.cid=rs.getInt("cid");
                c2.wid=rs.getInt("wid");
                c2.rating=rs.getInt("rate");
                c1.add(c2);


            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public  boolean store_chat( int senderId, int receiverId, String senderName, String receiverName, String message)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO chat(senderId,receiverId,senderName,receiverName,message) " + "VALUES(?,?,?,?,?)";
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
    public ArrayList<ChatMessageModel> get_chat_history(int customer_id,int worker_id)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from chat where senderId = "+ customer_id +" and receiverId = "+worker_id);

            ArrayList<ChatMessageModel> c1=new ArrayList<ChatMessageModel>();


            int i=0;
            while (rs.next()) {

                ChatMessageModel c2=new ChatMessageModel();
                c2.senderId=rs.getInt("senderId");
                c2.receiverId=rs.getInt("receiverId");
                c2.senderName=rs.getString("senderName");
                c2.receiverName=rs.getString("receiverName");
                c2.message=rs.getString("message");
                c1.add(c2);

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean change_billing_status(int booking_id, String status)//done
    {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update billing set status = ? where bid = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,status);
            pstmt.setInt(2,booking_id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }



    public boolean update_customerWallet(int id, Float money)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update customers set wallet = wallet + ? where id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setFloat(1,money);
            pstmt.setInt(2,id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;



        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update_booking_status(int booking_id,String status)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "update booking set booking_status = ? where bid = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,status);
            pstmt.setInt(2,booking_id);
            int rowAffected2 = pstmt.executeUpdate();
            return true;


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public ArrayList<WorkerModel> get_favourites_workers(int customer_id)
    {
        return null;
    }



    public ArrayList<Integer> get_favourites(int customer_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from favorite where id = "+customer_id );

            ArrayList<Integer> c1=new ArrayList<Integer>();


            int i=0;
            while (rs.next()) {

                c1.add(rs.getInt("favourite"));

            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SparePartModel> get_all_spare_parts_booking(int booking_id)
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            ResultSet rs = mystmt.executeQuery("select * from spareparts_holder where bid = "+booking_id );

            ArrayList<SparePartModel> c1=new ArrayList<SparePartModel>();


            int i=0;
            while (rs.next()) {
                SparePartModel c2=new SparePartModel();
                //c2.id= rs.getInt("part_id");
                c2=get_spare_part(rs.getInt("part_id"));

                c2.quantity=rs.getInt("quantity");
                c1.add(c2);


            }
            return c1;


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean updateFinishTime(int booking_id, LocalDateTime finishTime)//done
    {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();


            LocalDate ld=finishTime.toLocalDate();
            LocalTime lt=finishTime.toLocalTime();
            Date finishdate = java.sql.Date.valueOf(ld);
            Time finishtime =Time.valueOf(lt);


            String sql = "update booking set end_date = ? where bid = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setDate(1,finishdate);
            pstmt.setInt(2,booking_id);
            int rowAffected2 = pstmt.executeUpdate();

            String sql2 = "update booking set end_time = ? where bid = ?" ;
            PreparedStatement pstmt2 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt2.setTime(1,finishtime);
            pstmt2.setInt(2,booking_id);
            int rowAffected22 = pstmt.executeUpdate();

            return true;


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean store_spare_holder(int booking_id, int spare_id, int quantity)//done
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfix", "root", "elektra");
            Statement mystmt = conn.createStatement();

            String sql = "INSERT INTO spareparts_holder(bid ,part_id,quantity) " + "VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, booking_id);
            pstmt.setInt(2,spare_id);
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
    }




}
