/*
 * $Id$
 *
 * Copyright 2015 Valentyn Kolesnikov
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates Java files from SQL schema.
 *
 * @author vko
 * @version $Revision$ $Date$
 */
public class SqlToJava {

    /**
     * @parameter expression="${sqlFiles}"
     */
    private String sqlFiles;

    /**
     * @parameter expression="${outPackage}"
     */
    private String outPackage;

    /**
     * @parameter expression="${aliases}"
     */
    private String aliases;

    /**
     * @parameter expression="${basedir}"
     */
    private String basedir;

    /**
     * Main method.
     * @param args source.sql outpackage
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            Logger.getLogger(SqlToJava.class.getName()).log(Level.INFO,
                    "SQL to java convertor.\n"
                    + "Usage: SqlToJava source.sql basedir outpackage aliases");
            return;
        }
        String sqlFiles = args[0].trim();
        String basedir = args[1].trim();
        String outPackage = args[2].trim();
        final String[] aliases;
        if (args.length >= 4) {
            aliases = args[3].trim().split(",");
        } else {
            aliases = new String[] {};
        }
        Logger.getLogger(SqlToJava.class.getName()).log(Level.INFO, "sql files: " + sqlFiles);
        Logger.getLogger(SqlToJava.class.getName()).log(Level.INFO, "basedir: " + basedir);
        Logger.getLogger(SqlToJava.class.getName()).log(Level.INFO, "outPackage: " + outPackage);
        if (sqlFiles.isEmpty()) {
            throw new IllegalArgumentException("sqlFiles is empty");
        }
        if (basedir.isEmpty()) {
            throw new IllegalArgumentException("basedir is empty");
        }
        if (outPackage.isEmpty()) {
            throw new IllegalArgumentException("outPackage is empty");
        }
        String[] cmdArgs = sqlFiles.split(",");
        List<String> fileLocations = new ArrayList<String>();
        for (String file : cmdArgs) {
            fileLocations.add(file.trim());
        }
        new JavaGenerator(basedir, fileLocations, outPackage, aliases).generate();

        Logger.getLogger(SqlToJava.class.getName()).log(Level.INFO, outPackage + " generated.");
    }
}
