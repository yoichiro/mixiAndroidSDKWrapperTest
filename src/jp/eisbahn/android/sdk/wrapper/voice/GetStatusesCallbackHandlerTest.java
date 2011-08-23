package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Date;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetStatusesCallbackHandlerTest extends AbstractTest {

    private GetStatusesCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetStatusesCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "[{\"id\":\"id1\",\"created_at\":\"Thu Jun 10 01:32:13 +0900 2010\","
            + "\"text\":\"text1\",\"user\":{\"profile_image_url\":\"profileImageUrl1\""
            + ",\"url\":\"url1\",\"id\":\"id2\",\"screen_name\":\"screenName1\"},"
            + "\"reply_count\":\"3\", \"favorite_count\":\"5\"}]";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        List<Status> statuses = target.getStatuses();
        assertNotNull(statuses);
        assertEquals(1, statuses.size());
        Status status = statuses.get(0);
        assertEquals("id1", status.getId());
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), status.getCreatedAt().getTime());
        assertEquals("text1", status.getText());
        assertEquals(3, status.getReplyCount());
        assertEquals(5, status.getFavoriteCount());
        User user = status.getUser();
        assertEquals("id2", user.getId());
        assertEquals("screenName1", user.getScreenName());
        assertEquals("profileImageUrl1", user.getProfileImageUrl());
        assertEquals("url1", user.getUrl());
    }
    
}
