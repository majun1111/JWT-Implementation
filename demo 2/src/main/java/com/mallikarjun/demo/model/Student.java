package com.mallikarjun.demo.model;

import lombok.*;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@RestController
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private int id;

    private String name;

    private int marks;

}
