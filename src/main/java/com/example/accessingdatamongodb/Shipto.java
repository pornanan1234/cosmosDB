package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Shipto {

    @Id
    public String id;

    public String stripeNumber;
    public Payer payer;

    public Shipto() {}

    public Shipto(String stripeNumber) {
        this.stripeNumber = stripeNumber;

    }

    public Shipto(String stripeNumber, Payer payer) {
        this.stripeNumber = stripeNumber;
        this.payer = payer;

    }

    @Override
    public String toString() {
        return String.format(
                "Shipto[ stripeNumber='%s']",
                stripeNumber);
    }

}

