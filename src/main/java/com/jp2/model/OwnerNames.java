package com.jp2.model;

import org.springframework.stereotype.Component;

@Component
public class OwnerNames {

    public String[] GetOwnerNames() {
        String[] array = {"VAT","FirstName","LastName","Address","Type","E-Mail","Password","Brand","Plate"};
        return array;
    }
}
