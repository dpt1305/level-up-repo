package com.example.bt7.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bt7.Person;

public class IndexingService implements IService{
    private List<Person> array ;
    private Map<String, Person> hashMap = new HashMap<>();

    public IndexingService(List<Person> array) {
        this.array = array;
    }

    @Override
    public void initIndexing() {
        this.hashMap = new HashMap<>();
        for (Person person : array) {
            hashMap.put(person.getName(), person);
        }
    }

    @Override
    public Person findPerson(String name) {
        return this.hashMap.get(name);
    }

}
