package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {

    
    @Test
    public void testDeleteGroup() {

        app.Gotogrouppage();
        app.selectgroup();
        app.deletegroup();
        app.Gotogrouppage();
    }


}

