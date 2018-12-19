package com.jp2.model;

import org.springframework.stereotype.Component;

@Component
public class OwnerSearchNames {

    public String[] GetOwnerNames() {
        String[] array = {"VAT","EMAIL"};
        return array;
    }
}
