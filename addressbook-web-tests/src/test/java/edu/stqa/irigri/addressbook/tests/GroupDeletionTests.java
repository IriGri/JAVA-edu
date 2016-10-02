package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletionTests() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData("test8", null, null));
        }
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returnToGroupPage();
    }

}
