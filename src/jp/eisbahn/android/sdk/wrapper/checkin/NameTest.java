package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

import org.json.JSONObject;

public class NameTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"formatted\":\"formatted1\"}";
        JSONObject obj = new JSONObject(json);
        
        Name target = new Name(obj);
        assertEquals("formatted1", target.getFormatted());
    }

}
