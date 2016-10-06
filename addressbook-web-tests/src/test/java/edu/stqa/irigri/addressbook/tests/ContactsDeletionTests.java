package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsDeletionTests extends TestBase {

    @Test
    public void testContactsDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Iri", "Gri", "3222333", "test@email.com", "France", "test1"));
        }
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before - 1);
    }
}
