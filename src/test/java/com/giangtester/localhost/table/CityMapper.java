package com.giangtester.localhost.table;


import com.giangtester.localhost.framework.Element;

import java.util.List;
import java.util.function.Function;

public class CityMapper {

    public final static Function<List<Element>, City> CITY_FUNCTION_MAPPER =
            cells ->
                    new City(Integer.parseInt(cells.get(0).getText()),
                            cells.get(1).getText(),
                            cells.get(2).getText());
}