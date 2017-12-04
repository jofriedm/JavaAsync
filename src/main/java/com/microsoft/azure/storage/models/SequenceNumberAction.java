/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.storage.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for SequenceNumberAction.
 */
public enum SequenceNumberAction {
    /** Enum value max. */
    MAX("max"),

    /** Enum value update. */
    UPDATE("update"),

    /** Enum value increment. */
    INCREMENT("increment");

    /** The actual serialized value for a SequenceNumberAction instance. */
    private String value;

    SequenceNumberAction(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a SequenceNumberAction instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed SequenceNumberAction object, or null if unable to parse.
     */
    @JsonCreator
    public static SequenceNumberAction fromString(String value) {
        SequenceNumberAction[] items = SequenceNumberAction.values();
        for (SequenceNumberAction item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}