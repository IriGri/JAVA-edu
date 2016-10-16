package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactsModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Iri").withLastname("Gri").withMobile("3222333").withEmail("test@email.com").withAddress("France").withGroup("test1"));
        }
    }

    @Test
    public void testContactsModification(){
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstname("Iri").withLastname("Gri").withMobile("3222333").withEmail("test@email.com").withAddress("France").withGroup("test1");
        app.contact().edit(contact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
