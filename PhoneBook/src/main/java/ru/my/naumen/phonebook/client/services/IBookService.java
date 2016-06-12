package ru.my.naumen.phonebook.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.my.naumen.phonebook.server.RecordEception;
import ru.my.naumen.phonebook.shared.Record;

import java.util.List;

@RemoteServiceRelativePath("bookService")
public interface IBookService extends RemoteService {

    public List<Record> getRecords();

    public void deleteRecord(Record record);

    public Record createRecord(Record record) throws RecordEception;

    public Record updateUser(Record record) throws RecordEception;

}