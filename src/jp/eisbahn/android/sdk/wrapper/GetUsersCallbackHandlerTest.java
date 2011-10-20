package jp.eisbahn.android.sdk.wrapper;

import java.util.List;

import jp.eisbahn.android.sdk.wrapper.User;
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
        String json = "{\"entry\":[{\"id\":"
            + "\"id1\",\"displayName\":\"displayName1\",\"thumbnailUrl\""
            + ":\"thumbnailUrl1\",\"profileUrl\":\"profileUrl1\"}],"
            + "\"startIndex\":1,\"totalResults\":2,\"itemsPerPage\":3}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        int totalResults = target.getTotalResults();
        int itemsPerPage = target.getItemsPerPage();
        int startIndex = target.getStartIndex();
        assertEquals(2, totalResults);
        assertEquals(3, itemsPerPage);
        assertEquals(1, startIndex);
        List<User> users = target.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("id1", user.getId());
        assertEquals("displayName1", user.getDisplayName());
        assertEquals("thumbnailUrl1", user.getThumbnailUrl());
        assertEquals("profileUrl1", user.getProfileUrl());
    }
    
}
