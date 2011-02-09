package edu.umd.cs.guitar.ripper;

import edu.umd.cs.guitar.model.GIDGenerator;
import edu.umd.cs.guitar.model.JFCDefaultIDGenerator;

public class JFCRipperMain extends RipperMain {

    public JFCRipperMain(GRipperConfiguration config) {
        super(config);
    }

    protected GRipperMonitor createMonitor() {
        return new JFCRipperMonitor(config);
    }

    protected GIDGenerator getIdGenerator() {
        return JFCDefaultIDGenerator.getInstance();
    }

}
