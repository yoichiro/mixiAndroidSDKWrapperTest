package jp.eisbahn.android.sdk.wrapper.people.image;

import java.util.Date;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;

import org.json.JSONObject;

public class ProfileImageTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"privacy\":\"friends\""
            + ",\"thumbnailUrl\":\"thumbnailUrl1\",\"primary\":true,"
            + "\"created\":\"2010-06-10T01:32:13+09:00\","
            + "\"recommender\":{\"thumbnailUrl\":\"thumbnailUrl2\","
            + "\"id\":\"id2\",\"displayName\":\"displayName1\","
            + "\"profileUrl\":\"profileUrl1\",\"message\":\"message1\"}}";
        JSONObject obj = new JSONObject(json);
        
        ProfileImage target = new ProfileImage(obj);
        
        assertEquals("id1", target.getId());
        assertEquals(Privacy.friends, target.getPrivacy());
        assertEquals("thumbnailUrl1", target.getThumbnailUrl());
        assertEquals(true, target.isPrimary());
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), target.getCreated().getTime());
        Recommender recommender = target.getRecommender();
        assertEquals("id2", recommender.getId());
        assertEquals("thumbnailUrl2", recommender.getThumbnailUrl());
        assertEquals("displayName1", recommender.getDisplayName());
        assertEquals("profileUrl1", recommender.getProfileUrl());
        assertEquals("message1", recommender.getMessage());
    }

}
