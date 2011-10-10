package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

import org.json.JSONObject;

public class LocationTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"latitude\":\"123.456\","
            + "\"longitude\":\"-456.789\","
            + "\"geohash\":\"geohash1\","
            + "\"distance\":\"987.543\"}";
        JSONObject obj = new JSONObject(json);
        
        Location target = new Location(obj);
        assertEquals((double)123.456, target.getLatitude());
        assertEquals((double)-456.789, target.getLongitude());
        assertEquals("geohash1", target.getGeohash());
        assertEquals((double)987.543, target.getDistance());
    }

}
