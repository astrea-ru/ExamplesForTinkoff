package ru.my.naumen.phonebook.client;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;
import ru.my.naumen.phonebook.client.ui.record.RecordListPresenter;
import ru.my.naumen.phonebook.client.ui.shell.ShellPresenter;
import ru.my.naumen.phonebook.shared.Record;

@Events(startPresenter = ShellPresenter.class,
        historyOnStart = false)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface PhoneBookEventBus extends EventBus {

    @Start
    //@Event(handlers = {RecordListPresenter.class})
    @Event(handlers = RecordListPresenter.class)
    public void start();

    @Event(handlers = ShellPresenter.class)
    public void setMasterView(Widget widget);

    //@Event(handlers = {RecordListPresenter.class})
    @Event(handlers = RecordListPresenter.class)
    public void showRecordList();

    //@Event(handlers = {RecordListPresenter.class})
    @Event(handlers = RecordListPresenter.class)
    public void selectRecord(Record record);

    //@Event(handlers = {RecordListPresenter.class})
    @Event(handlers = RecordListPresenter.class)
    public void unselectRecord();

    //@Event(handlers = {RecordListPresenter.class})
    @Event(handlers = RecordListPresenter.class)
    public void createNewRecord(Record record);

}
