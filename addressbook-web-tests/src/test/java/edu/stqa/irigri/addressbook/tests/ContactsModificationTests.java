package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsModificationTests extends TestBase {

    @Test
    public void testContactsModification(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Iri", "Gri", "3222333", "test@email.com", "France", "test1"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Iri", "Gri", "911", "test@email.com", "France", null), false);
        app.getContactHelper().updateContactForm();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before);
    }
}
