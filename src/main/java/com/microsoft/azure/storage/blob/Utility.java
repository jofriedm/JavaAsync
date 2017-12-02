/**
 * Copyright Microsoft Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.azure.storage.blob;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


final class Utility {

    /**
     * Thread local for storing GMT date format.
    */
    private static ThreadLocal<DateFormat>
            RFC1123_GMT_DATE_TIME_FORMATTER = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            final DateFormat formatter = new SimpleDateFormat(RFC1123_PATTERN, LOCALE_US);
            formatter.setTimeZone(GMT_ZONE);
            return formatter;
        }
    };

    /**
     * Stores a reference to the RFC1123 date/time pattern.
     */
    private static final String RFC1123_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";

    /**
     * Stores a reference to the GMT time zone.
     */
    public static final TimeZone GMT_ZONE = TimeZone.getTimeZone("GMT");

    /**
     * Stores a reference to the US locale.
     */
    public static final Locale LOCALE_US = Locale.US;

    /**
     * Returns the current GMT date/time String using the RFC1123 pattern.
     *
     * @return A {@code String} that represents the current GMT date/time using the RFC1123 pattern.
     */
    public static String getGMTTime() {
        return getGMTTime(new Date());
    }

    /**
     * Returns the GTM date/time String for the specified value using the RFC1123 pattern.
     *
     * @param date
     *            A <code>Date</code> object that represents the date to convert to GMT date/time in the RFC1123
     *            pattern.
     *
     * @return A {@code String} that represents the GMT date/time for the specified value using the RFC1123
     *         pattern.
     */
    public static String getGMTTime(final Date date) {
        return RFC1123_GMT_DATE_TIME_FORMATTER.get().format(date);
    }

    /**
     * Parses a query string into a one to many hashmap.
     *
     * @param parseString
     *            the string to parse
     * @return a HashMap<String, String[]> of the key values.
     * @throws UnsupportedEncodingException
     */
    public static TreeMap<String, String[]> parseQueryString(String parseString, boolean lowerCaseKey) throws UnsupportedEncodingException {
        //Comparator<String> c = new Comparator.<String>naturalOrder();
        final TreeMap<String, String[]> retVals = new TreeMap<String, String[]>( new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        if (Utility.isNullOrEmpty(parseString)) {
            return retVals;
        }

        // split name value pairs by splitting on the 'c&' character
        final String[] valuePairs = parseString.split("&");

        // for each field value pair parse into appropriate map entries
        for (int m = 0; m < valuePairs.length; m++) {
            // Getting key and value for a single query parameter
            final int equalDex = valuePairs[m].indexOf("=");
            String key = Utility.safeDecode(valuePairs[m].substring(0, equalDex));
            if (lowerCaseKey) {
                key = key.toLowerCase(Utility.LOCALE_US);
            }

            String value = Utility.safeDecode(valuePairs[m].substring(equalDex + 1));

            // add to map
            String[] keyValues = retVals.get(key);

            // check if map already contains key
            if (keyValues == null) {
                // map does not contain this key
                keyValues = new String[] { value };
                retVals.put(key, keyValues);
            }
            else {
                // map contains this key already so append
                final String[] newValues = new String[keyValues.length + 1];
                for (int j = 0; j < keyValues.length; j++) {
                    newValues[j] = keyValues[j];
                }

                newValues[newValues.length - 1] = value;
            }
        }

        return retVals;
    }

    /**
     * Asserts that a value is not <code>null</code>.
     *
     * @param param
     *            A {@code String} that represents the name of the parameter, which becomes the exception message
     *            text if the <code>value</code> parameter is <code>null</code>.
     * @param value
     *            An <code>Object</code> object that represents the value of the specified parameter. This is the value
     *            being asserted as not <code>null</code>.
     */
    public static void assertNotNull(final String param, final Object value) {
        if (value == null) {
            throw new IllegalArgumentException(String.format(Utility.LOCALE_US, SR.ARGUMENT_NULL_OR_EMPTY, param));
        }
    }

    /**
     * Returns a value that indicates whether the specified string is <code>null</code> or empty.
     *
     * @param value
     *            A {@code String} being examined for <code>null</code> or empty.
     *
     * @return <code>true</code> if the specified value is <code>null</code> or empty; otherwise, <code>false</code>
     */
    public static boolean isNullOrEmpty(final String value) {
        return value == null || value.length() == 0;
    }

    /**
     * Returns a value that indicates whether the specified string is <code>null</code>, empty, or whitespace.
     *
     * @param value
     *            A {@code String} being examined for <code>null</code>, empty, or whitespace.
     *
     * @return <code>true</code> if the specified value is <code>null</code>, empty, or whitespace; otherwise,
     *         <code>false</code>
     */
    public static boolean isNullOrEmptyOrWhitespace(final String value) {
        return value == null || value.trim().length() == 0;
    }

    /**
     * Performs safe decoding of the specified string, taking care to preserve each <code>+</code> character, rather
     * than replacing it with a space character.
     *
     * @param stringToDecode
     *            A {@code String} that represents the string to decode.
     *
     * @return A {@code String} that represents the decoded string.
     *
     * @throws UnsupportedEncodingException
     *             If a storage service error occurred.
     */
    public static String safeDecode(final String stringToDecode) throws UnsupportedEncodingException {
        if (stringToDecode.length() == 0) {
            return Constants.EMPTY_STRING;
        }

        // '+' are decoded as ' ' so preserve before decoding
        if (stringToDecode.contains("+")) {
            final StringBuilder outBuilder = new StringBuilder();

            int startDex = 0;
            for (int m = 0; m < stringToDecode.length(); m++) {
                if (stringToDecode.charAt(m) == '+') {
                    if (m > startDex) {
                        outBuilder.append(URLDecoder.decode(stringToDecode.substring(startDex, m),
                                Constants.UTF8_CHARSET));
                    }

                    outBuilder.append("+");
                    startDex = m + 1;
                }
            }

            if (startDex != stringToDecode.length()) {
                outBuilder.append(URLDecoder.decode(stringToDecode.substring(startDex, stringToDecode.length()),
                        Constants.UTF8_CHARSET));
            }

            return outBuilder.toString();
        }
        else {
            return URLDecoder.decode(stringToDecode, Constants.UTF8_CHARSET);
        }
    }

    /**
     * Stores a reference to the UTC time zone.
     */
    public static final TimeZone UTC_ZONE = TimeZone.getTimeZone("UTC");

    /**
     * Stores a reference to the date/time pattern with the greatest precision Java.util.Date is capable of expressing.
     */
    private static final String MAX_PRECISION_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    /**
     * Stores a reference to the ISO8601 date/time pattern.
     */
    private static final String ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /**
     * Stores a reference to the ISO8601 date/time pattern.
     */
    private static final String ISO8601_PATTERN_NO_SECONDS = "yyyy-MM-dd'T'HH:mm'Z'";

    /**
     * Stores a reference to the Java version of ISO8601_LONG date/time pattern.  The full version cannot be used
     * because Java Dates have millisecond precision.
     */
    private static final String JAVA_ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * The length of a datestring that matches the MAX_PRECISION_PATTERN.
     */
    private static final int MAX_PRECISION_DATESTRING_LENGTH = MAX_PRECISION_PATTERN.replaceAll("'", "").length();

    /**
     * Given a String representing a date in a form of the ISO8601 pattern, generates a Date representing it
     * with up to millisecond precision.
     *
     * @param dateString
     *              the {@code String} to be interpreted as a <code>Date</code>
     *
     * @return the corresponding <code>Date</code> object
     */
    public static Date parseDate(String dateString) {
        String pattern = MAX_PRECISION_PATTERN;
        switch(dateString.length()) {
            case 28: // "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'"-> [2012-01-04T23:21:59.1234567Z] length = 28
            case 27: // "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"-> [2012-01-04T23:21:59.123456Z] length = 27
            case 26: // "yyyy-MM-dd'T'HH:mm:ss.SSSSS'Z'"-> [2012-01-04T23:21:59.12345Z] length = 26
            case 25: // "yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'"-> [2012-01-04T23:21:59.1234Z] length = 25
            case 24: // "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"-> [2012-01-04T23:21:59.123Z] length = 24
                dateString = dateString.substring(0, MAX_PRECISION_DATESTRING_LENGTH);
                break;
            case 23: // "yyyy-MM-dd'T'HH:mm:ss.SS'Z'"-> [2012-01-04T23:21:59.12Z] length = 23
                // SS is assumed to be milliseconds, so a trailing 0 is necessary
                dateString = dateString.replace("Z", "0");
                break;
            case 22: // "yyyy-MM-dd'T'HH:mm:ss.S'Z'"-> [2012-01-04T23:21:59.1Z] length = 22
                // S is assumed to be milliseconds, so trailing 0's are necessary
                dateString = dateString.replace("Z", "00");
                break;
            case 20: // "yyyy-MM-dd'T'HH:mm:ss'Z'"-> [2012-01-04T23:21:59Z] length = 20
                pattern = Utility.ISO8601_PATTERN;
                break;
            case 17: // "yyyy-MM-dd'T'HH:mm'Z'"-> [2012-01-04T23:21Z] length = 17
                pattern = Utility.ISO8601_PATTERN_NO_SECONDS;
                break;
            default:
                throw new IllegalArgumentException(String.format(SR.INVALID_DATE_STRING, dateString));
        }

        final DateFormat format = new SimpleDateFormat(pattern, Utility.LOCALE_US);
        format.setTimeZone(UTC_ZONE);
        try {
            return format.parse(dateString);
        }
        catch (final ParseException e) {
            throw new IllegalArgumentException(String.format(SR.INVALID_DATE_STRING, dateString), e);
        }
    }

    /**
     * Returns the UTC date/time for the specified value using the ISO8601 pattern.
     *
     * @param value
     *            A <code>Date</code> object that represents the date to convert to UTC date/time in the ISO8601
     *            pattern. If this value is <code>null</code>, this method returns an empty string.
     *
     * @return A {@code String} that represents the UTC date/time for the specified value using the ISO8601
     *         pattern, or an empty string if <code>value</code> is <code>null</code>.
     */
    public static String getUTCTimeOrEmpty(final Date value) {
        if (value == null) {
            return Constants.EMPTY_STRING;
        }

        final DateFormat iso8601Format = new SimpleDateFormat(ISO8601_PATTERN, LOCALE_US);
        iso8601Format.setTimeZone(UTC_ZONE);

        return iso8601Format.format(value);
    }

    public static String formatLogEntry(String format, Object... args) {
        return String.format(format, args);//.replace('\n', '.');
    }
}
