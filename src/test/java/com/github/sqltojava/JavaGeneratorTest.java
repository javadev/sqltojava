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
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * JavaGeneratorTest.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
    JavaGenerator.class,
    BufferedReader.class,
    FileInputStream.class
})
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
    public void generate() throws Exception {
        final InputStream inputStream = JavaGeneratorTest.class.getClassLoader().getResourceAsStream("test.sql");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        final List<String> lines = new ArrayList<String>();
        try {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }
        final InputStream bookingInputStream = JavaGeneratorTest.class.getClassLoader().getResourceAsStream("Booking.java");
        final BufferedReader bookingReader = new BufferedReader(new InputStreamReader(bookingInputStream));
        final List<String> bookingLines = new ArrayList<String>();
        try {
            String line = bookingReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bookingReader.readLine();
            }
        } finally {
            bookingReader.close();
        }
        final BufferedReader bufferedReader = PowerMockito.mock(BufferedReader.class);
        final FileInputStream fileInputStream = PowerMockito.mock(FileInputStream.class);
        PowerMockito.whenNew(BufferedReader.class).withArguments(Matchers.anyObject())
                .thenReturn(bufferedReader);
        PowerMockito.whenNew(FileInputStream.class).withArguments(Matchers.anyString())
                .thenReturn(fileInputStream);
        final Integer[] count = new Integer[]{0};
        PowerMockito.when(bufferedReader.readLine()).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (lines.size() == count[0]) {
                    return null;
                }
                String line = lines.get(count[0]);
                count[0] = count[0] + 1;
                return line;
            }
        });
        generator.generate();
        final BufferedReader resultreader = new BufferedReader(new InputStreamReader(new FileInputStream("out/Booking.java")));
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
