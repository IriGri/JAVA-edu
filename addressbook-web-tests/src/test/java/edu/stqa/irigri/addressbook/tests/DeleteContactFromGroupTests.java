package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import edu.stqa.irigri.addressbook.model.Contacts;
import edu.stqa.irigri.addressbook.model.GroupData;
import edu.stqa.irigri.addressbook.model.Groups;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test8"));
        }

        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Iri").withLastname("Gri").withMobile("3222333")
                    .withEmail("test@email.com").withAddress("France"));
        }

        ContactData contact = app.db().contacts().iterator().next();
        if (contact.getGroups().size() == 0) {
            app.goTo().homePage();
            Contacts before = app.db().contacts();
            ContactData contactWithGroup = before.iterator().next();
            app.contact().addToGroup(contactWithGroup);
        }
    }

    @Test
    public void testAddContactToGroup(){
        app.goTo().homePage();
        ContactData contact = app.db().contacts().iterator().next();
        Contacts before = app.db().contacts();
        ContactData contactWithoutGroup = before.iterator().next();
        app.contact().deleteFromGroup(contactWithoutGroup);
        app.goTo().homePage();
        MatcherAssert.assertThat(contactWithoutGroup.getGroups(), equalTo(contact.getGroups()));
    }
}
