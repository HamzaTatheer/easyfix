package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.easyfix.Application.models.CustomerModel;
public class Customer extends User{
    private Float wallet;
    private String creditno;
    private String paymentMethod;
    private String city;
    private String area;
    private ArrayList<Worker> Favourites;


    //constructors
    public Customer(CustomerModel model){

        super(model.id,model.name,model.email,model.password);
        wallet=model.wallet;
        creditno = model.creditno;
        paymentMethod = model.paymentMethod;
        city = model.city;
        area = model.area;
    }

    public Boolean addToWallet(Float newAmount){
        wallet += newAmount;
        return true;
    }

    public Boolean chargeWallet(Float amount){
        if(wallet - amount < 0){
            return false;
        }
        else {
            wallet -= amount;
            return true;
        }
    }

    public boolean changePaymentMethod(String newMethod){
        if(newMethod == "cash" || newMethod == "credit")
        paymentMethod = newMethod;
        return true;
    }

    public Boolean changeCity(String newCity){
        if(newCity.equals("lahore") || newCity.equals("karachi") || newCity.equals("islamabad")){
            city = newCity;
            return true;
        }
        else
            return false;
    }

    public Boolean changeArea(String newArea){
        area = newArea;
        return true;
    }
    //getters
    public Float getWallet() {
        return wallet;
    }

    public String getCreditno() {
        return creditno;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCity() {
        return city;
    }
    public String getArea(){

        return area;
    }

    public ArrayList<Worker> getFavourites() {
        return Favourites;
    }
    //setters
    public void setWallet(Float wallet) {
        this.wallet = wallet;
    }

    public void setCreditno(String creditno) {
        this.creditno = creditno;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setFavourites(ArrayList<Worker> favourites) {
        Favourites = favourites;
    }

    public boolean canPayFromWallet(float amount){
        if(wallet >= amount){
            return true;
        }
        else{
            return false;
        }
    }




    public static boolean validateCreditCard(String creditno){
        if(creditno.length() == 10)
            return true;
        else
            return false;
    }

    public static boolean validateEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean validatePassword(String password){
        if(password.length() <= 3)
            return false;
        else
            return true;
    }





}
