package com.hsob.MedVoll.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String cep;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
}
