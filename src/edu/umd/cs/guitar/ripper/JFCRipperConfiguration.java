package edu.umd.cs.guitar.ripper;

import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.MissingOptionException;

/**
 * Class contains the runtime configurations of JFC GUITAR Ripper
 * 
 * <p>
 * 
 * @author <a href="mailto:baonn@cs.umd.edu"> Bao Nguyen </a>
 */
public class JFCRipperConfiguration extends GRipperConfiguration {

    public JFCRipperConfiguration() {
        opts.addOption( "c", "main-class", true, "main class name for the application under test" );
        opts.addOption( "u", "urls", true, "urls for the application under test, separated by a colon (:)" );
        opts.addOption( "j", "jvm-options", true, "Java Virtual Machine options for the application under test" );
        opts.addOption( null, "event-list", true, "customized event list (usually aut-specific events)" );
    }

    public void parseArguments(String[] args) throws ParseException {
        super.parseArguments(args);
        MAIN_CLASS = cmd.getOptionValue("main-class");
        URL_LIST = cmd.getOptionValue("urls");
        JVM_OPTIONS = cmd.getOptionValue("jvm-options");
        CUSTOMIZED_EVENT_LIST = cmd.getOptionValue("event-list");

        if (MAIN_CLASS == null) {
            throw new MissingOptionException("Missing required option: main-class");
        }
    }

    public String MAIN_CLASS;
    public String URL_LIST;
    public String JVM_OPTIONS;
    public String CUSTOMIZED_EVENT_LIST;
}
