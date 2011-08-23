package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetUsersCallbackHandlerTest extends AbstractTest {

    private GetUsersCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetUsersCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "[{\"profile_image_url\":\"profileImageUrl1\",\"url\":\"url1\","
            + "\"id\":\"id1\",\"screen_name\":\"screenName1\"}]";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        List<User> users = target.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("id1", user.getId());
        assertEquals("screenName1", user.getScreenName());
        assertEquals("profileImageUrl1", user.getProfileImageUrl());
        assertEquals("url1", user.getUrl());
    }
    
}
