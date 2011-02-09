package edu.umd.cs.guitar.ripper;

import java.lang.Class;

public class JFCPluginInfo implements PluginInfo {
    public Class configType() {
        return JFCRipperConfiguration.class;
    }

    public Class ripperType() {
        return JFCRipperMain.class;
    }
}
