package jp.eisbahn.android.sdk.wrapper.message;

import java.util.Date;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetMessagesCallbackHandlerTest extends AbstractTest {

    private GetMessagesCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetMessagesCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSender() throws Exception {
        String json = "{\"entry\":["
            + "{\"id\":\"id1\",\"status\":\"new\",\"timeSent\":"
            + "\"2010-11-10T17:26:23+09:00\",\"title\":\"title1\",\"body\":"
            + "\"body1\",\"sender\":{\"id\":\"id2\",\"displayName\":"
            + "\"displayName1\",\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"profileUrl\":\"profileUrl1\"}},"
            + "{\"id\":\"id3\",\"status\":\"read\",\"timeSent\":"
            + "\"2011-12-11T18:27:24+09:00\",\"title\":\"title2\",\"body\":"
            + "\"body2\",\"sender\":{\"id\":\"id4\",\"displayName\":"
            + "\"displayName2\",\"thumbnailUrl\":\"thumbnailUrl2\","
            + "\"profileUrl\":\"profileUrl2\"}}"
            + "],\"totalResults\":123,\""
            + "itemsPerPage\":456,\"startIndex\":789}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.setRelatedUserType("sender");
        target.onComplete(bundle);
        
        int totalResults = target.getTotalResults();
        int itemsPerPage = target.getItemsPerPage();
        int startIndex = target.getStartIndex();
        assertEquals(123, totalResults);
        assertEquals(456, itemsPerPage);
        assertEquals(789, startIndex);
        List<Message> messages = target.getMessages();
        assertEquals(2, messages.size());
        Message message1 = messages.get(0);
        assertEquals("id1", message1.getId());
        assertEquals("title1", message1.getTitle());
        assertEquals("body1", message1.getBody());
        assertEquals(Status.unread, message1.getStatus());
        Date date = Utils.createDate(2010, 11, 10, 17, 26, 23);
        assertEquals(date.getTime(), message1.getTimeSent().getTime());
        assertEquals("id2", message1.getUser().getId());
        assertEquals("displayName1", message1.getUser().getDisplayName());
        assertEquals("thumbnailUrl1", message1.getUser().getThumbnailUrl());
        assertEquals("profileUrl1", message1.getUser().getProfileUrl());
        Message message2 = messages.get(1);
        assertEquals("id3", message2.getId());
        assertEquals("title2", message2.getTitle());
        assertEquals("body2", message2.getBody());
        assertEquals(Status.read, message2.getStatus());
        date = Utils.createDate(2011, 12, 11, 18, 27, 24);
        assertEquals(date.getTime(), message2.getTimeSent().getTime());
        assertEquals("id4", message2.getUser().getId());
        assertEquals("displayName2", message2.getUser().getDisplayName());
        assertEquals("thumbnailUrl2", message2.getUser().getThumbnailUrl());
        assertEquals("profileUrl2", message2.getUser().getProfileUrl());
    }
    
    public void testRecipient() throws Exception {
        String json = "{\"entry\":["
            + "{\"id\":\"id1\",\"status\":\"new\",\"timeSent\":"
            + "\"2010-11-10T17:26:23+09:00\",\"title\":\"title1\",\"body\":"
            + "\"body1\",\"recipient\":{\"id\":\"id2\",\"displayName\":"
            + "\"displayName1\",\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"profileUrl\":\"profileUrl1\"}},"
            + "{\"id\":\"id3\",\"status\":\"read\",\"timeSent\":"
            + "\"2011-12-11T18:27:24+09:00\",\"title\":\"title2\",\"body\":"
            + "\"body2\",\"recipient\":{\"id\":\"id4\",\"displayName\":"
            + "\"displayName2\",\"thumbnailUrl\":\"thumbnailUrl2\","
            + "\"profileUrl\":\"profileUrl2\"}}"
            + "],\"totalResults\":123,\""
            + "itemsPerPage\":456,\"startIndex\":789}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.setRelatedUserType("recipient");
        target.onComplete(bundle);
        
        int totalResults = target.getTotalResults();
        int itemsPerPage = target.getItemsPerPage();
        int startIndex = target.getStartIndex();
        assertEquals(123, totalResults);
        assertEquals(456, itemsPerPage);
        assertEquals(789, startIndex);
        List<Message> messages = target.getMessages();
        assertEquals(2, messages.size());
        Message message1 = messages.get(0);
        assertEquals("id1", message1.getId());
        assertEquals("title1", message1.getTitle());
        assertEquals("body1", message1.getBody());
        assertEquals(Status.unread, message1.getStatus());
        Date date = Utils.createDate(2010, 11, 10, 17, 26, 23);
        assertEquals(date.getTime(), message1.getTimeSent().getTime());
        assertEquals("id2", message1.getUser().getId());
        assertEquals("displayName1", message1.getUser().getDisplayName());
        assertEquals("thumbnailUrl1", message1.getUser().getThumbnailUrl());
        assertEquals("profileUrl1", message1.getUser().getProfileUrl());
        Message message2 = messages.get(1);
        assertEquals("id3", message2.getId());
        assertEquals("title2", message2.getTitle());
        assertEquals("body2", message2.getBody());
        assertEquals(Status.read, message2.getStatus());
        date = Utils.createDate(2011, 12, 11, 18, 27, 24);
        assertEquals(date.getTime(), message2.getTimeSent().getTime());
        assertEquals("id4", message2.getUser().getId());
        assertEquals("displayName2", message2.getUser().getDisplayName());
        assertEquals("thumbnailUrl2", message2.getUser().getThumbnailUrl());
        assertEquals("profileUrl2", message2.getUser().getProfileUrl());
    }

}
