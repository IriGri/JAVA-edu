package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactsModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData("Iri", "Gri", "3222333", "test@email.com", "France", "test1"));
        }
    }

    @Test
    public void testContactsModification(){
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData(before.get(0).getId(), "Iri", "Gri", "3222333", "test@email.com", "France", "test1");
        app.contact().edit(contact);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
