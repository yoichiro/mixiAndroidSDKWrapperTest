package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetCheckinsParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        GetCheckinsParams target = new GetCheckinsParams();
        target.setCount(2);
        target.setFields(new CheckinField[] {
                CheckinField.id,
                CheckinField.comments_created,
                CheckinField.photo_numComments
        });
        target.setCenter(123, 456);
        target.setSinceId("sinceId1");
        target.setResultsDirection(ResultsDirection.recent);
        target.setSpotId("spotId1");
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("2", actual.get("count"));
        assertEquals("id,comments.created,photo.numComments", actual.get("fields"));
        assertEquals("123.0,456.0", actual.get("center"));
        assertEquals("spotId1", actual.get("spotId"));
        assertEquals("sinceId1", actual.get("sinceId"));
        assertEquals("recent", actual.get("resultsDirection"));
    }
    
}
