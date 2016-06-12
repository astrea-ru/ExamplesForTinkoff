package ru.my.naumen.phonebook.client.ui.shell;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.my.naumen.phonebook.client.PhoneBookEventBus;

@Presenter(view = IShellView.class)
public class ShellPresenter extends BasePresenter<IShellView, PhoneBookEventBus>
implements IShellView.IShellPresenter {

    public void onSetMasterView(Widget widget) {
        view.setMasterView(widget);
        }

}
