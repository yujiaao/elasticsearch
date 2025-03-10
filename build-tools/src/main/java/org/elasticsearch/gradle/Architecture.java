/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package org.elasticsearch.gradle;

public enum Architecture {

    X64("x86_64"),
    AARCH64("aarch64"),

    LOONGARCH64("loongarch64");

    public final String classifier;

    Architecture(String classifier) {
        this.classifier = classifier;
    }

    public static Architecture current() {
        final String architecture = System.getProperty("os.arch", "");
        return switch (architecture) {
            case "amd64", "x86_64" -> X64;
            case "aarch64" -> AARCH64;
            case "loongarch64" -> LOONGARCH64;
            default -> throw new IllegalArgumentException("can not determine architecture from [" + architecture + "]");
        };
    }

}
