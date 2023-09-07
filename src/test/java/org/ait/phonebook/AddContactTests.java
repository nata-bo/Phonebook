package org.ait.phonebook;

import org.ait.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public  void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().login();
        app.getContact().clickOnAddLink();
    }

    @Test
    public void addContactPositiveTest(){

       // enter all input fields in contact form - input:nth-child(1) - css
        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setSurname("Adam")
                .setPhone("1234567890")
                .setEmail("adm@gm.com")
                .setAddress("Berlin")
                .setDesc("kksasdeer"));
        // click on Save button - .add_form__2rsm2 button -  css
        app.getContact().clickOnSaveButton();
        // assert by text contact is added
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));

    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
