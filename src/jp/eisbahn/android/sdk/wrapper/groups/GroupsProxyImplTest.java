package jp.eisbahn.android.sdk.wrapper.groups;

import java.util.HashMap;
import java.util.Map;

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

    public void testGetMyGroupsWithParams() throws Exception {
        GetGroupsCallbackHandler handler = new GetGroupsCallbackHandler(new MockContext());
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("startIndex", "2");
        paramMap.put("count", "3");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/groups/@me", paramMap, handler);
        AndroidMock.replay(mixiContainer);
        
        GroupsProxyImpl target = new GroupsProxyImpl(mixiContainer);
        GetGroupsParams params = new GetGroupsParams();
        params.setStartIndex(2);
        params.setCount(3);
        target.getMyGroups(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
