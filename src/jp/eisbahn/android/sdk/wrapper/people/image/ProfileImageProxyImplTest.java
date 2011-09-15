package jp.eisbahn.android.sdk.wrapper.people.image;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class ProfileImageProxyImplTest extends AbstractTest {
    
    public void testGetMyProfileImages() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        target.getMyProfileImages(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyProfileImagesWithParams() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        Map<String, String> map = new HashMap<String, String>();
        map.put("startIndex", "2");
        map.put("count", "3");
        map.put("primary", "true");
        map.put("privacy", "friends");
        map.put("fields", "id,thumbnailUrl");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/@me/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        GetImagesParams params = new GetImagesParams();
        params.setStartIndex(2);
        params.setCount(3);
        params.setPrimary(true);
        params.setPrivacy(Privacy.friends);
        params.setFields(new Field[]{Field.id, Field.thumbnailUrl});
        target.getMyProfileImages(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendProfileImages() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        String userId = "userId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/" + userId + "/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        target.getFriendProfileImages(userId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendProfileImagesWithParams() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        String userId = "userId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("startIndex", "2");
        map.put("count", "3");
        map.put("primary", "true");
        map.put("privacy", "friends");
        map.put("fields", "id,thumbnailUrl");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/" + userId + "/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        GetImagesParams params = new GetImagesParams();
        params.setStartIndex(2);
        params.setCount(3);
        params.setPrimary(true);
        params.setPrivacy(Privacy.friends);
        params.setFields(new Field[]{Field.id, Field.thumbnailUrl});
        target.getFriendProfileImages(userId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyProfileImage() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        String imageId = "imageId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/@me/@self/" + imageId, handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        target.getMyProfileImage(imageId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyProfileImageWithParams() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        String imageId = "imageId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("startIndex", "2");
        map.put("count", "3");
        map.put("primary", "true");
        map.put("privacy", "friends");
        map.put("fields", "id,thumbnailUrl");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/@me/@self/" + imageId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        GetImagesParams params = new GetImagesParams();
        params.setStartIndex(2);
        params.setCount(3);
        params.setPrimary(true);
        params.setPrivacy(Privacy.friends);
        params.setFields(new Field[]{Field.id, Field.thumbnailUrl});
        target.getMyProfileImage(imageId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendProfileImage() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        String userId = "userId1";
        String imageId = "imageId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/" + userId + "/@self/" + imageId, handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        target.getFriendProfileImage(userId, imageId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendProfileImageWithParams() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        String userId = "userId1";
        String imageId = "imageId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("startIndex", "2");
        map.put("count", "3");
        map.put("primary", "true");
        map.put("privacy", "friends");
        map.put("fields", "id,thumbnailUrl");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/" + userId + "/@self/" + imageId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        GetImagesParams params = new GetImagesParams();
        params.setStartIndex(2);
        params.setCount(3);
        params.setPrimary(true);
        params.setPrivacy(Privacy.friends);
        params.setFields(new Field[]{Field.id, Field.thumbnailUrl});
        target.getFriendProfileImage(userId, imageId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testUploadProfileImage() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        InputStream in = new ByteArrayInputStream(new byte[] {1, 2, 3});
        Privacy privacy = Privacy.friends;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/@me/@self?privacy=friends",
                "image/jpeg", in, (long)in.available(), handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        target.uploadProfileImage(in, privacy, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteMyProfileImage() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String imageId = "imageId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/@me/@self/" + imageId, HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        target.deleteMyProfileImage(imageId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
