package jp.eisbahn.android.sdk.wrapper.message;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.common.User;

public class MessageTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"status\":\"new\",\"timeSent\":"
            + "\"2010-11-10T17:26:23+09:00\",\"title\":\"title1\",\"body\":"
            + "\"body1\",\"sender\":{\"id\":\"id2\",\"displayName\":"
            + "\"displayName1\",\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"profileUrl\":\"profileUrl1\"}}";
        JSONObject original = new JSONObject(json);
        Message target = new Message(original, "sender");
        assertEquals("id1", target.getId());
        assertEquals(Status.unread, target.getStatus());
        Date date = Utils.createDate(2010, 11, 10, 17, 26, 23);
        assertEquals(date.getTime(), target.getTimeSent().getTime());
        assertEquals("title1", target.getTitle());
        assertEquals("body1", target.getBody());
        User user = target.getUser();
        assertEquals("id2", user.getId());
        assertEquals("displayName1", user.getDisplayName());
        assertEquals("thumbnailUrl1", user.getThumbnailUrl());
        assertEquals("profileUrl1", user.getProfileUrl());
    }

}
