package org.ait.phonebook.utils;

import org.ait.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
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
}
