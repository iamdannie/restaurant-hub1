package org.launchcode.RestaurantHub.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    private String clientName;

    private String nameOfRestaurant;
    private String address;
    private String phoneNumber;
    private String typeOfRestaurant;
    private String hoursOfOperation;

    public Client(String clientName, String nameOfRestaurant, String address, String phoneNumber, String typeOfRestaurant, String hoursOfOperation) {
        this.clientName = clientName;
        this.nameOfRestaurant = nameOfRestaurant;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.typeOfRestaurant = typeOfRestaurant;
        this.hoursOfOperation = hoursOfOperation;
    }
public Client () {}
    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNameOfRestaurant() {
        return nameOfRestaurant;
    }

    public void setNameOfRestaurant(String nameOfRestaurant) {
        this.nameOfRestaurant = nameOfRestaurant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeOfRestaurant() {
        return typeOfRestaurant;
    }

    public void setTypeOfRestaurant(String typeOfRestaurant) {
        this.typeOfRestaurant = typeOfRestaurant;
    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }
}
