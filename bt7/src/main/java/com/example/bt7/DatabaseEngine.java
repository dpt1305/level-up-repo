package com.example.bt7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseEngine {
    private List<Person> array = new ArrayList<>();
    private Map<String, Person> hashMap = new HashMap<>();
    // private InterfaceFindPersonByStategy service; => sv1, sr2, sr3 
    
    public DatabaseEngine () {
        initDatabase();
    }

    private void initDatabase () {
        this.array.add(new Person("A", 10));
        this.array.add(new Person("B", 11));
        this.array.add(new Person("C", 12));
    }

    public void initIndexing() {
        for (Person p : array) {
            hashMap.put(p.getName(), p);
        }
    }

    public Person findWithoutIndex(String name) {
        for (Person p : this.array) {
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public Person findWithIndex(String name) {
        return hashMap.get(name);
    }

    public Person findWithBinaryIndex(String name) {
        return null;
    }
    // 
}
