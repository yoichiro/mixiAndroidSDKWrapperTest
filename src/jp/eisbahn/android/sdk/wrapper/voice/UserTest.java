package jp.eisbahn.android.sdk.wrapper.voice;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class UserTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"id\":\"id2\",\"screen_name\":"
            + "\"screenName1\",\"profile_image_url\":\"profileImageUrl1\","
            + "\"url\":\"url1\"}";
        JSONObject original = new JSONObject(json);
        User target = new User(original);
        assertEquals("id2", target.getId());
        assertEquals("screenName1", target.getScreenName());
        assertEquals("profileImageUrl1", target.getProfileImageUrl());
        assertEquals("url1", target.getUrl());
    }

}
