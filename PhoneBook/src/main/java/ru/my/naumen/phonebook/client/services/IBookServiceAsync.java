package ru.my.naumen.phonebook.client.services;


import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.my.naumen.phonebook.server.RecordEception;
import ru.my.naumen.phonebook.shared.Record;

import java.util.List;

public interface IBookServiceAsync {
    void getRecords(AsyncCallback<List<Record>> async);

    void deleteRecord(Record record, AsyncCallback<Void> async);

    void createRecord(Record record, AsyncCallback<Record> async) throws RecordEception;

    void updateUser(Record record, AsyncCallback<Record> async) throws RecordEception;
}
