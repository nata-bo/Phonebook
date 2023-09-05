package phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public  void ensurePrecondition(){
        if(!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
        clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest(){
        fillLoginRegistrationForm("nbo007@gmail.com", "Olna123488$");
        click(By.xpath("//button[.='Login']"));
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }
}
