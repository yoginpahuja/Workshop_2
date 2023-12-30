import java.util.*;
class Car {
    public String regNumber;
    public String make,model,colour;
    int year,price;
    public boolean isAvailable;
    public Car (String regNumber, String make, String model,int year, String colour, int price) {
        this.colour=colour;
        this.regNumber=regNumber;
        this.make=make;
        this.year=year;
        this.price=price;
        this.model=model;
        this.isAvailable=true;
    }
    public void setAvailable(boolean available) {
        this.isAvailable=available;
    }

}