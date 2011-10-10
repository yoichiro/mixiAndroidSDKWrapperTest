package jp.eisbahn.android.sdk.wrapper.photo;

import java.util.Date;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Comment;
import jp.eisbahn.android.sdk.wrapper.User;
import jp.eisbahn.android.sdk.wrapper.Utils;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetCommentsCallbackHandlerTest extends AbstractTest {
    
    private GetCommentsCallbackHandler target;

    protected void setUp() throws Exception {
        target = new GetCommentsCallbackHandler(new MockContext());
    }

    protected void tearDown() throws Exception {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"entry\":[{\"id\":"
            + "\"id1\",\"created\":\"2010-12-08T11:07:38+09:00\","
            + "\"text\":\"text1\",\"user\":{\"id\":\"id2\",\"displayName\""
            + ":\"displayName1\",\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"profileUrl\":\"profileUrl1\"}}],\"startIndex\":1,"
            + "\"totalResults\":2,\"itemsPerPage\":3}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        int totalResults = target.getTotalResults();
        int itemsPerPage = target.getItemsPerPage();
        int startIndex = target.getStartIndex();
        assertEquals(2, totalResults);
        assertEquals(3, itemsPerPage);
        assertEquals(1, startIndex);
        List<Comment> comments = target.getComments();
        assertNotNull(comments);
        assertEquals(1, comments.size());
        Comment comment = comments.get(0);
        assertEquals("id1", comment.getId());
        Date date = Utils.createDate(2010, 12, 8, 11, 7, 38);
        assertEquals(date.getTime(), comment.getCreatedAt().getTime());
        assertEquals("text1", comment.getText());
        User user = comment.getUser();
        assertEquals("id2", user.getId());
        assertEquals("displayName1", user.getDisplayName());
        assertEquals("thumbnailUrl1", user.getThumbnailUrl());
        assertEquals("profileUrl1", user.getProfileUrl());
    }

}
