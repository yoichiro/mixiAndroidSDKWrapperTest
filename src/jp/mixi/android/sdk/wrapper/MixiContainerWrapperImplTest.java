package jp.mixi.android.sdk.wrapper;

import java.util.HashMap;
import java.util.Map;

import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;
import jp.mixi.android.sdk.wrapper.people.GetPeopleParams;
import jp.mixi.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.mixi.android.sdk.wrapper.people.SortBy;
import jp.mixi.android.sdk.wrapper.people.SortOrder;
import jp.mixi.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.mixi.android.sdk.wrapper.request.SendRequestParams;
import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class MixiContainerWrapperImplTest extends AndroidTestCase {

    public void testSendRequest() throws Exception {
        Context context = new MockContext();
        SendRequestParams params = new SendRequestParams(
                "body1",
                new String[] {"r1", "r2"},
                "url1",
                "mobileUrl1",
                "image1");
        SendRequestCallbackHandler handler = new SendRequestCallbackHandler(context);
        Map<String, String> parameterMap = params.convertParameterMap();
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.showDialog(context, "/requests", parameterMap, handler);
        AndroidMock.replay(mixiContainer);
        
        MixiContainerWrapper target = new MixiContainerWrapperImpl(mixiContainer);
        target.sendRequest(context, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testDeleteRequests() throws Exception {
        String requestIds = "123,456";
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        Map<String, String> params = new HashMap<String, String>();
        params.put("requestIds", requestIds);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/apps/requests/@me/@self", HttpMethod.DELETE, params, handler);
        AndroidMock.replay(mixiContainer);
        
        MixiContainerWrapper target = new MixiContainerWrapperImpl(mixiContainer);
        target.deleteRequests(new String[] {"123", "456"}, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetMe() throws Exception {
        GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        MixiContainerWrapper target = new MixiContainerWrapperImpl(mixiContainer);
        target.getMe(handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriends() throws Exception {
        GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/@me/@friends", handler);
        AndroidMock.replay(mixiContainer);
        
        MixiContainerWrapper target = new MixiContainerWrapperImpl(mixiContainer);
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
        
        MixiContainerWrapper target = new MixiContainerWrapperImpl(mixiContainer);
        GetPeopleParams params = new GetPeopleParams();
        params.setStartIndex(1);
        params.setSortBy(SortBy.displayName);
        params.setSortOrder(SortOrder.descending);
        target.getFriends(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
