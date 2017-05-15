package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {

    @BeforeMethod
    public void esurePreconditions() {
        app.getNavigationHelper().Gotogrouppage();
        if (!app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Test2", "test2", "test3"));

        }
    }

    
    @Test
    public void testDeleteGroup() {
        List<GroupData> before=app.getGroupHelper().getGroupList();

        //int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().Gotogrouppage();
        app.getGroupHelper().selectgroup(before.size()-1);
        app.getGroupHelper().deletegroup();
        app.getNavigationHelper().Gotogrouppage();
        List<GroupData> after=app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(before.size()-1); // переменная before теперь ссылается на старый список, в котором удален ненужный элемент

        Assert.assertEquals(before,after);

    }


}

