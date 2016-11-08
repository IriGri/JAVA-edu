package edu.stqa.irigri.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void testRegistration() {
        app.registration().start("Iri", "iri@localhost.localdomain");
    }
}
