package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase {

    
    @Test
    public void testDeleteGroup() {

        app.getNavigationHelper().Gotogrouppage();
        app.getGroupHelper().selectgroup();
        app.getGroupHelper().deletegroup();
        app.getNavigationHelper().Gotogrouppage();
    }


}
