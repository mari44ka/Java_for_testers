package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupDeleteTest extends TestBase {

    
    @Test
    public void testDeleteGroup() {

        app.getNavigationHelper().Gotogrouppage();
        if (! app.getGroupHelper().isThereGroup()){
            app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
        }
        app.getNavigationHelper().Gotogrouppage();
        app.getGroupHelper().selectgroup();
        app.getGroupHelper().deletegroup();
        app.getNavigationHelper().Gotogrouppage();
    }


}

