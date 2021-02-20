package com.epam.task.fifth.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileDataReader {

    private static final Logger LOGGER = LogManager.getLogger(FileDataReader.class);

    public String read(String filename) throws DataException {
        InputStreamReader inputStreamReader = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            inputStreamReader = new InputStreamReader(fileInputStream);

            StringBuilder builder = new StringBuilder();

            while(inputStreamReader.ready()) {
                char value = (char) inputStreamReader.read();
                builder.append(value);
            }

            return builder.toString();

        } catch (IOException e) {
            throw new DataException(e);
        } finally {
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                LOGGER.warn(e.getMessage(), e);
            }
        }
    }

}
