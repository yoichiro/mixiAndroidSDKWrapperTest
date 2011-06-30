package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.User;

import org.json.JSONObject;

public class UserTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"displayName\":\"displayName1\","
            + "\"thumbnailUrl\":\"thumbnailUrl1\",\"profileUrl\":"
            + "\"profileUrl1\"}";
        JSONObject original = new JSONObject(json);
        User target = new User(original);
        assertEquals("id1", target.getId());
        assertEquals("displayName1", target.getDisplayName());
        assertEquals("thumbnailUrl1", target.getThumbnailUrl());
        assertEquals("profileUrl1", target.getProfileUrl());
    }

}
