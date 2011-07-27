package jp.eisbahn.android.sdk.wrapper.groups;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetGroupsParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        int startIndex = 1;
        int count = 2;
        GetGroupsParams target = new GetGroupsParams();
        target.setStartIndex(startIndex);
        target.setCount(count);
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("1", actual.get("startIndex"));
        assertEquals("2", actual.get("count"));
    }
    
}
