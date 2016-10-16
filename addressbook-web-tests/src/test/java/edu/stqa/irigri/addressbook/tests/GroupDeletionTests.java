package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData("test8", null, null));
        }
    }

    @Test
    public void testGroupDeletionTests() {
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(before.size() - 1);
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        
    }

}
