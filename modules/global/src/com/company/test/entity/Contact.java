package com.company.test.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "TEST_CONTACT")
@Entity(name = "test_Contact")
public class Contact extends StandardEntity {
    private static final long serialVersionUID = -7354772317486310939L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Column(name = "CONTACT_TYPE", nullable = false)
    @NotNull
    private Integer contactType;

    @NotNull
    @Column(name = "CONTACT_VALUE", nullable = false, length = 50)
    private String contactValue;

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public ContactType getContactType() {
        return contactType == null ? null : ContactType.fromId(contactType);
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType == null ? null : contactType.getId();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}