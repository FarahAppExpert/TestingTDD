package com.example.test;

import org.junit.Test;

import static com.example.test.FirstNameExtractor.extractAge;
import static com.example.test.FirstNameExtractor.extractFirstName;
import static com.example.test.FirstNameExtractor.extraxtNumber;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

   public static final String FirstName = "Farah";
   public static final int Number1 = 100;
   public static final int Number2 = 50;


    @Test
    public void extractFirstName_NullInput_ReturnEmptyString ()
    {
        assertThat(extractFirstName(""), is(""));
    }


    @Test
    public void extractAge_NullInput_ReturnEmptyString ()
    {
        assertThat(extractAge(0), is(0));
    }

    @Test
    public void extractFirstName_InputData_ReturnString ()
    {
        assertThat(extractFirstName(FirstName), is("Farah"));
    }

    @Test
    public void extraxtNumber_InputNull_ReturnEmptyInt ()
    {
        assertThat(extraxtNumber(Number1, Number2), is(50));
    }

}

