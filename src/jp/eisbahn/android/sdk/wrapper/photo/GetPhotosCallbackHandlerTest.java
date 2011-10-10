package jp.eisbahn.android.sdk.wrapper.photo;

import java.util.Date;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Photo;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.photo.GetPhotosCallbackHandler;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetPhotosCallbackHandlerTest extends AbstractTest {

    private GetPhotosCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetPhotosCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"entry\":[{\"albumId\""
            + ":\"albumId1\",\"created\":\"2010-11-01T12:04:49+09:00\""
            + ",\"id\":\"id1\",\"largeImageUrl\":\"largeImageUrl1\","
            + "\"mimeType\":\"mimeType1\",\"numComments\":\"1\","
            + "\"numFavorites\":\"2\",\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"title\":\"title1\",\"type\":\"type1\",\"url\":\"url1\","
            + "\"viewPageUrl\":\"viewPageUrl1\"}],\"startIndex\":1,"
            + "\"totalResults\":2,\"itemsPerPage\":3}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        int totalResults = target.getTotalResults();
        int itemsPerPage = target.getItemsPerPage();
        int startIndex = target.getStartIndex();
        assertEquals(2, totalResults);
        assertEquals(3, itemsPerPage);
        assertEquals(1, startIndex);
        List<Photo> photos = target.getPhotos();
        assertNotNull(photos);
        assertEquals(1, photos.size());
        Photo photo = photos.get(0);
        assertEquals("id1", photo.getId());
        Date date = Utils.createDate(2010, 11, 1, 12, 4, 49);
        assertEquals(date.getTime(), photo.getCreatedAt().getTime());
        assertEquals("albumId1", photo.getAlbumId());
        assertEquals("largeImageUrl1", photo.getLargeImageUrl());
        assertEquals("mimeType1", photo.getMimeType());
        assertEquals(1, photo.getNumComments());
        assertEquals(2, photo.getNumFavorites());
        assertEquals("thumbnailUrl1", photo.getThumbnailUrl());
        assertEquals("title1", photo.getTitle());
        assertEquals("type1", photo.getType());
        assertEquals("url1", photo.getUrl());
        assertEquals("viewPageUrl1", photo.getViewPageUrl());
    }
    
}
