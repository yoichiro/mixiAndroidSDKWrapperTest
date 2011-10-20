package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class SearchSpotsParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        SearchSpotsParams target = new SearchSpotsParams();
        target.setCount(2);
        target.setFields(new SpotField[] {
                SpotField.id,
                SpotField.address_formatted,
                SpotField.owner_profileUrl
        });
        target.setCenter(123, 456);
        target.setKeyword("keyword1");
        target.setSinceId("sinceId1");
        target.setResultsDirection(ResultsDirection.recent);
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("2", actual.get("count"));
        assertEquals("id,address.formatted,owner.profileUrl", actual.get("fields"));
        assertEquals("123.0,456.0", actual.get("center"));
        assertEquals("keyword1", actual.get("q"));
        assertEquals("sinceId1", actual.get("sinceId"));
        assertEquals("recent", actual.get("resultsDirection"));
    }
    
}
