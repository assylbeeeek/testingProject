package com.company.test.web.screens.order;

import com.company.test.entity.Product;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.actions.list.CreateAction;
import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.actions.list.RemoveAction;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Order;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("test_Orders.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow

public class OrderEdit extends StandardEditor<Order> {
    @Inject
    private Button createBtn;

    @Inject
    private EntityStates entityStates;


    @Named("productsTable.create")
    private CreateAction<Product> productsTableCreate;
    @Named("productsTable.edit")
    private EditAction<Product> productsTableEdit;
    @Named("productsTable.remove")
    private RemoveAction<Product> productsTableRemove;
    @Inject
    private InstanceLoader<Order> test;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        createBtn.setEnabled(!entityStates.isNew(getEditedEntity()));
        productsTableCreate.setAfterCloseHandler((e) -> test.load());
        productsTableEdit.setAfterCloseHandler((e) -> test.load());
        productsTableRemove.setAfterActionPerformedHandler((e) -> test.load());
    }

}