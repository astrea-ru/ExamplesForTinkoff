package ru.my.naumen.phonebook.client.ui.record;


import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import ru.my.naumen.phonebook.client.resources.Resources;
import ru.my.naumen.phonebook.client.ui.widgets.FlowLayoutPanel;
import ru.my.naumen.phonebook.shared.Record;

import java.util.List;

public class RecordListView extends ResizeComposite
        implements IRecordListView,
        ProvidesResize,
        RequiresResize {

    private IRecordListView.IRecordListPresenter presenter;

    private FlowLayoutPanel container;

    private DataGrid<Record> grid;

    private Button deleteButton;
    private Button newButton;

    private Record currentSelection;

    public RecordListView() {
        createView();

        bind();

        initWidget(container);
    }

    private void createView() {
        container = new FlowLayoutPanel();
        container.addStyleName(Resources.CSS.phoneBook()
                .container());

        DockLayoutPanel fpContainer = new DockLayoutPanel(Style.Unit.PX);
        fpContainer.setSize("100%",
                "100%");
        container.add(fpContainer);

        FlowLayoutPanel fp01 = new FlowLayoutPanel();
        Label la01 = new Label("Phone Book");
        la01.addStyleName(Resources.CSS.phoneBook()
                .containerHeadline());
        fp01.add(la01);
        fpContainer.addNorth(fp01,
                25);

        FlowLayoutPanel fp02 = new FlowLayoutPanel();
        fp02.getElement()
                .getStyle()
                .setMarginTop(8,
                        Style.Unit.PX);
        newButton = new Button("New");
        newButton.getElement()
                .getStyle()
                .setMarginRight(12,
                        Style.Unit.PX);
        fp02.add(newButton);
        deleteButton = new Button("Delete");
        fp02.add(deleteButton);
        fpContainer.addSouth(fp02,
                42);

        createGrid();
        FlowLayoutPanel fp03 = new FlowLayoutPanel();
        fp03.getElement()
                .getStyle()
                .setBorderWidth(1,
                        Style.Unit.PX);
        fp03.getElement()
                .getStyle()
                .setBorderStyle(Style.BorderStyle.SOLID);
        fp03.add(grid);
        fpContainer.add(fp03);
    }

    private void bind() {
        newButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                presenter.doNewRecord();
            }
        });

        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (currentSelection == null) {
                    Window.alert("Please select a user");
                } else {
                    if (Window.confirm("Are you sure?")) {
                        presenter.doDeleteRecord(currentSelection);
                    }
                }
            }
        });
    }

    private void createGrid() {
        grid = new DataGrid<Record>();
        grid.setHeight("100%");
        grid.getElement()
                .getStyle()
                .setOverflow(Style.Overflow.HIDDEN);


        addColumn(new ClickableTextCell(),
                "Name",
                new GetValue<String>() {
                    @Override
                    public String getValue(Record record) {
                        return record.getName();
                    }
                },
                new FieldUpdater<Record, String>() {
                    @Override
                    public void update(int index,
                                       Record object,
                                       String value) {
                        currentSelection = object;
                        presenter.doShowRecord(object);
                    }
                });

        addColumn(new ClickableTextCell(),
                "Phone",
                new GetValue<String>() {
                    @Override
                    public String getValue(Record record) {
                        return record.getPhone();
                    }
                },
                new FieldUpdater<Record, String>() {
                    @Override
                    public void update(int index,
                                       Record object,
                                       String value) {
                        currentSelection = object;
                        presenter.doShowRecord(object);
                    }
                });

    }

    /**
     * Add a column with a header.
     *
     * @param <C>        the cell type
     * @param cell       the cell used to render the column
     * @param headerText the header string
     * @param getter     the value getter for the cell
     */
    private <C> Column<Record, C> addColumn(Cell<C> cell,
                                              String headerText,
                                              final GetValue<C> getter,
                                              FieldUpdater<Record, C> fieldUpdater) {
        Column<Record, C> column = new Column<Record, C>(cell) {
            @Override
            public C getValue(Record object) {
                return getter.getValue(object);
            }
        };
        column.setFieldUpdater(fieldUpdater);
        grid.addColumn(column,
                headerText);
        return column;
    }

    @Override
    public void setRecordList(List<Record> userList) {
        grid.setRowData(0,
                userList);
        currentSelection = null;
    }

    @Override
    public void setRecordSelected(boolean enabled) {
        if (enabled) {
            deleteButton.setEnabled(true);
        } else {
            deleteButton.setEnabled(false);
        }
    }

    @Override
    public IRecordListView.IRecordListPresenter getPresenter() {
        return this.presenter;
    }

    @Override
    public void setPresenter(IRecordListPresenter presenter) {
        this.presenter = presenter;
    }


    /**
     * Get a cell value from a record.
     *
     * @param <T> the cell type
     */
    private static interface GetValue<T> {
        T getValue(Record user);

    }


}
