package jp.eisbahn.android.sdk.wrapper.check;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Visibility;

import org.json.JSONObject;

public class PostCheckParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        PostCheckParams target = new PostCheckParams();
        target.setVisibility(Visibility.group);
        target.setGroup("group1");
        target.setDescription("description1");
        target.setComment("comment1");
        target.setContentRating("1");
        target.setImage("image1");
        target.setPcUrl("pcUrl1");
        target.setSmartPhoneUrl("smartPhoneUrl1");
        target.setMobileUrl("mobileUrl1");
        target.setMobileDocomoUrl("mobileDocomoUrl1");
        target.setMobileAuUrl("mobileAuUrl1");
        target.setMobileSoftbankUrl("mobileSoftbankUrl1");
        JSONObject actual = target.appendParams(new JSONObject());
        JSONObject privacy = actual.getJSONObject("privacy");
        assertEquals(Visibility.group.toString(), privacy.get("visibility"));
        assertEquals("group1", privacy.get("group"));
        assertEquals("description1", actual.get("description"));
        assertEquals("comment1", actual.get("comment"));
        assertEquals("1", actual.get("content_rating"));
        assertEquals("image1", actual.get("image"));
        assertEquals("pcUrl1", actual.get("pc_url"));
        assertEquals("smartPhoneUrl1", actual.get("smartphone_url"));
        assertEquals("mobileUrl1", actual.get("mobile_url"));
        assertEquals("mobileDocomoUrl1", actual.get("mobile_docomo_url"));
        assertEquals("mobileAuUrl1", actual.get("mobile_au_url"));
        assertEquals("mobileSoftbankUrl1", actual.get("mobile_softbank_url"));
    }
    
}
