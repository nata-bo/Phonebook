package phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    // precondition: if user should be logged out

    @BeforeMethod
    public  void ensurePrecondition(){
     if(!isElementPresent(By.cssSelector("a:nth-child(4)"))){
         driver.findElement(By.xpath("button[contains(.,'Sign Out')]")).click();
     }
      driver.findElement(By.cssSelector("a:nth-child(4)")).click();
    }
    @Test
    public void newUserRegistrationPositiveTest(){
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("nbo007@gmail.com");

        driver.findElement(By.cssSelector("[placeholder='Password'] ")).click();
        driver.findElement(By.cssSelector("[placeholder='Password'] ")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password'] ")).sendKeys("Olna123488$");

       driver.findElement(By.xpath("//button[text()='Registration']")).click();
       Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }
        // locator
    // click on Login link   - a:nth-child(4) - css
    // enter email    - [placeholder='Email'] - css
    //enter password    -  [placeholder='Password'] - css
    //click on Registration button    - //button[text()='Registration'] - xpath
    //assert Sign out button displayed    - //button[contains(.,'Sign Out')] -xpath
}
