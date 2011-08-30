package jp.eisbahn.android.sdk.wrapper.updates;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class UpdatesProxyImplTest extends AbstractTest {

    public void testGetMyFeeds() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        target.getMyFeeds(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendFeeds() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        String userId = "userId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/" + userId + "/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        target.getFriendFeeds(userId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsFeeds() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/@me/@friends", handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        target.getFriendsFeeds(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetGroupFeeds() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        String groupId = "groupId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/@me/" + groupId, handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        target.getGroupFeeds(groupId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyFeedsWithParams() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        Map<String, String> map = new HashMap<String, String>();
        map.put("count", "2");
        map.put("device", "mobile");
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        map.put("updatedSince", DateUtils.convertDate(updatedSince));
        map.put("fields", "video,calendar");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/@me/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        GetFeedParams params = new GetFeedParams();
        params.setCount(2);
        params.setDevice(Device.mobile);
        params.setUpdatedSince(updatedSince);
        params.setFields(new Field[]{Field.video, Field.calendar});
        target.getMyFeeds(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendFeedsWithParams() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        String userId = "userId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("count", "2");
        map.put("device", "mobile");
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        map.put("updatedSince", DateUtils.convertDate(updatedSince));
        map.put("fields", "video,calendar");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/" + userId + "/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        GetFeedParams params = new GetFeedParams();
        params.setCount(2);
        params.setDevice(Device.mobile);
        params.setUpdatedSince(updatedSince);
        params.setFields(new Field[]{Field.video, Field.calendar});
        target.getFriendFeeds(userId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsFeedsWithParams() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        Map<String, String> map = new HashMap<String, String>();
        map.put("count", "2");
        map.put("device", "mobile");
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        map.put("updatedSince", DateUtils.convertDate(updatedSince));
        map.put("fields", "video,calendar");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/@me/@friends", map, handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        GetFeedParams params = new GetFeedParams();
        params.setCount(2);
        params.setDevice(Device.mobile);
        params.setUpdatedSince(updatedSince);
        params.setFields(new Field[]{Field.video, Field.calendar});
        target.getFriendsFeeds(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetGroupFeedsWithParams() throws Exception {
        GetFeedCallbackHandler handler = new GetFeedCallbackHandler(new MockContext());
        String groupId = "groupId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("count", "2");
        map.put("device", "mobile");
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        map.put("updatedSince", DateUtils.convertDate(updatedSince));
        map.put("fields", "video,calendar");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/updates/@me/" + groupId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        UpdatesProxyImpl target = new UpdatesProxyImpl(mixiContainer);
        GetFeedParams params = new GetFeedParams();
        params.setCount(2);
        params.setDevice(Device.mobile);
        params.setUpdatedSince(updatedSince);
        params.setFields(new Field[]{Field.video, Field.calendar});
        target.getGroupFeeds(groupId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
