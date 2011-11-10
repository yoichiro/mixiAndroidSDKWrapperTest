package jp.eisbahn.android.sdk.wrapper.photo;

import java.util.Date;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.common.Privacy;
import jp.eisbahn.android.sdk.wrapper.common.Visibility;
import jp.eisbahn.android.sdk.wrapper.photo.Album;

public class AlbumTest extends AbstractTest {

    public void testProperties() throws Exception {
        String json = "{\"created\":\"2010-06-10T01:32:13+09:00\","
            + "\"description\":\"description1\",\"id\":\"id1\","
            + "\"mediaItemCount\":\"2\",\"numComments\":\"3\","
            + "\"ownerId\":\"ownerId1\",\"privacy\":{\"visibility\":"
            + "\"everyone\"},\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"title\":\"title1\",\"url\":\"url1\",\"viewPageUrl\""
            + ":\"viewPageUrl1\"}";
        JSONObject original = new JSONObject(json);
        Album target = new Album(original);
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), target.getCreatedAt().getTime());
        assertEquals("id1", target.getId());
        assertEquals("thumbnailUrl1", target.getThumbnailUrl());
        assertEquals("title1", target.getTitle());
        assertEquals("description1", target.getDescription());
        assertEquals("ownerId1", target.getOwnerId());
        assertEquals(2, target.getMediaItemCount());
        assertEquals("url1", target.getUrl());
        assertEquals(3, target.getNumComments());
        assertEquals("viewPageUrl1", target.getViewPageUrl());
        Privacy privacy = target.getPrivacy();
        assertEquals(Visibility.everyone, privacy.getVisibility());
    }
    
}
