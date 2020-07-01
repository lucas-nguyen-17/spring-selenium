package com.giangtester.localhost.table;

import com.giangtester.localhost.chapter7.SeleniumRunner;
import com.giangtester.localhost.framework.Browser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.giangtester.localhost.framework.locators.TagName.TABLE;
import static com.giangtester.localhost.table.PersonMapper.PERSON_FUNCTION_MAPPER;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SeleniumRunner
public class PersonTable_v2_IT {

    private static final TableContents<Person> EXPECTED = new TableContents<>(
            Arrays.asList("Id", "First Name", "Last Name", "Age"),
            Arrays.asList(
                    new Person(1, "Eve", "Jackson", 94)
                    , new Person(2, "John", "Doe", 80)
                    , new Person(3, "Adam", "Johnson", 67)
                    , new Person(4, "Jill", "Smith", 50)
            )
    );
    private static final TableContents<Person> EXPECTED_FAILURE = new TableContents<>(
            Arrays.asList("Id", "First Name", "Last Name", "Age"),
            Arrays.asList(
                    new Person(1, "Eve", "Jackson", 94)
                    , new Person(2, "John", "Doe", 80)
                    , new Person(4, "Jill", "Smith", 50)
                    , new Person(5, "Jack", "Clyde", 78)
            )
    );
    @Autowired
    private Browser browser;

    @BeforeEach
    public void gotoSite() {
        browser.get("/people-table.html");
    }

    @Test
    public void testReadFromTable() {

        Table<Person> table = new Table<>(browser.await(TABLE), PERSON_FUNCTION_MAPPER);

        TableContents<Person> actual = table.getContents();

        assertEquals(EXPECTED.describeDiff(actual), EXPECTED, actual);
    }

    @Test
    @Disabled("You can remove this to run it and check the output")
    public void missingExpectedValues() {

        Table<Person> table = new Table<>(browser.await(TABLE), PERSON_FUNCTION_MAPPER);

        TableContents<Person> actual = table.getContents();

        assertEquals(EXPECTED_FAILURE.describeDiff(actual), EXPECTED_FAILURE, actual);
    }
}
