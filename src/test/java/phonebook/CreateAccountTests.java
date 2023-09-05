package phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    // precondition: if user should be logged out

    @BeforeMethod
    public  void ensurePrecondition(){
     if(!isLoginLinkPresent()){
         clickOnSignOutButton();
       }
        clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        fillLoginRegistrationForm("nbo007@gmail.com", "Olna123488$");

        clickOnRegistrationButton();

       Assert.assertTrue(isAlertPresent());
    }
}
