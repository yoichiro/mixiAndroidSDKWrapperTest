package jp.mixi.android.sdk.wrapper.photo;

import java.util.Date;
import java.util.List;

import jp.mixi.android.sdk.wrapper.AbstractTest;
import jp.mixi.android.sdk.wrapper.Privacy;
import jp.mixi.android.sdk.wrapper.Utils;
import jp.mixi.android.sdk.wrapper.Visibility;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetAlbumsCallbackHandlerTest extends AbstractTest {

    private GetAlbumsCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetAlbumsCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"entry\":[{\"created\":\"2010-11-02T10:42:57+09:00\","
            + "\"description\":\"description1\",\"id\":\"id1\","
            + "\"mediaItemCount\":\"200\",\"numComments\":\"5\",\"ownerId\""
            + ":\"ownerId1\",\"privacy\":{\"visibility\":\"everyone\"},"
            + "\"thumbnailUrl\":\"thumbnailUrl1\",\"title\":\"title1\","
            + "\"url\":\"url1\",\"viewPageUrl\":\"viewPageUrl1\"}],"
            + "\"startIndex\":1,\"totalResults\":2,\"itemsPerPage\":3}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        int totalResults = target.getTotalResults();
        int itemsPerPage = target.getItemsPerPage();
        int startIndex = target.getStartIndex();
        assertEquals(2, totalResults);
        assertEquals(3, itemsPerPage);
        assertEquals(1, startIndex);
        List<Album> albums = target.getAlbums();
        assertNotNull(albums);
        assertEquals(1, albums.size());
        Album album = albums.get(0);
        Date date = Utils.createDate(2010, 11, 2, 10, 42, 57);
        assertEquals(date.getTime(), album.getCreatedAt().getTime());
        assertEquals("description1", album.getDescription());
        assertEquals("id1", album.getId());
        assertEquals(200, album.getMediaItemCount());
        assertEquals(5, album.getNumComments());
        assertEquals("ownerId1", album.getOwnerId());
        Privacy privacy = album.getPrivacy();
        assertEquals(Visibility.everyone, privacy.getVisibility());
        assertEquals("thumbnailUrl1", album.getThumbnailUrl());
        assertEquals("title1", album.getTitle());
        assertEquals("url1", album.getUrl());
        assertEquals("viewPageUrl1", album.getViewPageUrl());
    }
    
}
