package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test1", "test2", "test8"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returnToGroupPage();
    }

}
