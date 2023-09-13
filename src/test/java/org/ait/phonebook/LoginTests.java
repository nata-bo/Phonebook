package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase{
    @BeforeMethod
    public  void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest(){
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("nbo007@gmail.com")
                .setPassword("Olna123488$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
 @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUser().fillLoginRegistrationForm( new User().setPassword("Olna123488$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test
    public void loginPositiveTestWithScreencast() throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();
        app.getUser().fillLoginRegistrationFormForScreencast(new User()
                .setEmail("nbo007@gmail.com")
                .setPassword("Olna123488$"));
        app.getUser().clickOnLoginButton();
        app.getUser().pause(3000);
      app.getUser().stopRecording();
    }

}
