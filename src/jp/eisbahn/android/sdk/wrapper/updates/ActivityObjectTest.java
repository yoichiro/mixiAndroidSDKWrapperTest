package jp.eisbahn.android.sdk.wrapper.updates;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;

public class ActivityObjectTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"link\":\"link2\""
            + ",\"postedTime\":\"2011-02-20T21:47:41+09:00\",\"objectType\":"
            + "\"objectType1\",\"additional\":\"additional1\","
            + "\"json\":{\"foo\":\"bar\"},\"id\":\"id1\"}";
        JSONObject original = new JSONObject(json);
        ActivityObject target = new ActivityObject(original);
        assertEquals("link2", target.getLink());
        Date date = Utils.createDate(2011, 2, 20, 21, 47, 41);
        assertEquals(date.getTime(), target.getPostedTime().getTime());
        assertEquals("objectType1", target.getObjectType());
        assertEquals("additional1", target.getExtendedInfoAsString("additional"));
        JSONObject jsonObj = target.getExtendedInfoAsJson("json");
        assertEquals("bar", jsonObj.get("foo"));
        assertEquals("id1", target.getId());
    }

}
