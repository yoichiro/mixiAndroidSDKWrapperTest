package jp.eisbahn.android.sdk.wrapper.voice;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class PhotoTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"thumbnail_url\":\"thumbnailUrl1\",\"image_url\":"
            + "\"imageUrl1\"}";
        JSONObject original = new JSONObject(json);
        Photo target = new Photo(original);
        assertEquals("thumbnailUrl1", target.getThumbnailUrl());
        assertEquals("imageUrl1", target.getImageUrl());
    }

}
