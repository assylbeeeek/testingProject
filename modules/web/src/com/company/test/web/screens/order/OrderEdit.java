package com.company.test.web.screens.order;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Order;

import javax.inject.Inject;

@UiController("test_Orders.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
//    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OrderEdit.class);
    @Inject
    private Button createBtn;

    @Inject
    private EntityStates entityStates;

    @Inject
    DataManager dataManager;

    Order order;
//    private Account account;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        createBtn.setEnabled(!entityStates.isNew(getEditedEntity()));
    }

//    @Subscribe
//    public void onInitEntity(InitEntityEvent<Order> event) {
//        order = event.getEntity();
//    }
//
//    @Subscribe
//    public void onAfterClose(AfterCloseEvent event) {
//        OrderBrowse.setOrderEntity(this.order);
//    }
//




//    @Inject
//    private DateField<LocalDateTime> dateField;
//
//    @Named("accountField.lookup")
//    private LookupAction<Account> accountFieldLookup;
//
//    @Subscribe
//    public void onInitEntity(InitEntityEvent<Order> event) {
//        PickerField<Account> pickerField = null;
//        pickerField.setValue(this.account);
//        log.info(this.account.getFirstName());
//        accountFieldLookup.setPickerField(pickerField);
//        LocalDateTime localDateTimeNow = LocalDateTime.now();
//        dateField.setValue(localDateTimeNow);
//        DateField<LocalDateTime> settingDatefield = null;
//        settingDatefield.setValue(localDateTimeNow);
//        this.setDateField(settingDatefield);
//
//    }
//
//    public void setAccount(Account account){
//        this.account = account;
//    }
//
//    public void setDateField(DateField<LocalDateTime> dateField) {
//        this.dateField = dateField;
//    }


}