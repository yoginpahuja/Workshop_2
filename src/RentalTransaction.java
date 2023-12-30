import java.util.*;
import java.time.*;
class RentalTransaction {
    public LocalDate rentDate,returnDate;
    public int rentDuration;
    public Customer customer;
    public Car car;
    public RentalTransaction(LocalDate rentDate,LocalDate returnDate, Customer customer,Car car) {
        this.rentDate=rentDate;
        this.returnDate=returnDate;
        this.customer=customer;
        this.car=car;
        Period p=Period.between(returnDate,rentDate);
        this.rentDuration=p.getDays();
    }
}