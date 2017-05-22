package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;
import java.util.Set;

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
        Set<GroupData> before=app.getGroupHelper().all();
        GroupData deletedGroup = before.iterator().next();

        //int before = app.getGroupHelper().getGroupCount();
        //int index=before.size()-1;
        app.goTo().grouppage();
        app.getGroupHelper().delete(deletedGroup);
        app.goTo().grouppage();
        Set<GroupData> after=app.getGroupHelper().all();
        Assert.assertEquals(after.size(),before.size()-1);


        //before.remove(index); // переменная before теперь ссылается на старый список, в котором удален ненужный элемент

        before.remove(deletedGroup);

        Assert.assertEquals(before,after);

    }


}

