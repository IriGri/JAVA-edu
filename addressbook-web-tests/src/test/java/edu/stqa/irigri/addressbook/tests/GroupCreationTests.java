package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTest() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupsHelper().createGroup(new GroupData("test8", null, null));
    }

}
