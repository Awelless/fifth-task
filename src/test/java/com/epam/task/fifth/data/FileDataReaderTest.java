package com.epam.task.fifth.data;

import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {

    private final FileDataReader fileDataReader = new FileDataReader();

    private static final String CORRECT_FILENAME = "src/test/resources/input.txt";
    private static final String INCORRECT_FILENAME = "src/test/resources/input123.txt";

    @Test
    public void testReadShouldReadWhenCorrectFilenameApplied() throws DataException {
        String expected = "Test 123.\n" +
                "A asd. B.";

        String actual = fileDataReader.read(CORRECT_FILENAME);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenIncorrectFilenameApplied() throws DataException {
        fileDataReader.read(INCORRECT_FILENAME);
    }
}
