package com.xixi.longjw.serverImpl;

import com.xixi.longjw.model.Person;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.xixi.longjw.server.PersonServer;

import javax.annotation.Resource;


@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServerImplTest {

    @Autowired
    private PersonServer personServer;

    @Test
    public void find() {
        Person person = personServer.find(1);
        JSONObject jsonObject = JSONObject.fromObject(person);
        System.out.println(jsonObject);
    }
}