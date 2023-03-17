package com.company.test.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ContactType implements EnumClass<Integer> {

    EMAIL(10),
    PHONE_NUMBER(20);

    private Integer id;

    ContactType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static ContactType fromId(Integer id) {
        for (ContactType at : ContactType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}