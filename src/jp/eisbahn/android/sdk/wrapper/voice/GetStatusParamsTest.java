package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetStatusParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        GetStatusParams target = new GetStatusParams();
        target.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        target.setAttachPhoto(true);
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("exclude_screen_name", actual.get("trim_user"));
        assertEquals("true", actual.get("attach_photo"));
    }
    
}
