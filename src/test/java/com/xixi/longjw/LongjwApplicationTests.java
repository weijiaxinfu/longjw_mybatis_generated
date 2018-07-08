package com.xixi.longjw;


import com.xixi.longjw.dao.PersonMapper;
import com.xixi.longjw.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
public class LongjwApplicationTests {

    @Autowired
    private PersonMapper person_Dao;

    @Test
    public void testInsert() {
        Person person = new Person();
        person.setAge(26);
        person.setUserName("龙静文hahaha");
        person.setBirthday(new Date());
        int result = person_Dao.insertPerson(person);
        System.out.println(result);
    }

    @Test
    public void testSelectTest() {
        Person result = person_Dao.selectByPrimaryKey(1);
        System.out.println(result.getUserName());
    }

}
