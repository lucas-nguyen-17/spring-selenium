package com.giangtester.localhost.table;

import com.giangtester.localhost.framework.Element;

import java.util.List;
import java.util.function.Function;

public class PersonMapper {

    public final static Function<List<Element>, Person> PERSON_FUNCTION_MAPPER =
            cells -> new Person(
                    Integer.parseInt(cells.get(0).getText()),
                    cells.get(1).getText(),
                    cells.get(2).getText(),
                    Integer.parseInt(cells.get(3).getText())
            );
}