package jp.eisbahn.android.sdk.wrapper.checkin;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

import org.json.JSONObject;

public class CategoryTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"formatted\":\"formatted1\"}";
        JSONObject obj = new JSONObject(json);
        
        Category target = new Category(obj);
        assertEquals("formatted1", target.getFormatted());
    }

}
