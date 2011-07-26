package jp.eisbahn.android.sdk.wrapper.groups;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

import org.json.JSONObject;

public class GroupTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"title\":\"title1\"}";
        JSONObject obj = new JSONObject(json);
        
        Group target = new Group(obj);
        
        assertEquals("id1", target.getId());
        assertEquals("title1", target.getTitle());
    }

}
