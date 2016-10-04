package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTest() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupsHelper().getGroupCount();
        app.getGroupsHelper().createGroup(new GroupData("test8", null, null));
        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }

}
