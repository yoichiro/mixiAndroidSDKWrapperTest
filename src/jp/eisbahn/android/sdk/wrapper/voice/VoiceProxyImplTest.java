package jp.eisbahn.android.sdk.wrapper.voice;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class VoiceProxyImplTest extends AbstractTest {

    public void testGetMyStatuses() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/@me/user_timeline", handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        target.getMyStatuses(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyStatusesWithParams() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        Map<String, String> map = new HashMap<String, String>();
        map.put("start_index", "123");
        map.put("count", "456");
        map.put("since_id", "sinceId1");
        map.put("trim_user", "exclude_screen_name");
        map.put("attach_photo", "true");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/@me/user_timeline", map, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        GetStatusesParams params = new GetStatusesParams();
        params.setStartIndex(123);
        params.setCount(456);
        params.setSinceId("sinceId1");
        params.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        params.setAttachPhoto(true);
        target.getMyStatuses(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendStatuses() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        String userId = "userId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/" + userId + "/user_timeline", handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        target.getFriendStatuses(userId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendStatusesWithParams() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        String userId = "userId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("start_index", "123");
        map.put("count", "456");
        map.put("since_id", "sinceId1");
        map.put("trim_user", "exclude_screen_name");
        map.put("attach_photo", "true");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/" + userId + "/user_timeline", map, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        GetStatusesParams params = new GetStatusesParams();
        params.setStartIndex(123);
        params.setCount(456);
        params.setSinceId("sinceId1");
        params.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        params.setAttachPhoto(true);
        target.getFriendStatuses(userId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsStatuses() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/friends_timeline", handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        target.getFriendsStatuses(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsStatusesWithParams() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        Map<String, String> map = new HashMap<String, String>();
        map.put("start_index", "123");
        map.put("count", "456");
        map.put("since_id", "sinceId1");
        map.put("trim_user", "exclude_screen_name");
        map.put("attach_photo", "true");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/friends_timeline", map, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        GetStatusesParams params = new GetStatusesParams();
        params.setStartIndex(123);
        params.setCount(456);
        params.setSinceId("sinceId1");
        params.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        params.setAttachPhoto(true);
        target.getFriendsStatuses(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetGroupStatuses() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        String groupId = "groupId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/friends_timeline/" + groupId, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        target.getGroupStatuses(groupId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetGroupStatusesWithParams() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        String groupId = "groupId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("start_index", "123");
        map.put("count", "456");
        map.put("since_id", "sinceId1");
        map.put("trim_user", "exclude_screen_name");
        map.put("attach_photo", "true");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/friends_timeline/" + groupId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        GetStatusesParams params = new GetStatusesParams();
        params.setStartIndex(123);
        params.setCount(456);
        params.setSinceId("sinceId1");
        params.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        params.setAttachPhoto(true);
        target.getGroupStatuses(groupId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetStatus() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        String postId = "postId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/" + postId, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        target.getStatus(postId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetStatusWithParams() throws Exception {
        GetStatusesCallbackHandler handler = new GetStatusesCallbackHandler(new MockContext());
        String postId = "postId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("trim_user", "exclude_screen_name");
        map.put("attach_photo", "true");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/statuses/" + postId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        GetStatusParams params = new GetStatusParams();
        params.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        params.setAttachPhoto(true);
        target.getStatus(postId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetStatusComments() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String postId = "postId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/replies/" + postId, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        target.getStatusComments(postId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetStatusCommentsWithParams() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String postId = "postId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("start_index", "123");
        map.put("count", "456");
        map.put("trim_user", "exclude_screen_name");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/replies/" + postId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        GetFeedbacksParams params = new GetFeedbacksParams();
        params.setStartIndex(123);
        params.setCount(456);
        params.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        target.getStatusComments(postId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetStatusFavorites() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String postId = "postId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/favorites/" + postId, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        target.getStatusFavorites(postId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetStatusFavoritesWithParams() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String postId = "postId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("start_index", "123");
        map.put("count", "456");
        map.put("trim_user", "exclude_screen_name");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/voice/favorites/" + postId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        VoiceProxyImpl target = new VoiceProxyImpl(mixiContainer);
        GetFeedbacksParams params = new GetFeedbacksParams();
        params.setStartIndex(123);
        params.setCount(456);
        params.setTrimUser(TrimUser.ID_AND_SCREEN_NAME);
        target.getStatusFavorites(postId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
