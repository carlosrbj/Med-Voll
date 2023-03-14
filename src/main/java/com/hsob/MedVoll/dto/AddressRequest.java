package com.hsob.MedVoll.dto;

public record AddressRequest(String cep, String street, String number, String complement, String neighborhood, String city, String state) {
}
