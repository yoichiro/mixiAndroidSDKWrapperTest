package jp.eisbahn.android.sdk.wrapper.updates;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
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

}
