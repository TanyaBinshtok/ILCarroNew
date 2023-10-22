package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

import javax.xml.namespace.QName;

public interface HelperUser extends HelperBase{

    default void openLoginForm(){
        click(By.xpath("//*[.=' Log in ']"));
    }
    default void openRegistrationForm(){
        click(By.xpath("//*[.=' Sign up ']"));
    }

    default void fillLoginForm(String email,String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
    default void fillLoginForm(User user){
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }
    default void fillRegistrationForm(User user){
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
//        clickCheckbox();
        clickCheckboxWithRectangle();
    }

    default void clickCheckbox(){
        // variant1
//        click(By.cssSelector("label[for='terms-of-use'])"));
        // variant2
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }

    default void clickCheckboxWithRectangle(){
        Rectangle rect = wd.findElement(By.id("terms-of-use")).getRect();
//        int x = rect.getX() + rect.getWidth()/2;
//        int y = rect.getY() + rect.getHeight()/2;
        Actions actions = new Actions(wd);
//        actions.moveByOffset(x,y).click().perform();
        actions.moveToElement(wd.findElement(By.id("terms-of-use")),
                rect.getWidth()/2, rect.getHeight()/2).
                click().perform();
    }


    default void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }
    default void submitRegistration(){
        click(By.xpath("//button[@type='submit']"));
    }
    default void buttonOkRegistrationWrong(){
        click(By.xpath("//button[@type='button']"));
    }
    default void buttonOkRegistration(){
        click(By.xpath("//button[@type='button']"));
    }


    default boolean isLoggedSuccess(){
        return isElementPresent (By.xpath("//h2[contains(text(),'success')]"));
    }
    default boolean isLogged(){
        return isElementPresent (By.xpath("//*[.=' Logout ']"));
    }

    default void logout(){
        click(By.xpath("//*[.=' Logout ']"));
    }

    default void clickOkButton (){
        click((By.xpath("//button[@type='button']")));
    }

    default void login(User user){
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        clickOkButton();
    }
}
