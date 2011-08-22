package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;

public class CommentTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"created_at\":\"Thu Jun 10 01:32:13 +0900 2010\","
                    + "\"text\":\"text1\",\"user\":{\"id\":\"id2\",\"screen_name\":"
                    + "\"screenName1\",\"profile_image_url\":\"profileImageUrl1\","
                    + "\"url\":\"url1\"}}";
        JSONObject original = new JSONObject(json);
        Comment target = new Comment(original);
        assertEquals("id1", target.getId());
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), target.getCreatedAt().getTime());
        assertEquals("text1", target.getText());
        User user = target.getUser();
        assertNotNull(user);
        assertEquals("id2", user.getId());
        assertEquals("screenName1", user.getScreenName());
        assertEquals("profileImageUrl1", user.getProfileImageUrl());
        assertEquals("url1", user.getUrl());
    }
    
}
