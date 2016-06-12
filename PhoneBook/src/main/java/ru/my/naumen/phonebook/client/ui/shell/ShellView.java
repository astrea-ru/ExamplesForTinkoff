package ru.my.naumen.phonebook.client.ui.shell;


import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;

public class ShellView extends ResizeComposite
        implements IShellView,
        ProvidesResize,
        RequiresResize {

    private IShellView.IShellPresenter presenter;

    private DockLayoutPanel shellPanel;

    /*private FlowLayoutPanel profileView;*/

    private Widget masterWidget;
    /*private Widget profileWidget;*/


    public ShellView() {
        shellPanel = new DockLayoutPanel(Style.Unit.PX);
        shellPanel.setSize("850px",
                "100%");
        //DockLayoutPanel profilePanel = new DockLayoutPanel(Style.Unit.PX);

        /*shellPanel.addSouth(profilePanel,
                360);

        profileView = new FlowLayoutPanel();
        profilePanel.addWest(profileView,
                425);*/

        initWidget(shellPanel);
    }

    @Override
    public void setMasterView(Widget widget) {
        if (masterWidget != null) {
            masterWidget.removeFromParent();
        }
        shellPanel.add(widget);
        masterWidget = widget;
    }

    /*@Override
    public void setProfileView(Widget widget) {
        if (profileWidget != null) {
            profileWidget.removeFromParent();
        }
        profileView.add(widget);
        profileWidget = widget;
    }*/

    @Override
    public IShellView.IShellPresenter getPresenter() {
        return this.presenter;
    }


    @Override
    public void setPresenter(IShellView.IShellPresenter presenter) {
        this.presenter = presenter;
    }
}
