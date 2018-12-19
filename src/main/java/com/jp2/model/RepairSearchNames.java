package com.jp2.model;

import org.springframework.stereotype.Component;

@Component
public class RepairSearchNames {

    public String[] GetRepairNames() {
        String[] array = {"DATE","VAT","PLATE"};
        return array;
    }
}
