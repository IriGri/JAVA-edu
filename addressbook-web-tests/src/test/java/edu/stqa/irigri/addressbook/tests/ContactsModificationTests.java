package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactsModificationTests extends TestBase {

    @Test
    public void testContactsModification(){
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Iri", "Gri", "911", "test@email.com", "France", null), false);
        app.getContactHelper().updateContactForm();
    }
}
