package com.github.sqltojava;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class JavaGeneratorTest {
    private JavaGenerator generator;
    @Before
    public void setUp() throws Exception {
        String basedir = "test";
        List<String> files = Arrays.asList("file1", "file2");
        String outPackage = "out";
        generator = new JavaGenerator(basedir, files, outPackage);
    }

    @Test
    public void generate() {
        generator.generate();
    }
}
