package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {

    
    @Test
    public void testDeleteGroup() {
        app.getNavigationHelper().Gotogrouppage();
        if (! app.getGroupHelper().isThereGroup()){
            app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
        }
        List<GroupData> before=app.getGroupHelper().getGroupList();

        //int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().Gotogrouppage();
        app.getGroupHelper().selectgroup(before.size()-1);
        app.getGroupHelper().deletegroup();
        app.getNavigationHelper().Gotogrouppage();
        List<GroupData> after=app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(),after.size()+1);

    }


}

