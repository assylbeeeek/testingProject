package com.company.test.web.screens.account;
import com.company.test.web.screens.order.OrderBrowse;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Account;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.*;
import javax.inject.Inject;
import static com.haulmont.cuba.gui.components.Image.*;


@UiController("test_Account.browse")
@UiDescriptor("account-browse.xml")
@LookupComponent("accountsTable")
@LoadDataBeforeShow
public class AccountBrowse extends StandardLookup<Account> implements ScreenOptions {

    @Inject
    protected GroupTable<Account> accountsTable;

    @Inject
    protected UiComponents uiComponents;

    @Inject
    private Screens screens;

    private Account selectedAccount;

    @Subscribe("accountsTable")
    public void onAccountsTableSelection(Table.SelectionEvent<Account> event) {
//        final Account account = event.getSelected().toArray(new Account[0])[0];
//        new ArrayList<>(event.getSelected()).get(0);
        selectedAccount = event.getSelected().iterator().next();
    }


    @Subscribe
    protected void onInit(InitEvent event){
        accountsTable.addGeneratedColumn(
                "avatar",
                this::renderAvatarImageComponent
        );
    }

    public Component renderAvatarImageComponent(Account account) {
        FileDescriptor avatarFile = account.getAvatar();
        if (avatarFile == null){
            return null;
        }
        Image avatar = smallAvatarImage();
        avatar.setSource(FileDescriptorResource.class)
                .setFileDescriptor(avatarFile);
        return avatar;
    }

    public Image smallAvatarImage(){
        Image avatar = uiComponents.create(Image.class);
        avatar.setScaleMode(ScaleMode.CONTAIN);
        avatar.setHeight("60");
        avatar.setWidth("60");
        avatar.setStyleName("avatar-icon-small");
        return avatar;
    }

    @Subscribe
    public void openOrdersBrowser(){
        if (selectedAccount == null || selectedAccount.isDeleted()){
            screens.create(OrderBrowse.class).show();
        }
        else {
            OrderBrowse orderBrowseScreen = screens.create(OrderBrowse.class);
            orderBrowseScreen.setSelectedAccount(selectedAccount);
            orderBrowseScreen.show();
        }
    }
}
