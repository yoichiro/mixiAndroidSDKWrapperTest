package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetSpotsParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        GetSpotsParams target = new GetSpotsParams();
        target.setStartIndex(3);
        target.setCount(2);
        target.setFields(new SpotField[] {
                SpotField.id,
                SpotField.address_formatted,
                SpotField.owner_profileUrl
        });
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("3", actual.get("startIndex"));
        assertEquals("2", actual.get("count"));
        assertEquals("id,address.formatted,owner.profileUrl", actual.get("fields"));
    }
    
}
