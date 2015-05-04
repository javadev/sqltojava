/*
 * $Id$
 *
 * Copyright 2014 Valentyn Kolesnikov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.sqltojava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * JavaGeneratorTest.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
 */
public class JavaGeneratorTest {

    private JavaGenerator generator;

    @Before
    public void setUp() throws Exception {
        String basedir = "target";
        List<String> files = Arrays.asList("src/test/resources/test.sql");
        String outPackage = "out";
        String[] aliases = new String[] {"credittype_has_externaldistributor:credittype_has_extdistributor"};
        generator = new JavaGenerator(basedir, files, outPackage, aliases);
    }

    @Test
    public void generate() throws Exception {
        final InputStream bookingInputStream = JavaGeneratorTest.class.getClassLoader().getResourceAsStream("In_person.java");
        final BufferedReader bookingReader = new BufferedReader(new InputStreamReader(bookingInputStream));
        final List<String> bookingLines = new ArrayList<String>();
        try {
            String line = bookingReader.readLine();
            while (line != null) {
                bookingLines.add(line);
                line = bookingReader.readLine();
            }
        } finally {
            bookingReader.close();
        }
        generator.generate();
        final BufferedReader resultreader = new BufferedReader(new InputStreamReader(new FileInputStream("target/out/In_person.java")));
        final List<String> resultLines = new ArrayList<String>();
        try {
            String line = resultreader.readLine();
            while (line != null) {
                resultLines.add(line);
                line = resultreader.readLine();
            }
        } finally {
            resultreader.close();
        }
        Assert.assertArrayEquals(bookingLines.toArray(), resultLines.toArray());
    }
}
