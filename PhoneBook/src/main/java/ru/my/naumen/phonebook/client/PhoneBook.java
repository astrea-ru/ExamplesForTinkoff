package ru.my.naumen.phonebook.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;
import ru.my.naumen.phonebook.client.resources.Resources;


public class PhoneBook implements EntryPoint {
    @Override
    public void onModuleLoad() {
        Resources.CSS.phoneBook()
                .ensureInjected();

        Mvp4gModule module = GWT.create(Mvp4gModule.class);
        module.createAndStartModule();
        RootLayoutPanel.get()
                .add((Widget) module.getStartView());
    }
}
