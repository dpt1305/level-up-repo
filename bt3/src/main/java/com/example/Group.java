package com.example;

import com.example.annotations.ABean;
import com.example.annotations.Inject;

@ABean
public class Group {
    @Inject
    private Student std;

    public Group() {
    }
}
