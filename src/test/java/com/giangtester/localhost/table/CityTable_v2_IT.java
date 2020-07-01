package com.giangtester.localhost.table;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import com.giangtester.localhost.framework.Browser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.giangtester.localhost.framework.locators.TagName.TABLE;
import static com.giangtester.localhost.table.CityMapper.CITY_FUNCTION_MAPPER;
import static java.util.Arrays.asList;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SeleniumRunner
public class CityTable_v2_IT {

    private static final TableContents<City> EXPECTED = new TableContents<>(
            asList("Id", "City Name", "State Name"),
            asList(
                    new City(1, "Xian", "Shanxi")
                    , new City(2, "Guangzhou", "Guangdong")
                    , new City(3, "Shaoguan", "Guangdong")
                    , new City(4, "Tianjin", "Tianjin")
                    , new City(5, "Changsha", "Huana")
                    , new City(6, "Shenzhen", "Guangzhou")
                    , new City(7, "Hong Kong", "Hong Kong")
                    , new City(8, "Hangzhou", "Zhejiang")
                    , new City(9, "Singapore", "Singapore")
                    , new City(9, "New York", "New York")
                    , new City(10, "Sydney", "New South Wales")
                    , new City(11, "Dallas", "Texas")
            )
    );
    private static final TableContents<City> OUTDATED_EXPECTED = new TableContents<>(
            asList("Id", "City Name", "State Name"),
            asList(
                    new City(1, "Xian", "Shanxi")
                    , new City(2, "Guangzhou", "Guangdong")
                    , new City(3, "Shaoguan", "Guangdong")
                    , new City(4, "Dallas", "Texas")
            )
    );
    @Autowired
    private Browser browser;

    @BeforeEach
    public void gotoSite() {
        browser.get("/city-table.html");
    }

    @Test
    public void testReadFromTableJava8() {

        Table<City> table = new Table<>(browser.await(TABLE),
                cells ->
                        new City(Integer.parseInt(cells.get(0).getText()),
                                cells.get(1).getText(),
                                cells.get(2).getText())
        );

        TableContents<City> actual = table.getContents();

        assertEquals(EXPECTED.describeDiff(actual), EXPECTED, actual);
    }

    @Test
//    @Disabled("You can remove this to run it and check the output")
    public void testReadFromTableButFailed() {

        Table<City> table = new Table<>(
                browser.await(TABLE), CITY_FUNCTION_MAPPER
        );

        TableContents<City> actual = table.getContents();

        assertEquals(OUTDATED_EXPECTED.describeDiff(actual), OUTDATED_EXPECTED, actual);
    }
}