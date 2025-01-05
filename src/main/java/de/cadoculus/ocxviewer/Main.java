package de.cadoculus.ocxviewer;

import de.cadoculus.ocxviewer.logging.LoggerHelper;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

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
