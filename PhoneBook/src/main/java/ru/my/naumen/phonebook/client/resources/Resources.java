package ru.my.naumen.phonebook.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resources
    extends ClientBundle {

  Resources CSS = GWT.create(Resources.class);

  @Source("PhoneBook.css")
  public PhoneBookCssStyles phoneBook();


  public interface PhoneBookCssStyles
      extends CssResource {

    String addButtom();

    String clear();

    String container();

    String containerHeadline();

    String fieldContainerLabel();

    String fieldContainerWidget();

    String label();

    String removeButton();

    String selectedRoles();
  }
}
