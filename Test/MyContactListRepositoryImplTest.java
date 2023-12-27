import Data.Models.MyContactList;
import Data.Repositories.MyContactListRepository;
import Data.Repositories.MyContactListRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyContactListRepositoryImplTest {

    MyContactListRepository contact = new MyContactListRepositoryImpl();

    @Test public void testThatContactListIncreasesCountWhenAdded() {
        MyContactList newContact = new MyContactList();
        contact.save(newContact);
        assertEquals(1, contact.count());
    }

    @Test public void testThatWhen_i_add_new_account_count_increases() {
        MyContactList newContact = new MyContactList();
        contact.save(newContact);
        assertEquals(1, contact.count());

        MyContactList phoneContact = new MyContactList();
        contact.save(phoneContact);
        assertEquals(2, contact.count());
    }

    @Test public void testThatContactListDecreasesCountWhenDeleted() {
        MyContactList newContact = new MyContactList();
        newContact.setName("esther americana");
        contact.save(newContact);
        assertEquals("esther americana", contact.findById(1).getName());

        MyContactList extra = new MyContactList();
        extra.setName("Joel");
        contact.save(extra);
        assertEquals("Joel", contact.findById(2).getName());

        contact.delete(extra);
        assertEquals(1, contact.count());
    }

    @Test public void testThatContactInformationCanBeSaved() {
        MyContactList newContact = new MyContactList();
        newContact.setName("esther americana");
        contact.save(newContact);
        assertEquals("esther americana", contact.findById(1).getName());
    }

    @Test public void testThatContactNameCanBeUpdated() {
        MyContactList newContact = new MyContactList();
        newContact.setName("esther americana");
        contact.save(newContact);
        assertEquals("esther americana", contact.findById(1).getName());

        MyContactList extra = new MyContactList();
        extra.setId(1);
        extra.setName("Joel");
        contact.save(extra);
        assertEquals("Joel", contact.findById(1).getName());
    }

    @Test public void testThatContactDetailsCanSave() {
        MyContactList newContact = new MyContactList();
        newContact.setName("esther americana");
        newContact.setAddress("Nigeria");
        newContact.setEmail("joellegend582@gmail.com");
        newContact.setTelephone("07033099619");
        contact.save(newContact);
        assertEquals("esther americana", contact.findById(1).getName());
        assertEquals("Nigeria", contact.findById(1).getAddress());
        assertEquals("joellegend582@gmail.com", contact.findById(1).getEmail());
        assertEquals("07033099619", contact.findById(1).getTelephone());


        MyContactList yetNewContact = new MyContactList();
        yetNewContact.setName("esther americana");
        yetNewContact.setAddress("Nigeria");
        yetNewContact.setEmail("joellegend582@gmail.com");
        yetNewContact.setTelephone("07033099619");
        contact.save(yetNewContact);
        assertEquals("esther americana", contact.findById(1).getName());
        assertEquals("Nigeria", contact.findById(1).getAddress());
        assertEquals("joellegend582@gmail.com", contact.findById(1).getEmail());
        assertEquals("07033099619", contact.findById(1).getTelephone());
    }

    @Test public void testThatContactCanBeDeleted() {
        MyContactList newContact = new MyContactList();
        contact.save(newContact);
        assertEquals(1, contact.findById(1).getId());

        MyContactList yetNewContact = new MyContactList();
        contact.save(yetNewContact);
        assertEquals(2, contact.findById(2).getId());

        contact.delete(yetNewContact);
        assertEquals(1, contact.count());
    }

    @Test public void testThatWhenI_clear_All_List_isEmpty() {
        MyContactList newContact = new MyContactList();
        contact.save(newContact);
        assertEquals(1, contact.findById(1).getId());

        MyContactList yetNewContact = new MyContactList();
        contact.save(yetNewContact);
        assertEquals(2, contact.findById(2).getId());

        contact.clear();
        assertEquals(0, contact.count());
    }

    @Test public void testthatAllContactListIsReturned() {
        MyContactList newContact = new MyContactList();
        contact.save(newContact);
        assertEquals(1, contact.findById(1).getId());

        MyContactList yetNewContact = new MyContactList();
        contact.save(yetNewContact);
        assertEquals(2, contact.findById(2).getId());

        Iterable<MyContactList> listContent = List.of(new MyContactList[]{newContact, yetNewContact});
        assertEquals(listContent, contact.findAll());
    }
}
