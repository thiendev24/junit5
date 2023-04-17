package com.junit5.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileWriterTest {

    @Test
    void ensureThatPathFromTempDirIsWritable(@TempDir Path path) {
        // Check if the path created by the TempDir extension is writable
        // Check `Files` API for this

        Assertions.assertTrue(Files.isWritable(path));
    }

    @Test
    void ensureThatNonExistingFileThrowsAnException(@TempDir Path path) {
        Path file = path.resolve("content.txt");
        Assertions.assertThrows(
                IOException.class,
                () -> FileWriter.appendFile(file, "Hello")
        );
    }

    @Test
    void ensureAppendingWorks(@TempDir Path path) throws IOException {
        Path file = path.resolve("content.txt");
        FileWriter.createFile(file);
        FileWriter.appendFile(file, "Hello");

        Assertions.assertTrue(Files.isReadable(file));
        // TODO check the content of the file
    }

}