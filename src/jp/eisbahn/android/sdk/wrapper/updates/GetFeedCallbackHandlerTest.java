package jp.eisbahn.android.sdk.wrapper.updates;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetFeedCallbackHandlerTest extends AbstractTest {

    private GetFeedCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetFeedCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"items\":[{\"link\":\"link1\",\"postedTime\":"
            + "\"2011-01-19T19:46:40+09:00\",\"object\":{\"link\":\"link2\""
            + ",\"postedTime\":\"2011-02-20T21:47:41+09:00\",\"objectType\":"
            + "\"objectType1\"},\"verb\":\"verb1\",\"id\":\"id1\",\"title\":"
            + "\"title1\",\"actor\":{\"link\":\"link3\",\"objectType\":"
            + "\"objectType2\",\"id\":\"id2\",\"image\":{\"width\":\"180\","
            + "\"url\":\"url1\",\"height\":\"135\"},\"displayName\":"
            + "\"displayName1\"}}]}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        List<Entry> entries = target.getEntries();
        assertNotNull(entries);
        assertEquals(1, entries.size());
        Entry entry = entries.get(0);
        assertEquals("link1", entry.getLink());
        Date date = Utils.createDate(2011, 1, 19, 19, 46, 40);
        assertEquals(date.getTime(), entry.getPostedTime().getTime());
        assertEquals("verb1", entry.getVerb());
        assertEquals("id1", entry.getId());
        assertEquals("title1", entry.getTitle());
        ActivityObject obj = entry.getObject();
        assertEquals("link2", obj.getLink());
        date = Utils.createDate(2011, 2, 20, 21, 47, 41);
        assertEquals(date.getTime(), obj.getPostedTime().getTime());
        assertEquals("objectType1", obj.getObjectType());
        ActivityObject actor = entry.getActor();
        assertEquals("link3", actor.getLink());
        assertEquals("objectType2", actor.getObjectType());
        assertEquals("id2", actor.getId());
        JSONObject image = actor.getExtendedInfoAsJson("image");
        assertEquals("180", image.get("width"));
        assertEquals("135", image.get("height"));
        assertEquals("url1", image.get("url"));
    }
    
}
