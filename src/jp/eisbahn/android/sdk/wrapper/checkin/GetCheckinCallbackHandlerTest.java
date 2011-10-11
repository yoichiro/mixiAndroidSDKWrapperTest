package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.Date;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Comment;
import jp.eisbahn.android.sdk.wrapper.Photo;
import jp.eisbahn.android.sdk.wrapper.User;
import jp.eisbahn.android.sdk.wrapper.Utils;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetCheckinCallbackHandlerTest extends AbstractTest {

    private GetCheckinCallbackHandler handler;
    
    @Override
    protected void setUp() {
        handler = new GetCheckinCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        handler = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"id\":\"id1\","
            + "\"message\":\"message1\","
            + "\"spot\":{"
            + "\"id\":\"id2\","
            + "\"name\":{"
            + "\"formatted\":\"formatted2\"},"
            + "\"address\":{"
            + "\"formatted\":\"formatted3\","
            + "\"latitude\":\"123.456\","
            + "\"longitude\":\"-456.789\","
            + "\"geohash\":\"geohash2\","
            + "\"distance\":\"987.543\"}},"
            + "\"location\":{"
            + "\"latitude\":\"765.32\","
            + "\"longitude\":\"45.678\"},"
            + "\"numComments\":\"2\","
            + "\"numFavorites\":\"3\","
            + "\"comments\":[{"
            + "\"id\":\"id3\","
            + "\"user\":{"
            + "\"id\":\"id4\","
            + "\"displayName\":\"displayName1\","
            + "\"thumbnailUrl\":\"thumbnailUrl1\","
            + "\"profileUrl\":\"profileUrl1\"},"
            + "\"text\":\"text1\","
            + "\"created\":\"2010-11-10T17:26:23+09:00\""
            + "}],"
            + "\"favorites\":[{"
            + "\"id\":\"id5\","
            + "\"displayName\":\"displayName2\","
            + "\"thumbnailUrl\":\"thumbnailUrl2\","
            + "\"profileUrl\":\"profileUrl2\""
            + "}],"
            + "\"favorited\":true,"
            + "\"created\":\"2011-12-11T18:27:22+09:00\","
            + "\"photo\":[{"
            + "\"albumId\":\"albumId1\","
            + "\"created\":\"2011-09-08T16:24:12+09:00\","
            + "\"id\":\"id6\","
            + "\"largeImageUrl\":\"largeImageUrl1\","
            + "\"mimeType\":\"mimeType1\","
            + "\"numComments\":\"8\","
            + "\"numFavorites\":\"9\","
            + "\"thumbnailUrl\":\"thumbnailUrl3\","
            + "\"title\":\"title1\","
            + "\"type\":\"type1\","
            + "\"url\":\"url1\","
            + "\"viewPageUrl\":\"viewPageUrl1\""
            + "}],"
            + "\"user\":{"
            + "\"id\":\"id7\","
            + "\"displayName\":\"displayName7\","
            + "\"thumbnailUrl\":\"thumbnailUrl7\","
            + "\"profileUrl\":\"profileUrl7\"}"
            + "}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        handler.onComplete(bundle);
        
        Checkin target = handler.getCheckin();
        assertEquals("id1", target.getId());
        User user = target.getUser();
        assertEquals("id7", user.getId());
        assertEquals("displayName7", user.getDisplayName());
        assertEquals("thumbnailUrl7", user.getThumbnailUrl());
        assertEquals("profileUrl7", user.getProfileUrl());
        assertEquals("message1", target.getMessage());
        
        Spot spot = target.getSpot();
        assertEquals("id2", spot.getId());
        Name name = spot.getName();
        assertEquals("formatted2", name.getFormatted());
        Address address = spot.getAddress();
        assertEquals("formatted3", address.getFormatted());
        assertEquals((double)123.456, address.getLatitude());
        assertEquals((double)-456.789, address.getLongitude());
        assertEquals("geohash2", address.getGeohash());
        assertEquals((double)987.543, address.getDistance());
        
        Location location = target.getLocation();
        assertEquals((double)765.32, location.getLatitude());
        assertEquals((double)45.678, location.getLongitude());
        
        assertEquals((int)2, target.getNumComments());
        assertEquals((int)3, target.getNumFavorites());
        
        Comment[] comments = target.getComments();
        assertEquals(1, comments.length);
        Comment comment = comments[0];
        assertEquals("id3", comment.getId());
        user = comment.getUser();
        assertEquals("id4", user.getId());
        assertEquals("displayName1", user.getDisplayName());
        assertEquals("thumbnailUrl1", user.getThumbnailUrl());
        assertEquals("profileUrl1", user.getProfileUrl());
        assertEquals("text1", comment.getText());
        Date date = Utils.createDate(2010, 11, 10, 17, 26, 23);
        assertEquals(date.getTime(), comment.getCreated().getTime());
        
        User[] favorites = target.getFavorites();
        assertEquals(1, favorites.length);
        user = favorites[0];
        assertEquals("id5", user.getId());
        assertEquals("displayName2", user.getDisplayName());
        assertEquals("thumbnailUrl2", user.getThumbnailUrl());
        assertEquals("profileUrl2", user.getProfileUrl());
        
        assertTrue(target.isFavorited());
        date = Utils.createDate(2011, 12, 11, 18, 27, 22);
        assertEquals(date.getTime(), target.getCreated().getTime());
        
        Photo[] photos = target.getPhotos();
        assertEquals(1, photos.length);
        Photo photo = photos[0];
        date = Utils.createDate(2011, 9, 8, 16, 24, 12);
        assertEquals(date.getTime(), photo.getCreatedAt().getTime());
        assertEquals("albumId1", photo.getAlbumId());
        assertEquals("id6", photo.getId());
        assertEquals("largeImageUrl1", photo.getLargeImageUrl());
        assertEquals("mimeType1", photo.getMimeType());
        assertEquals(8, photo.getNumComments());
        assertEquals(9, photo.getNumFavorites());
        assertEquals("thumbnailUrl3", photo.getThumbnailUrl());
        assertEquals("title1", photo.getTitle());
        assertEquals("type1", photo.getType());
        assertEquals("url1", photo.getUrl());
        assertEquals("viewPageUrl1", photo.getViewPageUrl());
    }
    
}
