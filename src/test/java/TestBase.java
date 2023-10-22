import manager.ApplicationManager;
import manager.HelperBase;
import manager.HelperCar;
import manager.HelperUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase implements HelperUser, HelperCar {

    WebDriver wd;

    @BeforeSuite
//    public void init (){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://ilcarro.web.app/search");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
    public void setup() throws IOException {
       init();
    }
    @AfterSuite

    public void stop() {
        pause(5000);
        tearDown();
    }
//    public void tearDown(){
//        pause(5000);
//        wd.quit();
//    }

//    public void openLoginForm(){
//        wd.findElement(By.xpath("//a[@class='navigation-link'][@href='/login?url=%2Fsearch']")).click();
//    }
//
//    public void fillLoginForm(String email,String password){
//        type(By.xpath("//input[@id='email']"), email);
//        type(By.xpath("//input[@id='password']"), password);
//    }

//    public void type (By locator, String text){
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }

//    public void submitLogin(){
//        wd.findElement(By.xpath("//button[@type='submit']")).click();
//        wd.findElement(By.xpath("//button[@type='button']")).click();
//    }

//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public boolean isElementPresent(By locator){
//        return wd.findElements(locator).size() > 0;
//    }

//    public void logout(){
//        wd.findElement(By.xpath("//a[@href='/logout?url=%2Fsearch']")).click();
//    }




}
