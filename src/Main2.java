import java.util.*;
import java.time.*;
public class Main2 {
    public static void main(String[] args) {
        CarRentalSystem obj=new CarRentalSystem();
       obj.addCustomer("Yogin Pahuja","70095-74256");
       obj.addCustomer("Kartik Dua","78891-23583");

       obj.addCar("xyz123" , "Mercedes" ,"Benz" , 2022,"blue",10000);
       obj.addCar("abc123" , "Mercedes" ,"Benz" , 2022,"black",10000);



       obj.rentCar("Yogin Pahuja","xyz123",LocalDate.of(2022,01,01),LocalDate.of(2022,01,21));
       obj.rentCar("Kartik Dua","abc123",LocalDate.of(2022,01,01),LocalDate.of(2022,01,21));

       obj.viewRentalHistoryByCustomer("Yogin Pahuja");
       obj.viewRentalHistoryByCar("xyz123");
       obj.displayAvailableCars();
       obj.returnCar("xyz123");
       obj.displayAvailableCars();

    }
}