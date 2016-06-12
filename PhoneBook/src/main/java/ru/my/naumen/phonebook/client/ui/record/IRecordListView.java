package ru.my.naumen.phonebook.client.ui.record;


import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.ReverseViewInterface;
import ru.my.naumen.phonebook.shared.Record;

import java.util.List;

public interface IRecordListView extends IsWidget,
        ReverseViewInterface<IRecordListView.IRecordListPresenter> {

    void setRecordList(List<Record> recordList);

    void setRecordSelected(boolean enabled);

    public interface IRecordListPresenter {

        public void doDeleteRecord(Record record);

        public void doNewRecord();

        public void doShowRecord(Record record);

    }
}