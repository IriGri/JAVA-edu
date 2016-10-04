package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreationTests() {
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().createContact(new ContactData("Iri", "Gri", "3222333", "test@email.com", "France", "test8"), true);
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before + 1);
    }

}
