package com.giangtester.localhost.table;

import com.giangtester.localhost.framework.Element;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.giangtester.localhost.framework.locators.TagName.*;

public class Table<T> {

    private final Element table;
    private final Function<List<Element>, T> rowMapper;

    public Table(Element table, Function<List<Element>, T> rowMapper) {
        this.table = table;
        this.rowMapper = rowMapper;
    }

    private List<String> getHeaders() {
        return table.findElements(TH)
                .map(Element::getText)
                .collect(Collectors.toList());
    }

    private List<T> getRows() {
        return table.await(TBODY)
                .findElements(TR)
                .map(tr -> rowMapper
                        .apply(tr.findElements(TD).collect(Collectors.toList()))
                ).collect(Collectors.toList());
    }

    public TableContents<T> getContents() {
        return new TableContents<>(getHeaders(), getRows());
    }
}