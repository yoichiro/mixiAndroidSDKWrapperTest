package jp.eisbahn.android.sdk.wrapper.util;

import android.test.AndroidTestCase;

public class StringUtilsTest extends AndroidTestCase {

    public void testSimple() throws Exception {
        String[] source = {"1", "a", "A"};
        String actual = StringUtils.join(source, ",");
        assertEquals("1,a,A", actual);
    }
    
}
