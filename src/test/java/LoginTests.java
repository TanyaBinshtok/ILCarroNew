import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition (){
        if(isLogged()) logout();
    }

    @Test
    public void loginPositiveTest ()
    {
        logger.info("");
        openLoginForm();
        fillLoginForm("vitya@mail.com","Aa123456!");
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @Test
    public void loginPositiveTestProps(){
        logger.info("");
        openLoginForm();
        fillLoginForm(getEmail(), getPassword());
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @Test
    public void loginPositiveTest1()
    {
        User user = new User()
                .withEmail("vitya@mail.com")
                .withPassword("Aa123456!");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition (){
        clickOkButton();
    }


}
