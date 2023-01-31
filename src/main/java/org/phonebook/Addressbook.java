package org.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Addressbook {

    public ArrayList<Phonebook> pb = new ArrayList();
    public void Addressbook(){
        pb.add(new Phonebook("Иванов Иван Иванович", "1234567890", "Иваново"));
        pb.add(new Phonebook("Сидоров Сидор Сидорович", "0987654321", "Сидорово"));
    }

    public void showAddressBook(){
        for(Phonebook i : pb){
            System.out.println(i.getName() + " " + i.getPhone() + " " + i.getCity());
        }
    }
}
