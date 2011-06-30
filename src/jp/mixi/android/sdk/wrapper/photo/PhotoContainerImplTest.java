package jp.mixi.android.sdk.wrapper.photo;

import jp.mixi.android.sdk.MixiContainer;
import jp.mixi.android.sdk.wrapper.AbstractTest;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class PhotoContainerImplTest extends AbstractTest {

    public void testGetMyAlbums() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
        target.getMyAlbums(handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetMyAlbum() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String albumId = "album1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/@me/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
        target.getMyAlbum(albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbums() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String userId = "userId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/" + userId + "/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
        target.getFriendAlbums(userId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbumsWithAccessKey() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String userId = "userId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/" + userId + "/@self?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
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
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
        target.getFriendAlbum(userId, albumId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendAlbumWithAccessKey() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        String userId = "userId1";
        String albumId = "albumId1";
        String accessKey = "アクセスキー";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/" + userId + "/@self/" + albumId + "?accessKey=%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E3%82%AD%E3%83%BC", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
        target.getFriendAlbum(userId, albumId, accessKey, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsAlbums() throws Exception {
        GetAlbumsCallbackHandler handler = new GetAlbumsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/albums/@me/@friends", handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
        target.getFriendsAlbums(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyPhotos() throws Exception {
        GetPhotosCallbackHandler handler = new GetPhotosCallbackHandler(new MockContext());
        String albumId = "albumId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/photo/mediaItems/@me/@self/" + albumId, handler);
        AndroidMock.replay(mixiContainer);
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
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
        
        PhotoContainerImpl target = new PhotoContainerImpl(mixiContainer);
        target.getMyPhoto(albumId, mediaItemId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
}
