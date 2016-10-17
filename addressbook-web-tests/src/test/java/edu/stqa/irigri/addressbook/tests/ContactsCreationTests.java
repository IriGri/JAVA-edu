package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import edu.stqa.irigri.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreationTests() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Iri").withLastname("Gri").withMobile("3222333").withEmail("test@email.com").withAddress("France").withGroup("test1");
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}
