import edu.stqa.irigri.addressbook.ContactData;
import edu.stqa.irigri.addressbook.TestBase;
import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreationTests() {
        initContactCreation();
        fillContactForm(new ContactData("Iri", "Gri", "3222333", "test@email.com", "France"));
        submitContactCreation();
    }

}
