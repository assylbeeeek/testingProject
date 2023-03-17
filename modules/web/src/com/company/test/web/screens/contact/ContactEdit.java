package com.company.test.web.screens.contact;

import com.company.test.entity.Account;
import com.company.test.entity.ContactType;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.ValidationErrors;
import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Contact;
import org.slf4j.Logger;

import java.util.Collection;

@UiController("test_Contact.edit")
@UiDescriptor("contact-edit.xml")
@EditedEntityContainer("contactDc")
@LoadDataBeforeShow
public class ContactEdit extends StandardEditor<Contact> {
    ContactType contactType;
    String contactValue;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ContactEdit.class);

    @Subscribe("contactValueField")
    public void onContactValueFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        contactValue = event.getValue();
    }

    @Subscribe("contactTypeField")
    public void onContactTypeFieldValueChange(HasValue.ValueChangeEvent<ContactType> event) {
        contactType = event.getValue();
    }

    @Subscribe
    public void onValidation(ValidationEvent event) {
        ValidationErrors errors = customContactsValidation();
        if (errors == null){
            return;
        }
        log.info(errors.getAll().get(0).toString());
        event.addErrors(errors);
    }

    private ValidationErrors customContactsValidation(){
        boolean error;
        String message = "Все правильно";
        if (isEmail(contactType)){
            error = contactValue.matches("^(.+)@(.+).(.+)$");
            if (!error){
                message = "Email is not valid";
            }
        }
        if (isNumber(contactType)){
            error = contactValue.matches("^\\+[0-9]\\(\\d\\) \\d\\-\\d\\-\\d$");
            if (!error) {
                message = "Number is not valid";
            }
        }
        ValidationErrors validationErrors = new ValidationErrors();
        validationErrors.add(message);
        if (!message.equals("Все правильно")){
            return validationErrors;
        }
        else {
            return null;
        }
    }

    private boolean isEmail(ContactType contactType){
        return contactType.equals(ContactType.EMAIL);
    }

    private boolean isNumber(ContactType contactType){
        return contactType.equals(ContactType.PHONE_NUMBER);
    }
}