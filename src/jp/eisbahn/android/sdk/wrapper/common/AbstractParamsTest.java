package jp.eisbahn.android.sdk.wrapper.common;

import java.util.HashMap;
import java.util.Map;


import android.test.AndroidTestCase;

public class AbstractParamsTest extends AndroidTestCase {

    private AbstractParams target;
    
    @Override
    protected void setUp() {
        target = new AbstractParams() {
            @Override
            public Map<String, String> convertParameterMap() {
                return null;
            }
        };
    }
    
    @Override
    public void tearDown() {
        target = null;
    }
    
    public void testPutParameter() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        target.putParameter(map, "name1", "value1");
        assertEquals("value1", map.get("name1"));
        target.putParameter(map, "name2", null);
        assertNull(map.get("name2"));
    }
    
    public void testConvertArrayToStringWithComma() throws Exception {
        String[] source1 = {"e1", "e2"};
        assertEquals("e1,e2", target.convertArrayToStringWithComma(source1));
        String[] source2 = {"e1"};
        assertEquals("e1", target.convertArrayToStringWithComma(source2));
        String[] source3 = null;
        assertNull(target.convertArrayToStringWithComma(source3));
        String[] source4 = {};
        assertEquals("", target.convertArrayToStringWithComma(source4));
    }

}
