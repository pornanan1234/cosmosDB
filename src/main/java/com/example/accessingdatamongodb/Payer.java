package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Payer {

    @Id
    public String id;

    public String stripeNumber;

    public Payer() {}

    public Payer(String stripeNumber) {
        this.stripeNumber = stripeNumber;

    }

    @Override
    public String toString() {
        return String.format(
                "Payer[ stripeNumber='%s']",
                stripeNumber);
    }

}

