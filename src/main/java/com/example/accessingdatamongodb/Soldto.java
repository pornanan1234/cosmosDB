package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

public class Soldto {

    @Id
    public String id;

    public String uniqueid;
    public String region;
    public String stripeNumber;
    public String salesOrg;
    public String distributionChannel;
    public String division;
    public String customerGroup;

    public String getCustomerGroup() {
        return customerGroup;
    }

    public String salesArea;

    public String getSalesArea() {
        return salesArea;
    }

    public void setDefaultSoldTo(boolean defaultSoldTo) {
        isDefaultSoldTo = defaultSoldTo;
    }

    public boolean isDefaultSoldTo;
    public List<Shipto> shipTos;
    public List<Payer> payers;

    public Soldto() {}
    public Soldto(Soldto soldto) {
        this.uniqueid = soldto.uniqueid;
        this.region = soldto.region;
        this.stripeNumber = soldto.stripeNumber;
        this.salesOrg = soldto.salesOrg;
        this.distributionChannel = soldto.distributionChannel;
        this.division = soldto.division;
        this.isDefaultSoldTo = soldto.isDefaultSoldTo;
        this.shipTos = soldto.shipTos;
        this.customerGroup=soldto.customerGroup;
        this.payers = soldto.payers;
        this.salesArea =soldto.salesArea;


    }


    public Soldto(String region, String stripeNumber, String salesOrg, String distributionChannel, String division,String customerGroup
            , boolean isDefaultSoldTo) {
        this.uniqueid = region + "_" + stripeNumber + "_"+salesOrg+"_" + distributionChannel +"_"+division;
        this.salesArea = salesOrg+"_" + distributionChannel +"_"+division;
        this.region = region;
        this.stripeNumber = stripeNumber;
        this.salesOrg = salesOrg;
        this.distributionChannel = distributionChannel;
        this.division = division;
        this.customerGroup=customerGroup;
        this.isDefaultSoldTo = isDefaultSoldTo;
    }

    public Soldto(String region, String stripeNumber, String salesOrg, String distributionChannel, String division,String customerGroup
            , boolean isDefaultSoldTo, List<Shipto> shipTos ,List<Payer> payers ) {
        this.uniqueid = region + "_" + stripeNumber + "_"+salesOrg+"_" + distributionChannel +"_"+division;
        this.region = region;
        this.salesArea = salesOrg+"_" + distributionChannel +"_"+division;
        this.stripeNumber = stripeNumber;
        this.salesOrg = salesOrg;
        this.distributionChannel = distributionChannel;
        this.division = division;
        this.isDefaultSoldTo = isDefaultSoldTo;
        this.shipTos = shipTos;
        this.customerGroup=customerGroup;
        this.payers = payers;

    }

    public String getStripeNumber() {
        return stripeNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Soldto[ region='%s', uniqueid='%s ,customerGroup='%s, shipTos='%s']",
                 region, uniqueid,customerGroup,shipTos);
    }

}

