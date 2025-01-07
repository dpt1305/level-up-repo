package com.example.bt7.service;

import java.util.List;

import com.example.bt7.Person;

public class NonIndexingService implements IService{
    private List<Person> array ;

    

    public NonIndexingService(List<Person> array) {
        this.array = array;
    }



    @Override
    public void initIndexing() {
        
    }



    @Override
    public Person findPerson(String name) {
        for (Person person : this.array) {
            if(person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    

}
