import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!isLogged()){
            login(new User()
                    .withEmail("vitya@mail.com")
                    .withPassword("Aa123456!"));
        }
    }

    @Test
    public void addNewCarPositive(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("Mazda")
                .model("2")
                .year("2011")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-200-"+i)
                .price("120")
                .about("Best car")
                .build();
        logger.info("addNewCarPositive starts with:" + car.getLocation() + " & " + car.getManufacture() + " & " + car.getModel() + " & " + car.getYear()
                + " & " + car.getFuel() + " & " + car.getSeats() + " & " + car.getCarClass() + " & " + car.getCarRegNumber() + " & " + car.getPrice() + " & " + car.getAbout());
        openCarForm();
        fillCarForm(car);
        pause(5000);
    }
}
