package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;

public class StatusTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"created_at\":\"Thu Jun 10 01:32:13 +0900 2010\","
                    + "\"text\":\"text1\",\"user\":{\"id\":\"id2\",\"screen_name\":"
                    + "\"screenName1\",\"profile_image_url\":\"profileImageUrl1\","
                    + "\"url\":\"url1\"},\"reply_count\":\"3\",\"favorite_count\":\"5\","
                    + "\"photo\":[{\"thumbnail_url\":\"thumbnailUrl1\",\"image_url\":"
                    + "\"imageUrl1\"}]}";
        JSONObject original = new JSONObject(json);
        Status target = new Status(original);
        assertEquals("id1", target.getId());
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), target.getCreatedAt().getTime());
        assertEquals("text1", target.getText());
        assertEquals(3, target.getReplyCount());
        assertEquals(5, target.getFavoriteCount());
        User user = target.getUser();
        assertNotNull(user);
        assertEquals("id2", user.getId());
        assertEquals("screenName1", user.getScreenName());
        assertEquals("profileImageUrl1", user.getProfileImageUrl());
        assertEquals("url1", user.getUrl());
        Photo[] photos = target.getPhotos();
        assertNotNull(photos);
        assertEquals(1, photos.length);
        assertEquals("thumbnailUrl1", photos[0].getThumbnailUrl());
        assertEquals("imageUrl1", photos[0].getImageUrl());
    }
    
}
