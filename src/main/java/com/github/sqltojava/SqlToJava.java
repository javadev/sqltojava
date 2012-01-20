/*
 * $Id$
 *
 * Copyright (c) 2011, 2012 (javadev75@gmail.com)
 */
package com.github.sqltojava;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates Java files from SQL schema.
 *
 * @goal generate
 * @phase generate-sources
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
    public static void main(String[] args) {
        if (args.length < 3) {
            Logger.getLogger(SqlToJava.class.getName()).log(Level.INFO,
                    "SQL to java convertor. Copyright (c) 2012 (javadev75@gmail.com)\n"
                    + "Usage: SqlToJava source.sql basedir outpackage");
            return;
        }
        String sqlFiles = args[0].trim();
        String basedir = args[1].trim();
        String outPackage = args[2].trim();
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
        new JavaGenerator(basedir, fileLocations, outPackage).generate();

        Logger.getLogger(SqlToJava.class.getName()).log(Level.INFO, outPackage + " generated.");
    }
}
