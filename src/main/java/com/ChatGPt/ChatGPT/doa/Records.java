package com.ChatGPt.ChatGPT.doa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Records {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    String Username;
    String password;

}
