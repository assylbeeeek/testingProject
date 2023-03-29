package com.company.test.web.screens.product;

import com.company.test.entity.Order;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Product;

import javax.inject.Inject;

@UiController("test_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
//    private Order order;
//
//    @Subscribe
//    public void onInitEntity(InitEntityEvent<Product> event) {
//        this.order = event.getEntity().getOrder();
//    }
//
//    @Inject
//    private TextField<Double> priceField;
//    @Inject
//    private TextField<Double> quantityField;
//
//    @Subscribe
//    public void onAfterClose(AfterCloseEvent event) {
//        Double res = priceField.getValue() * quantityField.getValue();
//        this.order.setAmountFromProductEdit(res);
//    }


}