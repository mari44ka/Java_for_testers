package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTest extends TestBase {

    @BeforeMethod
    public void esurePreconditions() {
        app.goTo().grouppage();
        if (app.group().list().size()==0) {
            app.group().create(new GroupData().withName("Test2").withHeader("test2").withFooter("test3")); //using fluent interface

        }
    }

    
    @Test
    public void testDeleteGroup() {
        Groups before=app.group().all();
        GroupData deletedGroup = before.iterator().next();

        //int before = app.getGroupHelper().сount();
        //int index=before.size()-1;
        app.goTo().grouppage();
        app.group().delete(deletedGroup);
        app.goTo().grouppage();
        assertThat(app.group().сount(),equalTo(before.size()-1));
        Groups after=app.group().all();



        //before.remove(index); // переменная before теперь ссылается на старый список, в котором удален ненужный элемент


        assertThat(after, equalTo(before.without(deletedGroup)));


    }


}

