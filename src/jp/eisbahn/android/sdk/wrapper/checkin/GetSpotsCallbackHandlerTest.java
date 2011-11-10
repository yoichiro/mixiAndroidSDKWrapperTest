package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.common.User;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetSpotsCallbackHandlerTest extends AbstractTest {

    private GetSpotsCallbackHandler handler;
    
    @Override
    protected void setUp() {
        handler = new GetSpotsCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        handler = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"entry\":[{\"id\":\"id1\",\"name\":{"
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
            + "}}],\"totalResults\":123,\""
            + "itemsPerPage\":456,\"startIndex\":789}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        handler.onComplete(bundle);
        
        int totalResults = handler.getTotalResults();
        int itemsPerPage = handler.getItemsPerPage();
        int startIndex = handler.getStartIndex();
        assertEquals(123, totalResults);
        assertEquals(456, itemsPerPage);
        assertEquals(789, startIndex);
        List<Spot> spots = handler.getSpots();
        assertEquals(1, spots.size());
        Spot target = spots.get(0);
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
