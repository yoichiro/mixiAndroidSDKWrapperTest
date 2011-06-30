package jp.eisbahn.android.sdk.wrapper.photo;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.User;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.photo.Comment;

public class CommentTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"created\":"
            + "\"2010-06-10T01:32:13+09:00\",\"text\":\"text1\""
            + ",\"user\":{\"id\":\"id2\",\"displayName\":"
            + "\"displayName1\",\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"profileUrl\":\"profileUrl1\"}}";
        JSONObject original = new JSONObject(json);
        Comment target = new Comment(original);
        assertEquals("id1", target.getId());
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), target.getCreatedAt().getTime());
        assertEquals("text1", target.getText());
        User user = target.getUser();
        assertEquals("id2", user.getId());
        assertEquals("displayName1", user.getDisplayName());
        assertEquals("thumbnailUrl1", user.getThumbnailUrl());
        assertEquals("profileUrl1", user.getProfileUrl());
    }

}
