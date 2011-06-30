package jp.eisbahn.android.sdk.wrapper.request;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.request.RequestProxyImpl;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestParams;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;
import android.content.Context;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class RequestProxyImplTest extends AbstractTest {

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
        
        RequestProxyImpl target = new RequestProxyImpl(mixiContainer);
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
        
        RequestProxyImpl target = new RequestProxyImpl(mixiContainer);
        target.deleteRequests(new String[] {"123", "456"}, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
