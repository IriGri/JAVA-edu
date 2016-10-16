package edu.stqa.irigri.addressbook.tests;

import edu.stqa.irigri.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData("test8", null, null));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "test1", "test2", "test8");
        app.getGroupsHelper().modifyGroup(index, group);
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}