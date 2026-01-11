/*
 *
 *            ##   ##            ##
 *           ##   ##            ##
 *       ##############        ##
 *         #    #             ##
 *     ##############        ##
 *       ##   ##
 *      ##   ##            ##
 *
 * Hamburg Toolkit by HH-SI (Hamburg System Integration)
 *
 * All rights reserved
 *
 * This software is furnished under a license and may be used and
 * copied only in accordance with the terms of such license and
 * with the inclusion of the above copyright notice. This
 * software or any other copies thereof may not be provided or
 * otherwise made available to a third person. No title to and
 * ownership of the software is hereby transferred.
 *
 * The information in this software is subject to change without
 * notice and should not be construed as a commitment by ProSTEP
 * The PROSTEP AG assumes only responsibility defined in a contract
 * and no responsibility for the use or reliability of its software
 * on equipment which is not supplied by the PROSTEP AG.
 *
 */
package de.cadoculus.ocxviewer;

import java.util.Properties;

/**
 * @author THB2E3
 */
public class BuildVersion {

    private static String buildTimestamp = null;
    private static String mvnVersion;
    private static String gitBranch;
    private static String gitCommitID;
    public static final String PROPS_FILE = "mvn.properties";
    public static final String PROPS2_FILE = "git.properties";

    /**
     * Static access to the build date String. Automatically set by the build
     * script
     */
    public static String getBuiltTimestamp() {

        if ( buildTimestamp == null ) {
            loadBuild();
        }

        if ( ( buildTimestamp == null ) || ( buildTimestamp.trim().length() < 10 ) ) {
            return "";
        }

        return buildTimestamp.substring( 0, 10 );
    }

    /**
     * Static access to the build version String. Automatically set by the build
     * script
     */
    public static String getMvnVersion() {

        if ( buildTimestamp == null ) {
            loadBuild();
        }

        return mvnVersion;
    }
    public static String getGitBranch() {

        if ( gitBranch == null ) {
            loadBuild();
        }

        return gitBranch;
    }
    public static String getGitCommitID() {

        if ( gitCommitID == null ) {
            loadBuild();
        }

        return gitCommitID;
    }

    /**
     * Load the values contained in the build.properties and git. properties file from the JAR file.
     * This is used to get
     * properties like build date or version
     */
    private static void loadBuild() {

        try {
            Properties props = new Properties();
            props.load( BuildVersion.class.getResourceAsStream( PROPS_FILE ) );

            buildTimestamp = props.getProperty( "timestamp" );
            mvnVersion = props.getProperty( "project.version" );

        } catch ( Exception exp ) {
            System.err.println( "failed to load build.properties" );
            System.err.println( "reason " + exp);
            buildTimestamp = "UNKNOWN";
            mvnVersion = "UNKNOWN";
        }
        try{
            Properties props = new Properties();
            props.load( BuildVersion.class.getResourceAsStream( PROPS2_FILE ) );
            gitBranch = props.getProperty( "git.branch" );
            gitCommitID = props.getProperty( "git.commit.id" );
            
        }
        catch(Exception exp){
            System.err.println( "failed to load git.properties" );
            System.err.println( "reason " + exp);
            gitBranch = "UNKNOWN";
            gitCommitID = "UNKNOWN";
        }

    }
}
