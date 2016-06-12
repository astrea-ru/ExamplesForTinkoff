package ru.my.naumen.phonebook.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.my.naumen.phonebook.client.services.IBookService;
import ru.my.naumen.phonebook.shared.Record;

import java.util.ArrayList;
import java.util.List;

public class BookService extends RemoteServiceServlet implements IBookService{

    static private List<Record> records = new ArrayList<>(); //TODO: подумать над синхронизацией

    static private long currentId;

    private static synchronized long nextId(){
        currentId++;
        return currentId;
    }

    static {
        currentId=0;
        records.add(new Record(nextId(), "Alex", "646546546"));
        records.add(new Record(nextId(),"John","54546"));
        records.add(new Record(nextId(),"Natalia","54658"));
        records.add(new Record(nextId(),"Isolde","546545"));
        records.add(new Record(nextId(),"Artem","555555"));
        records.add(new Record(nextId(),"Sergey","32444548"));
        records.add(new Record(nextId(),"Tomash","5465465488"));
        records.add(new Record(nextId(),"Nick","111111"));
    }

    @Override
    public List<Record> getRecords() {
        return records;
    }

    @Override
    public void deleteRecord(Record record) {
        for(Record recordCur: records){
            if (recordCur.getId().equals(record.getId())){
                records.remove(recordCur);
                return;
            }
        }
    }

    @Override
    public Record createRecord(Record record) throws RecordEception {
        for (Record tmpRecord: records){
            if (tmpRecord.getName().equals(record.getName()) ||
                    tmpRecord.getPhone().equals(record.getPhone()))
                throw new RecordEception("Имеется дубликат");
        }
        record.setId(nextId());
        records.add(record);
        return record;
    }

    @Override
    public Record updateUser(Record record) throws RecordEception {
        for (Record tmpRecord: records){
            if (tmpRecord.getName().equals(record.getName()) ||
                    tmpRecord.getPhone().equals(record.getPhone()))
                throw new RecordEception("Имеется дубликат");
        }
        for (Record tmpRecord: records){
            if (tmpRecord.getId().equals(record.getId())){
                tmpRecord.setName(record.getName());
                tmpRecord.setPhone(record.getPhone());
                break;
            }
        }
        return record;
    }
}
