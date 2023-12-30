import java.util.*;
import java.time.*;
public class CarRentalSystem {
//    public HashMap<String, Boolean> isAvailableMap;
    public HashMap<String,Customer> customers;
    public HashMap<String,Car> cars;
    public ArrayList<RentalTransaction> rentHistory;
    public CarRentalSystem() {
//        isAvailableMap= new HashMap<>();
        customers=new HashMap<>();
        cars=new HashMap<>();
        rentHistory=new ArrayList<>();
    }
    public void addCustomer(String name,String contactInfo) {
        Customer customer=new Customer(name,contactInfo);
        customers.put(name,customer);
    }
    public void updateCustomer(String name,String newContactInfo){
        if(customers.containsKey(name)) {
            customers.get(name).contactInfo=newContactInfo;
        }
        else {
            System.out.println("Customer not registered");
        }
    }
    public void deleteCustomer(String name) {
        if(customers.containsKey(name)) {
            customers.remove(name);
        }
        else {
            System.out.println("Customer not registered");
        }
    }
    public void addCar(String regNumber,String make,String model,int year,String colour,int price) {
        Car car = new Car(regNumber,make,model,year,colour,price);
        cars.put(regNumber,car);
    }
    public void deleteCar(String regNumber) {
        if(cars.containsKey(regNumber)) {
            cars.remove(regNumber);
        }
        else {
            System.out.println("Car not found ");
        }
    }
    public void rentCar(String customerName,String regNumber,LocalDate rentDate,LocalDate returnDate) {
        if(customers.containsKey(customerName) && cars.containsKey(regNumber) && cars.get(regNumber).isAvailable) {
            Customer customer=customers.get(customerName);
            Car car = cars.get(regNumber);
            RentalTransaction entry=new RentalTransaction(rentDate,returnDate,customer,car);
            rentHistory.add(entry);
            customer.addRentalTransaction(entry);
            car.setAvailable(false);
            System.out.println("Car rented Successfully");
        }
        else {
            System.out.println("Invalid rent request (Availability issue)");
        }
    }
    public RentalTransaction findRentalTransaction(String regNumber) {
        for(RentalTransaction transaction: rentHistory) {
            if(transaction.car.regNumber.equals(regNumber)) {
                return transaction;
            }
        }
        return null;
    }
    public void returnCar(String regNumber) {
        if(cars.containsKey(regNumber) && !cars.get(regNumber).isAvailable) {
            Car car = cars.get(regNumber);
            RentalTransaction entry=findRentalTransaction(regNumber);
            if(entry!=null) {
                entry.car.setAvailable(true);
                System.out.println("Car returned successfully");
            }
            else {
                System.out.println("Car was not rented");
            }
        }
        else {
            System.out.println("Invalid return request (Availability issue)");
        }
    }
    public void viewRentalHistoryByCustomer(String customerName) {
        if( customers.containsKey(customerName)) {
            Customer customer=customers.get(customerName);
            ArrayList<RentalTransaction> temp=customer.rentHistory;
            System.out.println("Rental History for customer : ");
            for(RentalTransaction transaction:temp){
                System.out.println("Car: " + transaction.car.regNumber +
                        " Rental Date: " + transaction.rentDate +
                        " Return Date: " + transaction.returnDate +
                        " Rental Duration: " + -transaction.rentDuration + " days");
            }
        }
        else {
            System.out.println("Customer not found");
        }
    }
    public void viewRentalHistoryByCar(String regNumber) {
        if( cars.containsKey(regNumber)) {
            Car car=cars.get(regNumber);

            System.out.println("Rental History for car : ");
            for(RentalTransaction transaction:rentHistory){
                if(transaction.car.regNumber.equals(regNumber)){
                    System.out.println("Customer: " + transaction.customer.name +
                            " Rental Date: " + transaction.rentDate +
                            " Return Date: " + transaction.returnDate +
                            " Rental Duration: " + -transaction.rentDuration + " days");
                }

            }
        }
        else {
            System.out.println("Car not found");
        }
    }
    public void displayAvailableCars() {
        System.out.println("Available Cars : ");
        for(HashMap.Entry<String, Car> entry : cars.entrySet()) {
            Car car=entry.getValue();
            if(car.isAvailable) {
                System.out.println("Registration Number : " + car.regNumber +
                        " Make: " + car.make +
                        " Model: " + car.model +
                        " Year: " +car.year);
            }
        }
    }

}