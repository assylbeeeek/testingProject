package com.company.test.web.screens.account;

import com.company.test.entity.Contact;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.actions.list.CreateAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Account;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("test_Account.edit")
@UiDescriptor("account-edit.xml")
@EditedEntityContainer("accountDc")
@LoadDataBeforeShow
public class AccountEdit extends StandardEditor<Account> {
    @Named("contactsTable.create")
    private CreateAction<Contact> contactsTableCreate;
    @Inject
    private EntityStates entityStates;
    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        contactsTableCreate.setEnabled(!entityStates.isNew(getEditedEntity()));
    }

}