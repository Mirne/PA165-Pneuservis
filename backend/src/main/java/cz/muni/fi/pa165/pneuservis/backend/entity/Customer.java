package cz.muni.fi.pa165.pneuservis.backend.entity;

import cz.muni.fi.pa165.pneuservis.backend.enums.VehicleTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.util.Set;
import java.util.List;

/**
 * @author Zuzana Žufanová, zufinka@mail.muni.cz
 */

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String city;

    @NotNull
    private String street;

    @NotNull
    private String country;

    @NotNull
    private String zipCode;

    @NotNull
    private String phoneNumber;

    @OneToMany
    private Set<VehicleTypeEnum> typesOfCar;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    public Customer(){}

    public Customer(String name, String surname, String city, String street, String zipCode, String country,
                    String email, String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<VehicleTypeEnum> getTypesOfCar() {
        return typesOfCar;
    }

    public void setTypeOfCar(VehicleTypeEnum typeOfCar) {
        typesOfCar.add(typeOfCar);
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrder(Order order) {
        orders.add(order);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getEmail().equals(customer.getEmail());
    }

    @Override
    public int hashCode() {
        return getEmail().hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode + '\'' +
                ", country=" + country + '\'' +
                ", phoneNumber=" + phoneNumber + '\'' +
                ", typesOfCar=" + typesOfCar +
                '}';
    }
}
