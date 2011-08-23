package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.Date;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetCommentsCallbackHandlerTest extends AbstractTest {

    private GetCommentsCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetCommentsCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "[{\"id\":\"id1\",\"created_at\":\"Thu Jun 10 01:32:13 +0900 2010\","
            + "\"text\":\"text1\",\"user\":{\"profile_image_url\":\"profileImageUrl1\""
            + ",\"url\":\"url1\",\"id\":\"id2\",\"screen_name\":\"screenName1\"}}]";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        List<Comment> comments = target.getComments();
        assertNotNull(comments);
        assertEquals(1, comments.size());
        Comment comment = comments.get(0);
        assertEquals("id1", comment.getId());
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), comment.getCreatedAt().getTime());
        assertEquals("text1", comment.getText());
        User user = comment.getUser();
        assertEquals("id2", user.getId());
        assertEquals("screenName1", user.getScreenName());
        assertEquals("profileImageUrl1", user.getProfileImageUrl());
        assertEquals("url1", user.getUrl());
    }
    
}
