package jp.eisbahn.android.sdk.wrapper.common;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

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
