package com.population;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.contains;
import static org.powermock.api.mockito.PowerMockito.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

import java.nio.file.Files;
import java.nio.file.Paths;

public class UserFileReaderTest {

    @Test
    public void checkNullThrowsException()  {
        assertThrows(IllegalArgumentException.class, () -> UserFileReader.readFile(null));
    }

    @Test
    public void checkEmptyFileReturnsEmptyList()  throws IOException {
        Files files = mock(Files.class);
        when(files.readAllLines(Paths.get("src/test/java/com/testData/emptyfile.csv"), StandardCharsets.ISO_8859_1)).thenReturn(Collections.emptyList());
        List<String> lines = UserFileReader.readFile("src/test/java/com/testData/emptyfile.csv");

        assertThat(lines.isEmpty(), is(true));
    }

    /*@Test
    public void checkOneLineFileReturnsOneElement()  throws IOException  {
        Files files = mock(Files.class);
        when(Files.readAllLines(Paths.get("src/test/java/com/testData/oneLineFile.csv"), StandardCharsets.ISO_8859_1)).thenReturn(Collections.emptyList());
        List<String> lines = UserFileReader.readFile("src/test/java/com/testData/oneLineFile.csv");

        assertThat(lines, contains("aasdas,sdfsdf,sdfsdf,sdsdfds,444"));
        assertThat(lines.size(), is(1));
    }*/
}
