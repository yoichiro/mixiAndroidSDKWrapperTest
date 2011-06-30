package jp.eisbahn.android.sdk.wrapper.people;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleParams;
import jp.eisbahn.android.sdk.wrapper.people.PeopleContainerImpl;
import jp.eisbahn.android.sdk.wrapper.people.SortBy;
import jp.eisbahn.android.sdk.wrapper.people.SortOrder;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class PeopleContainerImplTest extends AbstractTest {

    public void testGetMe() throws Exception {
        GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        PeopleContainerImpl target = new PeopleContainerImpl(mixiContainer);
        target.getMe(handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriends() throws Exception {
        GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/@me/@friends", handler);
        AndroidMock.replay(mixiContainer);
        
        PeopleContainerImpl target = new PeopleContainerImpl(mixiContainer);
        target.getFriends(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsWithParams() throws Exception {
        GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("startIndex", "1");
        paramMap.put("sortBy", "displayName");
        paramMap.put("sortOrder", "descending");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/@me/@friends", paramMap, handler);
        AndroidMock.replay(mixiContainer);
        
        PeopleContainerImpl target = new PeopleContainerImpl(mixiContainer);
        GetPeopleParams params = new GetPeopleParams();
        params.setStartIndex(1);
        params.setSortBy(SortBy.displayName);
        params.setSortOrder(SortOrder.descending);
        target.getFriends(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
