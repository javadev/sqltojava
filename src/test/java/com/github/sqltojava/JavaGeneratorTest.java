/*
 * $Id$
 *
 * Copyright 2013 Valentyn Kolesnikov
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

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * JavaGeneratorTest.
 *
 * @author vko
 * @version $Revision$ $Date$
 */
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
