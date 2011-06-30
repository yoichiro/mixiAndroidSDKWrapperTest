package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.Privacy;
import jp.eisbahn.android.sdk.wrapper.Visibility;

import org.json.JSONObject;

public class PrivacyTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"visibility\":\"everyone\"}";
        JSONObject original = new JSONObject(json);
        Privacy target = new Privacy(original);
        assertEquals(Visibility.everyone, target.getVisibility());
    }

}
