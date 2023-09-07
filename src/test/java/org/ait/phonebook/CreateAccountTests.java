package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    // precondition: if user should be logged out

    @BeforeMethod
    public  void ensurePrecondition(){
     if(!app.getUser().isLoginLinkPresent()){
         app.getUser().clickOnSignOutButton();
       }
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("nbo007@gmail.com")
                .setPassword("Olna123488$"));

        app.getUser().clickOnRegistrationButton();

       Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
