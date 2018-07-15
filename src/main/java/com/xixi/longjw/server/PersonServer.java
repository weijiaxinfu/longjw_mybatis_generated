package com.xixi.longjw.server;

import com.xixi.longjw.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface PersonServer {
    public Person  find(Integer id);

    public void  addPerson(Person person);
}
