package ru.my.naumen.phonebook.client.ui.record;


import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.my.naumen.phonebook.client.PhoneBookEventBus;
import ru.my.naumen.phonebook.client.services.IBookServiceAsync;
import ru.my.naumen.phonebook.shared.Record;

import java.util.List;

@Presenter(view = IRecordListView.class)
public class RecordListPresenter extends BasePresenter<IRecordListView, PhoneBookEventBus>
        implements IRecordListView.IRecordListPresenter {

    @Inject
    private IBookServiceAsync service;

    public void onStart() {
        eventBus.setMasterView(view.asWidget());
        eventBus.showRecordList();
    }

    public void onSelectRecord(Record record) {
        if (record != null) {
            view.setRecordSelected(true);
        } else {
            view.setRecordSelected(false);
        }
    }

    public void onUnselectRecord() {
        view.setRecordSelected(false);
    }

    public void onShowUserList() {
        service.getRecords(new AsyncCallback<List<Record>>() {
            public void onFailure(Throwable caught) {
                Window.alert("panic");
            }

            public void onSuccess(List<Record> result) {
                view.setRecordList(result);
                eventBus.unselectRecord();
            }
        });
    }

    @Override
    public void doDeleteRecord(Record record) {
        service.deleteRecord(record,
                new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("PANIC!");
                    }

                    @Override
                    public void onSuccess(Void result) {
                        eventBus.showRecordList();
                    }
                });
    }

    @Override
    public void doNewRecord() {
        eventBus.createNewRecord(new Record());
    }

    @Override
    public void doShowRecord(Record record) {
        eventBus.selectRecord(record);
    }
}
