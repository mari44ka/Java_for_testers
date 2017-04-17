package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {

    
    @Test
    public void testDeleteGroup() {

        Gotogrouppage();
        selectgroup();
        deletegroup();
        Gotogrouppage();
    }


}

