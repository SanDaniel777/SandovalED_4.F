package com.example.demo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters and setters
@AllArgsConstructor //constructor parametrizado(todos los atributos)
@NoArgsConstructor //constructor sin parametros
public class CustomRequest {
    String data;



}
