package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import edu.stqa.irigri.addressbook.model.Contacts;
import edu.stqa.irigri.addressbook.model.GroupData;
import edu.stqa.irigri.addressbook.model.Groups;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class AddContactToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test8"));
        }

        if (app.db().contacts().size() == 0) {
        app.goTo().homePage();
        app.contact().create(new ContactData().withFirstname("Iri").withLastname("Gri").withMobile("3222333")
                .withEmail("test@email.com").withAddress("France"));
    }
}

    @Test
    public void testAddContactToGroup(){
        app.goTo().homePage();
        ContactData contact = app.db().contacts().iterator().next();
        Contacts before = app.db().contacts();
        ContactData contactWithGroup = before.iterator().next();
        app.contact().addToGroup(contactWithGroup);
        app.goTo().homePage();
        MatcherAssert.assertThat(contactWithGroup.getGroups(), equalTo(contact.getGroups()));
        System.out.println(contact);
        System.out.println(contact.getGroups());
    }
}
