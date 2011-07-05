package jp.eisbahn.android.sdk.wrapper.photo;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.Visibility;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class PhotoProxyImplTest extends AbstractTest {

    public void testGetMyAlbums() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getMyAlbums(handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetMyAlbum() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String albumId = "album1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/@me/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getMyAlbum(albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbums() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String userId = "userId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/" + userId + "/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendAlbums(userId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbumsWithAccessKey() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String userId = "userId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/" + userId
                + "/@self?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendAlbums(userId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbum() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/" + userId + "/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendAlbum(userId, albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbumWithAccessKey() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/" + userId + "/@self/" + albumId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendAlbum(userId, albumId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsAlbums() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/@me/@friends", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendsAlbums(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyPhotos() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        String albumId = "albumId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/@me/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getMyPhotos(albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyPhoto() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/@me/@self/" + albumId + "/" + mediaItemId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getMyPhoto(albumId, mediaItemId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriendPhotos() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/" + userId + "/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhotos(userId, albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendPhotosWithAccessKey() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/" + userId + "/@self/" + albumId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhotos(userId, albumId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendPhoto() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/" + userId + "/@self/" + albumId + "/" + mediaItemId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhoto(userId, albumId, mediaItemId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendPhotoWithAccessKey() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/" + userId + "/@self/" + albumId + "/" + mediaItemId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhoto(userId, albumId, mediaItemId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriendsPhotos() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/@me/@friends", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendsPhotos(handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetMyAlbumComments() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String albumId = "albumId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/@me/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getMyAlbumComments(albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriendAlbumComments() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendAlbumComments(userId, albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbumCommentsWithAccessKey() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendAlbumComments(userId, albumId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyPhotoComments() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/@me/@self/" + albumId + "/" + mediaItemId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getMyPhotoComments(albumId, mediaItemId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriendPhotoComments() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId + "/" + mediaItemId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhotoComments(userId, albumId, mediaItemId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendPhotoCommentsWithAccessKey() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId + "/" + mediaItemId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhotoComments(userId, albumId, mediaItemId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyPhotoFavorites() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/favorites/mediaItems/@me/@self/" + albumId + "/" + mediaItemId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getMyPhotoFavorites(albumId, mediaItemId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriendPhotoFavorites() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/favorites/mediaItems/" + userId + "/@self/" + albumId + "/" + mediaItemId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhotoFavorites(userId, albumId, mediaItemId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendPhotoFavoritesWithAccessKey() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String mediaItemId = "mediaItemId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/favorites/mediaItems/" + userId + "/@self/" + albumId + "/" + mediaItemId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.getFriendPhotoFavorites(userId, albumId, mediaItemId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCreateAlbum() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String description = "description1";
        Visibility visibility = Visibility.friends;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put("title", title);
        params.put("description", description);
        params.put("visibility", visibility.toString());
        mixiContainer.send("/photo/albums/@me/@self", HttpMethod.POST, params, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.createAlbum(title, description, visibility, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCreateAlbumWithAccessKey() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String description = "description1";
        Visibility visibility = Visibility.access_key;
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put("title", title);
        params.put("description", description);
        params.put("visibility", visibility.toString());
        params.put("accessKey", accessKey);
        mixiContainer.send("/photo/albums/@me/@self", HttpMethod.POST, params, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.createAlbum(title, description, visibility, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteAlbum() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String albumId = "albumId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/@me/@self/" + albumId, HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.deleteAlbum(albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostMyAlbumComment() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String albumId = "albumId1";
        String text = "コメント１";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put("text", text);
        mixiContainer.send("/photo/comments/albums/@me/@self/" + albumId, HttpMethod.POST, params, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.postMyAlbumComment(albumId, text, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostFriendAlbumComment() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String text = "コメント１";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put("text", text);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId, HttpMethod.POST, params, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.postFriendAlbumComment(userId, albumId, text, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostFriendAlbumCommentWithAccessKey() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String text = "コメント１";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put("text", text);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC",
                HttpMethod.POST, params, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.postFriendAlbumComment(userId, albumId, accessKey, text, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testDeleteMyAlbumComment() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String albumId = "albumId1";
        String commentId = "commentId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/@me/@self/" + albumId + "/" + commentId,
                HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.deleteMyAlbumComment(albumId, commentId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteFriendAlbumComment() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String commentId = "commentId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId + "/" + commentId,
                HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.deleteFriendAlbumComment(userId, albumId, commentId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteFriendAlbumCommentWithAccessKey() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String commentId = "commentId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/comments/albums/" + userId + "/@self/" + albumId + "/" + commentId
                + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC",
                HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoProxyImpl target = new PhotoProxyImpl(mixiContainer);
        target.deleteFriendAlbumComment(userId, albumId, accessKey, commentId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
}
