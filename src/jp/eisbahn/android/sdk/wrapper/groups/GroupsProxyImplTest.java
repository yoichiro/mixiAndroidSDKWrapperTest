package jp.eisbahn.android.sdk.wrapper.groups;

import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.mixi.android.sdk.MixiContainer;

public class GroupsProxyImplTest extends AbstractTest {
    
    public void testGetMyGroups() throws Exception {
        GetGroupsCallbackHandler handler = new GetGroupsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/groups/@me", handler);
        AndroidMock.replay(mixiContainer);
        
        GroupsProxyImpl target = new GroupsProxyImpl(mixiContainer);
        target.getMyGroups(handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
