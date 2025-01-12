package io.debezium.connector.yugabytedb;
import io.debezium.config.EnumeratedValue;

public class HelperBeforeImageModes {

    public enum BeforeImageMode implements EnumeratedValue {

        /**
         * ALL mode, both old and new images of the item
         */
        ALL("ALL"),

        /**
         * CHANGE mode (default), only the changed columns
         */
        CHANGE("CHANGE"),

        /**
         * FULL_ROW_NEW_IMAGE mode, the entire updated row as new image
         */
        FULL_ROW_NEW_IMAGE("FULL_ROW_NEW_IMAGE"),

        /**
         * MODIFIED_COLUMNS_OLD_AND_NEW_IMAGES mode, old and new images of modified column
         */
        MODIFIED_COLUMNS_OLD_AND_NEW_IMAGES("MODIFIED_COLUMNS_OLD_AND_NEW_IMAGES");

        private final String value;

        BeforeImageMode(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }

        /**
         * Determine if the supplied values is one of the predefined options
         *
         * @param value the configuration property value ; may not be null
         * @return the matching option, or null if the match is not found
         */
        public static BeforeImageMode parse(String value) {
            if (value == null) {
                return null;
            }
            value = value.trim();
            for (BeforeImageMode option : BeforeImageMode.values()) {
                if (option.getValue().equalsIgnoreCase(value)) {
                    return option;
                }
            }
            return null;
        }

        /**
         * Determine if the supplied values is one of the predefined options
         *
         * @param value the configuration property value ; may not be null
         * @param defaultValue the default value ; may be null
         * @return the matching option or null if the match is not found and non-null default is invalid
         */
        public static BeforeImageMode parse(String value, String defaultValue) {
            BeforeImageMode mode = parse(value);
            if (mode == null && defaultValue != null) {
                mode = parse(defaultValue);
            }
            return mode;
        }

    }

    

}

