/*
Copyright 2025 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer;

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;

/**
 * The main entry point for the OCX Viewer application.
 * It handles command-line arguments, logging configuration, and starts the application.
 * @author Carsten Zerbst
 */
public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        // This is the loading time. We need to optimize this with Java 25
        // by reusing the information from previous runs.
        /*
        var currentTimeMillis = System.currentTimeMillis();
        var processStartTime = ProcessHandle.current().info().startInstant().get();
        System.out.println("start delay " + (currentTimeMillis - processStartTime.toEpochMilli()) + " [ms]");
         */
        printIntro();

        System.setProperty("log4j.debug", "false");
        Options options = new Options();
        options.addOption(new Option("h", "help", false, "display help"));
        options.addOption(Option.builder("log").longOpt("log").hasArg().desc("url for log4j2.xml file").build());

        // create the parser
        CommandLine line = null;

        try {
            CommandLineParser cparser = new DefaultParser();

            // parse the command line arguments
            line = cparser.parse(options, args);
        } catch (org.apache.commons.cli.ParseException exp) {

            LOG.error("failed to handle options: {} ", exp.getMessage());
            LOG.error("    given options {} ",Arrays.toString(args));

            // oops, something went wrong
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Main", options);

            System.exit(66);
        }

        if (line.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Main", options);
            System.exit(0);
        }

        if (line.hasOption("log")) {

            File f = new File(line.getOptionValue("log"));
            LoggerHelper.initLogging(f);
        }

        try {
            OCXViewerApplication.main(args);
        } catch (Exception exp) {
            LOG.error("an error occurred when running the OCXViewer", exp);
            System.exit(99);
        }
        System.exit(0);
    }

    private static void printIntro() {

        var logo= """
                  ___   _____  __ __   ___                   \s
                 / _ \\ / __\\ \\/ / \\ \\ / (_)_____ __ _____ _ _\s
                | (_) | (__ >  <   \\ V /| / -_) V  V / -_) '_|
                 \\___/ \\___/_/\\_\\   \\_/ |_\\___|\\_/\\_/\\___|_| """;

        System.out.println(logo);
        System.out.println("                       Version " + BuildVersion.getMvnVersion() );
        System.out.println("\nbuild " + BuildVersion.getBuiltTimestamp()  + " from GIT commit " + BuildVersion.getGitCommitID()+ ", branch " + BuildVersion.getGitBranch() );

        // Todo: enhance when other contribute
        var apache = """
                
                Copyright 2025 Carsten Zerbst et. al. 
                
                Licensed under the Apache License, Version 2.0 (the "License");
                you may not use this file except in compliance with the License.
                You may obtain a copy of the License at
                
                    http://www.apache.org/licenses/LICENSE-2.0
                
                Unless required by applicable law or agreed to in writing, software
                distributed under the License is distributed on an "AS IS" BASIS,
                WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                See the License for the specific language governing permissions and
                limitations under the License.
                
                """;
        System.out.println(apache);



    }


//    static Configuration loadProperties(File tmplFileIn) {
//
//        if (!(tmplFileIn.isFile() && tmplFileIn.canRead())) {
//            LOG.error("got invalid configuration file, check path '{}'", tmplFileIn.getAbsolutePath());
//            throw new IllegalArgumentException("got invalid configuration file");
//        }
//
//
//        Configuration config = new PropertiesConfiguration();
//        Parameters params = new Parameters();
//
//        FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
//                PropertiesConfiguration.class).configure(params.properties().setFileName(tmplFileIn.getAbsolutePath()));
//        try {
//            return builder.getConfiguration();
//        } catch (Exception cex) {
//            throw new IllegalStateException(
//                    String.format("failed to load configuration from '%s'", tmplFileIn.getAbsolutePath()), cex);
//        }
//    }


}
