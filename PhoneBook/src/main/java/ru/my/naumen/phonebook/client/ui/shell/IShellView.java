package ru.my.naumen.phonebook.client.ui.shell;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.view.ReverseViewInterface;

public interface IShellView extends ReverseViewInterface<IShellView.IShellPresenter> {

    void setMasterView(Widget widget);

    public interface IShellPresenter {

    }

}
