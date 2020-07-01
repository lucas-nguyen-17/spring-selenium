package com.giangtester.localhost.framework.domain;

public enum Countries {
    Australia,
    China,
    India,
    United_Kingdom,
    United_States;

    @Override
    public String toString() {
        return this.name().replace('_', ' ');
    }

    public static Countries fromString(String string) {
        return valueOf(string.replace(' ', '_'));
    }

}
