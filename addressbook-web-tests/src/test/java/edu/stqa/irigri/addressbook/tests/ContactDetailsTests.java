package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Iri").withLastname("Gri")
                    .withMobile("3222333").withEmail("test@email.com").withAddress("France"));
        }
    }

    @Test
    public void testContactDetails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactDetails = app.contact().contactDetails(contact);

        assertThat(mergeDetails(contact), equalTo(cleanedDetails(contactDetails.getDetails())));
    }

    private String mergeDetails(ContactData contact){
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(), contact.getAllPhones(), contact.getAllEmails())
                .stream().filter((s) -> ! s.equals(""))
                        .map(ContactDetailsTests::cleanedDetails)
                        .collect(Collectors.joining(""));
    }

    public static String cleanedDetails(String details) {
        return details.replaceAll("\\s", "").replaceAll("(\r\n|\n)", "").replaceAll("[-():HMW]", "")
                .replaceAll("www.email.com", "").replaceAll("www.test.go", "");
    }
}
