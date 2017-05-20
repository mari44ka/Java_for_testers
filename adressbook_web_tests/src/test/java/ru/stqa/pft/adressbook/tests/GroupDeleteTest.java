package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase {

    @BeforeMethod
    public void esurePreconditions() {
        app.goTo().grouppage();
        if (app.getGroupHelper().list().size()==0) {
            app.getGroupHelper().create(new GroupData().withName("Test2").withHeader("test2").withFooter("test3")); //using fluent interface

        }
    }

    
    @Test
    public void testDeleteGroup() {
        List<GroupData> before=app.getGroupHelper().list();

        //int before = app.getGroupHelper().getGroupCount();
        int index=before.size()-1;
        app.goTo().grouppage();
        app.getGroupHelper().delete(index);
        app.goTo().grouppage();
        List<GroupData> after=app.getGroupHelper().list();
        Assert.assertEquals(after.size(),index);

        before.remove(index); // переменная before теперь ссылается на старый список, в котором удален ненужный элемент

        Assert.assertEquals(before,after);

    }


}

