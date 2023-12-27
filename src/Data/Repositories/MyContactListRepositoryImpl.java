package Data.Repositories;

import Data.Models.MyContactList;

import java.util.ArrayList;
import java.util.List;

public class MyContactListRepositoryImpl implements MyContactListRepository{
    private long count;
    private final List<MyContactList> contactList = new ArrayList<>();

    @Override
    public MyContactList save(MyContactList contact) {
//        contact.setId(generateId());
//        contact.setName(contact.getName());
//        contactList.add(contact);
        if (contact.getId() == 0) {
            contact.setId(generateId());
            contactList.add(contact);
        }
        else
            update(contact);
        return contact;
    }

    private void update(MyContactList contact) {
        MyContactList newContact = findById(contact.getId());
        newContact.setName(contact.getName());
    }

    private int generateId() {
        return contactList.size() + 1;
    }

    @Override
    public MyContactList delete(MyContactList contact) {
        for (MyContactList newContact: contactList) {
            contactList.remove(newContact);
        }
        return null;
    }

    @Override
    public MyContactList findById(int id) {
        for (MyContactList contact: contactList) {
            if (contact.getId() == id)
                return contact;
        }
        return null;
    }

    @Override
    public void clear() {
        contactList.clear();
    }

    @Override
    public long count() {
        return contactList.size();
    }
    @Override
    public Iterable<MyContactList> findAll() {
        return contactList;
    }
}
