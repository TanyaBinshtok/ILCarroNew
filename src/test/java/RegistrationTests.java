import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition (){
        if(isLogged()) logout();
        openRegistrationForm();
    }

    @Test
    public void registrationPositive(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Katya")
                .withLastName("Romanov")
                .withEmail("katya"+i+"@mail.com")
                .withPassword("Kk123456!");
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        buttonOkRegistration();
    }

    @Test
    public void registrationNegativeWithWrongName(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withName(" ").withLastName("Romanov").withEmail("katya"+i+"@mail.com").withPassword("Kk123456!");
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        isElementPresent(By.linkText("Registration failed"));
        buttonOkRegistrationWrong();


    }
    @Test
    public void registrationNegativeWithWrongLastName(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withName("Katya").withLastName(" ").withEmail("katya"+i+"@mail.com").withPassword("Kk123456!");
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        isElementPresent(By.linkText("Registration failed"));
//        buttonOkRegistrationWrong();
    }
    @Test
    public void registrationNegativeWithWrongEmail(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withName("Katya").withLastName("Romanov").withEmail("katya"+i+"mail.com").withPassword("Kk123456!");
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
    }

    @Test
    public void registrationNegativeWithWrongPassword(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withName("Katya").withLastName("Romanov").withEmail("katya"+i+"@mail.com").withPassword("Kk123456");
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
    }

}
