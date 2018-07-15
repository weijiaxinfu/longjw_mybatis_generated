package com.xixi.longjw.serverimpl;

import com.xixi.longjw.dao.PersonMapper;
import com.xixi.longjw.model.Person;
import com.xixi.longjw.server.PersonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



@SuppressWarnings("ALL")
@Repository
@CacheConfig(cacheNames = "personCache")
public class PersonServerImpl implements PersonServer {

    @Autowired
    private PersonMapper personMapper;


    @Override
    @Cacheable(key = "#p0")
    public Person find(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addPerson(Person person) {

    }

}
