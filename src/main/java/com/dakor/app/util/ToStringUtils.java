package com.dakor.app.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * .
 *
 * @author dkor
 */
public class ToStringUtils {

    public static ToStringBuilder getBuilder(Object obj) {
        return new ToStringBuilder(obj, new ToStringStyle() {
            private static final long serialVersionUID = -4913942922972920130L;

            {
                setUseShortClassName(true);
                setFieldSeparator("; ");
                setUseIdentityHashCode(false);
            }
        });
    }
}
