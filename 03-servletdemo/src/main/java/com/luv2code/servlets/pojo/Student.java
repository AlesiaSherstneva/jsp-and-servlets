package com.luv2code.servlets.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
}