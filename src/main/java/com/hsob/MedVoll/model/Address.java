package com.hsob.MedVoll.model;

import com.hsob.MedVoll.dto.AddressRequest;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    private String cep;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    public Address(AddressRequest addressRequest) {
        this.cep = addressRequest.cep();
        this.street = addressRequest.street();
        this.number = addressRequest.number();
        this.complement = addressRequest.complement();
        this.neighborhood = addressRequest.neighborhood();
        this.city = addressRequest.city();
        this.state = addressRequest.state();
    }
}
