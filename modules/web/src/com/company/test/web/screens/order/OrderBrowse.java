package com.company.test.web.screens.order;

import com.company.test.entity.Account;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@UiController("test_Orders.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
    private static final Logger log = LoggerFactory.getLogger(OrderBrowse.class);
    private Account account;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private CollectionLoader<Order> ordersDl;

    @Inject
    DataManager dataManager;

    public void setSelectedAccount(Account selectedAccount){
        this.account = selectedAccount;
    }

    private View view;

    private static Order order;

    @Install(to = "ordersDl", target = Target.DATA_LOADER)
    private List<Order> ordersDlLoadDelegate(LoadContext<Order> loadContext) {
        log.info(loadContext.getQuery().getQueryString());
        loadContext.setQuery(LoadContext.createQuery("select u from test_Orders u where u.account = :account")
                .setParameter("account", this.account));
        view = loadContext.getView();
        return dataManager.loadList(loadContext);
    }

    @Subscribe("ordersTable.create")
    public void onOrdersTableCreate(Action.ActionPerformedEvent event) {
        screenBuilders.editor(Order.class, this)
                .withInitializer(order -> order.setDate(LocalDateTime.now()))
                .build()
                .show()
                .addAfterCloseListener((e) -> ordersDl.load());
    }


}