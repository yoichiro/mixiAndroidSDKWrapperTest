package jp.mixi.android.sdk.wrapper.photo;

import java.util.Date;

import jp.mixi.android.sdk.wrapper.Utils;

import org.json.JSONObject;

import android.test.AndroidTestCase;

public class PhotoTest extends AndroidTestCase {

    public void testProperties() throws Exception {
        String json = "{\"albumId\":\"albumId1\",\"created\":"
            + "\"2010-06-10T01:32:13+09:00\",\"id\":\"id1\",\"largeImageUrl\""
            + ":\"largeImageUrl1\",\"mimeType\":\"mimeType1\",\"numComments\":"
            + "\"2\",\"numFavorites\":\"3\",\"thumbnailUrl\":\"thumbnailUrl1\""
            + ",\"title\":\"title1\",\"type\":\"type1\",\"url\":\"url1\","
            + "\"viewPageUrl\":\"viewPageUrl1\"}";
        JSONObject original = new JSONObject(json);
        Photo target = new Photo(original);
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), target.getCreatedAt().getTime());
        assertEquals("albumId1", target.getAlbumId());
        assertEquals("id1", target.getId());
        assertEquals("largeImageUrl1", target.getLargeImageUrl());
        assertEquals("mimeType1", target.getMimeType());
        assertEquals(2, target.getNumComments());
        assertEquals(3, target.getNumFavorites());
        assertEquals("thumbnailUrl1", target.getThumbnailUrl());
        assertEquals("title1", target.getTitle());
        assertEquals("type1", target.getType());
        assertEquals("url1", target.getUrl());
        assertEquals("viewPageUrl1", target.getViewPageUrl());
    }

}
