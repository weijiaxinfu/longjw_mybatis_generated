package com.xixi.longjw.controller;

import com.xixi.longjw.dao.PersonMapper;
import com.xixi.longjw.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SuppressWarnings("ALL")
@RequestMapping("/Person")
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/hello")
    public String helloMybatis() {
        return "hello";
    }

    @GetMapping("/search/{id}")//http://localhost:8080/Person/search/3
    @ResponseBody
    public Person findPersonById(@PathVariable(value = "id") Integer id) {
        Person person = personMapper.selectByPrimaryKey(id);
        return person;
    }

    @GetMapping("/search2")//http://localhost:8080/Person/search2?id=1
    @ResponseBody
    public Person findPersonById2(@RequestParam(value = "id") Integer id) {
        Person person = personMapper.selectByPrimaryKey(id);
        return person;
    }

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) {
        Integer i = personMapper.insertPerson(person);
        return "/hello";
    }

}
