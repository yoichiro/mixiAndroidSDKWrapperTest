package jp.eisbahn.android.sdk.wrapper.updates;

import java.util.Date;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

public class GetFeedParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        int count = 2;
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        Device device = Device.mobile;
        GetFeedParams target = new GetFeedParams();
        target.setCount(count);
        target.setUpdatedSince(updatedSince);
        target.setFields(new Field[] {
                Field.voice,
                Field.calendar
        });
        target.setUpdatedSince(updatedSince);
        target.setDevice(device);
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("2", actual.get("count"));
        assertEquals(
                "voice,calendar",
                actual.get("fields"));
        assertEquals(DateUtils.convertDate(updatedSince), actual.get("updatedSince"));
        assertEquals("mobile", actual.get("device"));
    }
    
}
