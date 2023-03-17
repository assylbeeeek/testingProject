package com.company.test.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.slf4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "TEST_ACCOUNT")
@Entity(name = "test_Account")
@NamePattern("%s|firstName")
public class Account extends StandardEntity {
    private static final long serialVersionUID = -3471013186695929507L;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Account.class);

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @OneToMany(mappedBy = "account")
    private List<Order> orders;

    @NotNull
    @Column(name = "MIDDLE_NAME", nullable = false, length = 100)
    private String middleName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false, length = 100)
    private String lastName;

    @JoinColumn(name = "AVATAR_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private FileDescriptor avatar;

    @OneToMany(mappedBy = "account")
    private List<Contact> contactsList;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @MetaProperty(related={"firstName", "middleName", "lastName"})
    public String getFullName(){
        return this.lastName + " " + this.firstName + " " + this.middleName;
    }

    @MetaProperty(related = {"contactsList"})
    public String getContacts(){
        StringBuilder sb = new StringBuilder();
        if (contactsList == null || contactsList.isEmpty()){
            return "";
        }
        for (Contact contact : contactsList) {
            sb.append(contact.getContactValue()).append(" ");
        }
        return sb.toString();
    }

    public List<Contact> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public FileDescriptor getAvatar() {
        return avatar;
    }

    public void setAvatar(FileDescriptor avatar) {
        this.avatar = avatar;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}