package jp.eisbahn.android.sdk.wrapper.util;

import java.util.Date;

import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

import android.test.AndroidTestCase;

public class DateUtilsTest extends AndroidTestCase {

    public void testConvertDate1() throws Exception {
        String original = "2010-06-10T01:32:13+0900";
        long expected = Utils.createDate(2010, 6, 10, 1, 32, 13).getTime();
        Date actual = DateUtils.convertDate(original);
        assertEquals(expected, actual.getTime());
    }

    public void testConvertDate2() throws Exception {
        String original = "2010-06-10T01:32:13+09:00";
        long expected = Utils.createDate(2010, 6, 10, 1, 32, 13).getTime();
        Date actual = DateUtils.convertDate(original);
        assertEquals(expected, actual.getTime());
    }

    public void testConvertDate3() throws Exception {
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        String actual = DateUtils.convertDate(date);
        assertEquals("2010-06-10T01:32:13Z", actual);
    }
    
}
