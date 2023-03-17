package com.company.test.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import jdk.nashorn.internal.runtime.options.Option;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "TEST_ORDERS")
@Entity(name = "test_Orders")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 5051661222363670823L;

    @Column(name = "DATE_", nullable = false)
    @NotNull
    private LocalDateTime date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Column(name = "AMOUNT")
    private Double amount = Double.valueOf(0);

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setAmountFromProductEdit(Double amount) {
        this.amount = this.amount + amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}