package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreationTests() {
        app.initContactCreation();
        app.fillContactForm(new ContactData("Iri", "Gri", "3222333", "test@email.com", "France"));
        app.submitContactCreation();
    }

}
