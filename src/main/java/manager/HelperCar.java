package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface HelperCar extends HelperBase{
    default void openCarForm(){
        pause(5000);
        click(By.id("1"));
//        click(By.xpath("//a[/=' Let the car work ']"));
    }

    default void fillCarForm (Car car){
        if (isCarFormPresent()==false) return;
        typeLocation(car.getLocation());
        type(By.id("make"),car.getManufacture());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"),car.getSeats());
        type(By.id("class"),car.getCarClass());
//        type(By.id("serialNumber"),car.getCarRegNumber());
        typeSerialNumber(car.getCarRegNumber());
        type(By.id("price"),car.getPrice());
        type(By.id("about"),car.getAbout());

    }

    default void typeLocation(String location){
//        pause(5000);
        type(By.id("pickUpPlace"),location);
        click(By.className("pac-item"));
    }

    default void typeSerialNumber(String text){
//        Rectangle rect = wd.findElement(By.id("serialNumber")).getRect();
//        int x = rect.getX() + rect.getWidth() * 7/8;
//        int x =rect.getWidth()/4;
//        System.out.println(rect.getX());
//        System.out.println(rect.getWidth());
//        System.out.println(x);
//        int y = rect.getY() + rect.getHeight() / 2;
//       int y = rect.getHeight() / 2;
//        System.out.println(rect.getY());
//        System.out.println(rect.getHeight());
//        System.out.println(y);
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("window.scrollBy(0,0)", "");
        WebElement element = wd.findElement(By.id("serialNumber"));
        Actions actions = new Actions(wd);
//        actions.moveToElement(wd.findElement(By.id("serialNumber"))).click().sendKeys(text).perform();
//        actions.moveByOffset(x,y).click().perform();
//        wd.switchTo().activeElement().sendKeys(text);
//        WebElement element = driver.findElement(By.id("gbqfd"));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", element);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.document.getElementById('gbqfb').click()");

//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", we);
        actions.moveToElement(element).click().perform();
        element.clear();
        element.sendKeys(text);
    }

    default boolean isCarFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(
                        wd.findElement(By.cssSelector("h2")), "details"
                ));
    }

    default void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }

}
