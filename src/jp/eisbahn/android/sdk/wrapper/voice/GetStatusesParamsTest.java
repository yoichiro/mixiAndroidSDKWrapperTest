package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetStatusesParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        GetStatusesParams target = new GetStatusesParams();
        target.setStartIndex(123);
        target.setCount(456);
        target.setSinceId("sinceId1");
        target.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        target.setAttachPhoto(true);
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("123", actual.get("start_index"));
        assertEquals("456", actual.get("count"));
        assertEquals("sinceId1", actual.get("since_id"));
        assertEquals("exclude_screen_name", actual.get("trim_user"));
        assertEquals("true", actual.get("attach_photo"));
    }
    
}
