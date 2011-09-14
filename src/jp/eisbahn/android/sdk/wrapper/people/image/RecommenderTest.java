package jp.eisbahn.android.sdk.wrapper.people.image;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

import org.json.JSONObject;

public class RecommenderTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"thumbnailUrl\":\"thumbnailUrl2\","
            + "\"id\":\"id2\",\"displayName\":\"displayName1\","
            + "\"profileUrl\":\"profileUrl1\",\"message\":\"message1\"}";
        JSONObject obj = new JSONObject(json);
        
        Recommender target = new Recommender(obj);
        
        assertEquals("id2", target.getId());
        assertEquals("thumbnailUrl2", target.getThumbnailUrl());
        assertEquals("displayName1", target.getDisplayName());
        assertEquals("profileUrl1", target.getProfileUrl());
        assertEquals("message1", target.getMessage());
    }

}
