package com.example.bt7.service;

import com.example.bt7.Person;

public interface IService {
    
    void initIndexing();
    Person findPerson(String name);
}
