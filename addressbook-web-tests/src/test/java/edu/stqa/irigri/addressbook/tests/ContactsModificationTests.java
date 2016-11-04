package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import edu.stqa.irigri.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactsModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Iri").withLastname("Gri").withMobile("3222333")
                    .withEmail("test@email.com").withAddress("France").withGroup("test1"));
        }
    }

    @Test
    public void testContactsModification(){
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstname("Iri").withLastname("Gri").withMobile("3222333").withEmail("test@email.com").withAddress("France").withGroup("test1")
                .withHomePhone("32").withWorkPhone("42").withEmail2("16").withEmail3("14");
        app.goTo().homePage();
        app.contact().edit(contact);
        app.goTo().homePage();
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }
}
