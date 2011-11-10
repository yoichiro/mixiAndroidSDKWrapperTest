package jp.eisbahn.android.sdk.wrapper.common;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

import org.json.JSONObject;

public class PrivacyTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"visibility\":\"everyone\"}";
        JSONObject original = new JSONObject(json);
        Privacy target = new Privacy(original);
        assertEquals(Visibility.everyone, target.getVisibility());
    }

}
