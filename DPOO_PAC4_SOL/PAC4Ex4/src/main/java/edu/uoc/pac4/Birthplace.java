package edu.uoc.pac4;

public class Birthplace implements Cloneable{

    String city;
    String country;

    public Birthplace(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
