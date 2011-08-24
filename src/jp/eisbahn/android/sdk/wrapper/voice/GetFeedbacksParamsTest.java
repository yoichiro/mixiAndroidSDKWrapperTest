package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetFeedbacksParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        GetFeedbacksParams target = new GetFeedbacksParams();
        target.setStartIndex(123);
        target.setCount(456);
        target.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("123", actual.get("start_index"));
        assertEquals("456", actual.get("count"));
        assertEquals("exclude_screen_name", actual.get("trim_user"));
    }
    
}
