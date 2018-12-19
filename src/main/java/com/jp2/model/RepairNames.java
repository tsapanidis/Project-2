package com.jp2.model;

import org.springframework.stereotype.Component;

@Component
public class RepairNames {

    public String[] GetRepairNames() {
        String[] array = {"VAT","Date","Status","Price","Type","Description"};
        return array;
    }
}
