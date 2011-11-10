package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.common.User;

import org.json.JSONObject;

public class SpotTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"name\":{"
            + "\"formatted\":\"formatted1\"},"
            + "\"address\":{"
            + "\"formatted\":\"formatted2\","
            + "\"latitude\":\"123.456\","
            + "\"longitude\":\"-456.789\","
            + "\"geohash\":\"geohash1\","
            + "\"distance\":\"987.543\"},"
            + "\"categories\":[{\"formatted\":\"formatted3\"}],"
            + "\"description\":\"description1\","
            + "\"owner\":{"
            + "\"id\":\"id2\","
            + "\"displayName\":\"displayName1\","
            + "\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"profileUrl\":\"profileUrl1\""
            + "}}";
        JSONObject obj = new JSONObject(json);
        
        Spot target = new Spot(obj);
        assertEquals("id1", target.getId());
        Name name = target.getName();
        assertEquals("formatted1", name.getFormatted());
        Address address = target.getAddress();
        assertEquals("formatted2", address.getFormatted());
        assertEquals((double)123.456, address.getLatitude());
        assertEquals((double)-456.789, address.getLongitude());
        assertEquals("geohash1", address.getGeohash());
        assertEquals((double)987.543, address.getDistance());
        Category[] categories = target.getCategories();
        assertEquals(1, categories.length);
        Category category = categories[0];
        assertEquals("formatted3", category.getFormatted());
        assertEquals("description1", target.getDescription());
        User user = target.getOwner();
        assertEquals("id2", user.getId());
        assertEquals("displayName1", user.getDisplayName());
        assertEquals("thumbnailUrl1", user.getThumbnailUrl());
        assertEquals("profileUrl1", user.getProfileUrl());
    }

}
