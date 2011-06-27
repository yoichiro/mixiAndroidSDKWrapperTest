package jp.mixi.android.sdk.wrapper.request;

import java.util.Map;

import jp.mixi.android.sdk.wrapper.AbstractTest;

public class SendRequestParamsTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        SendRequestParams target = createTarget("body1", new String[]{"recipients1"}, "url1", "mobileUrl1", "image1");
        
        assertEquals("body1", target.getMessage());
        assertArrayEquals(new String[]{"recipients1"}, target.getRecipients());
        assertEquals("url1", target.getUrl());
        assertEquals("mobileUrl1", target.getMobileUrl());
        assertEquals("image1", target.getImage());
        
        target.setMessage("body2");
        assertEquals("body2", target.getMessage());
        target.setRecipients(new String[]{"r1", "r2"});
        assertArrayEquals(new String[]{"r1", "r2"}, target.getRecipients());
        target.setUrl("url2");
        assertEquals("url2", target.getUrl());
        target.setMobileUrl("mobileUrl2");
        assertEquals("mobileUrl2", target.getMobileUrl());
        target.setImage("image2");
        assertEquals("image2", target.getImage());
    }
    
    public void testConvertParameterMap() throws Exception {
        SendRequestParams target = createTarget("body1", new String[]{"r1", "r2"}, "url1", "mobileUrl1", "image1");
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("body1", actual.get("message"));
        assertEquals("r1,r2", actual.get("recipients"));
        assertEquals("url1", actual.get("url"));
        assertEquals("mobileUrl1", actual.get("mobileUrl"));
        assertEquals("image1", actual.get("image"));
        
        target = createTarget(null, null, null, null, null);
        actual = target.convertParameterMap();
        assertFalse(actual.containsKey("message"));
        assertFalse(actual.containsKey("recipients"));
        assertFalse(actual.containsKey("url"));
        assertFalse(actual.containsKey("mobileUrl"));
        assertFalse(actual.containsKey("image"));
    }
    
    private SendRequestParams createTarget(
            String message,
            String[] recipients,
            String url,
            String mobileUrl,
            String image) {
        return new SendRequestParams(message, recipients, url, mobileUrl, image);
    }
    
}
