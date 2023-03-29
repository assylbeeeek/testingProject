package com.company.test.listeners;

import com.company.test.entity.Order;
import com.company.test.entity.Product;

import java.util.List;
import java.util.UUID;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.entity.contracts.Id;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;

@Component("test_ProductChangedListener")
public class ProductChangedListener {

    @Inject
    private TransactionalDataManager transactionalDataManager;
    @Inject
    private Logger log;

    @EventListener
    public void beforeCommit(EntityChangedEvent<Product, UUID> event) {
        AttributeChanges changes = event.getChanges();
        if ((changes.isChanged("quantity")  || changes.isChanged("price"))) {
            Order order;
            if (event.getType() == EntityChangedEvent.Type.DELETED) {
                UUID orderUUID = (UUID) event.getChanges().getOldReferenceId("order").getValue();
                order = transactionalDataManager.load(Order.class)
                        .id(orderUUID)
                        .view("_local")
                        .one();
            } else {
                order = transactionalDataManager.load(event.getEntityId())
                        .view(builder -> builder.add("order", "_local"))
                        .one()
                        .getOrder();
            }

            List<Product> productList = transactionalDataManager.loadValue(
                            "select e from test_Product e where e.order = :order", Product.class)
                    .parameter("order", order)
                    .list();
            Double quantity, price;
            double res = 0;
            for (Product product : productList) {
                quantity = product.getQuantity();
                price = product.getPrice();
                res += quantity * price;
            }
            order.setAmount(res);
            transactionalDataManager.save(order);
        }
    }
}