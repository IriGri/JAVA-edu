package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsModificationTests extends TestBase {

    @Test
    public void testContactsModification(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Iri", "Gri", "3222333", "test@email.com", "France", "test1"));
        }
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().editContact(new ContactData("Iri", "Gri", "911", "test@email.com", "France", null));
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before);
    }
}
