package org.ait.phonebook;

import org.ait.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver","Kan","3324566700","kan@gmail.com","Bonn","kjhgfdd"});
        list.add(new Object[]{"Oliver1","Kan","3324566688","kan@gmail.com","Bonn","kjhgfdd"});
        list.add(new Object[]{"Oliver2","Kan","3324564766","kan@gmail.com","Bonn","kjhgfdd"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> newContactWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
         String line = reader.readLine();
         while (line !=null) {
             String[] split = line.split(",");
             list.add(new Object[]{new Contact().setName(split[0])
                     .setSurname(split[1])
                     .setPhone(split[2])
                     .setEmail(split[3])
                     .setAddress(split[4])
                     .setDesc(split[5])});
             line = reader.readLine();
         }
        return list.iterator();
    }
    @Test(dataProvider = "newContact")
    public void addContactPositiveTestFromDataProvider(String name,String surname,String phone,
                                                       String email,String address, String description){
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(description));
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactAdded(name));

    }
    @Test(dataProvider = "newContactWithCSVFile")
    public void addContactPositiveTestFromDataProviderWithCSV(Contact contact){
        app.getContact().fillContactForm(contact);

        app.getContact().clickOnSaveButton();
        app.getContact().pause(1000);
        Assert.assertEquals(Integer.toString(app.getContact().sizeOfContacts()),"1");

    }
}
