package com.hsob.MedVoll.model;

import com.hsob.MedVoll.dto.AddressRequest;
import jakarta.persistence.Embeddable;
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

    public void updateInfo(AddressRequest address) {
        if (address.cep() != null) this.cep = address.cep();
        if (address.street() != null) this.cep = address.street();
        if (address.number() != null) this.cep = address.number();
        if (address.complement() != null) this.cep = address.complement();
        if (address.neighborhood() != null) this.cep = address.neighborhood();
        if (address.city() != null) this.cep = address.city();
        if (address.state() != null) this.cep = address.state();
    }
}
