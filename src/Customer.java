import java.util.*;
class Customer {
    public String name;
    public String contactInfo;
    public ArrayList <RentalTransaction> rentHistory;
    public Customer (String name,String contactInfo) {
        this.name=name;
        this.contactInfo=contactInfo;
        this.rentHistory=new ArrayList<>();
    }
    public void addRentalTransaction(RentalTransaction entry)
    {
        rentHistory.add(entry);
    }


}