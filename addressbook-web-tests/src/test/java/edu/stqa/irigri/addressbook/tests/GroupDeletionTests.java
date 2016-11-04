package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.GroupData;
import edu.stqa.irigri.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test8"));
        }
    }

    @Test
    public void testGroupDeletionTests() {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertEquals(app.group().count(), before.size() - 1);
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(deletedGroup)));
        verifyGroupListInUI();
    }

}