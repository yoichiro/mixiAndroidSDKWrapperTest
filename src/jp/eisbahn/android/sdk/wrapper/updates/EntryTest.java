package jp.eisbahn.android.sdk.wrapper.updates;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;

public class EntryTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"link\":\"link1\",\"postedTime\":"
            + "\"2011-01-19T19:46:40+09:00\",\"object\":{\"link\":\"link2\""
            + ",\"postedTime\":\"2011-02-20T21:47:41+09:00\",\"objectType\":"
            + "\"objectType1\"},\"verb\":\"verb1\",\"id\":\"id1\",\"title\":"
            + "\"title1\",\"actor\":{\"link\":\"link3\",\"objectType\":"
            + "\"objectType2\",\"id\":\"id2\",\"image\":{\"width\":\"180\","
            + "\"url\":\"url1\",\"height\":\"135\"},\"displayName\":"
            + "\"displayName1\"}}";
        JSONObject original = new JSONObject(json);
        Entry target = new Entry(original);
        assertEquals("link1", target.getLink());
        Date date = Utils.createDate(2011, 1, 19, 19, 46, 40);
        assertEquals(date.getTime(), target.getPostedTime().getTime());
        assertEquals("verb1", target.getVerb());
        assertEquals("id1", target.getId());
        assertEquals("title1", target.getTitle());
        ActivityObject obj = target.getObject();
        assertEquals("link2", obj.getLink());
        date = Utils.createDate(2011, 2, 20, 21, 47, 41);
        assertEquals(date.getTime(), obj.getPostedTime().getTime());
        assertEquals("objectType1", obj.getObjectType());
        ActivityObject actor = target.getActor();
        assertEquals("link3", actor.getLink());
        assertEquals("objectType2", actor.getObjectType());
        assertEquals("id2", actor.getId());
        JSONObject image = actor.getExtendedInfoAsJson("image");
        assertEquals("180", image.get("width"));
        assertEquals("135", image.get("height"));
        assertEquals("url1", image.get("url"));
    }

}
