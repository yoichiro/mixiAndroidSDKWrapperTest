package jp.eisbahn.android.sdk.wrapper.check;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.Visibility;
import jp.mixi.android.sdk.MixiContainer;

import org.json.JSONObject;

import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class CheckProxyImplTest extends AbstractTest {

    public void testPostCheck() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String key = "key1";
        String title = "title1";
        String primaryUrl = "primaryUrl1";
        JSONObject params = new JSONObject();
        params.put("key", key);
        params.put("title", title);
        params.put("primaryUrl", primaryUrl);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/share"), eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckProxyImpl target = new CheckProxyImpl(mixiContainer);
        target.postCheck(key, title, primaryUrl, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testPostCheckWithParams() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String key = "key1";
        String title = "title1";
        String primaryUrl = "primaryUrl1";
        Visibility visibility = Visibility.group;
        String group = "group1";
        JSONObject params = new JSONObject();
        params.put("key", key);
        params.put("title", title);
        params.put("primaryUrl", primaryUrl);
        JSONObject privacy = new JSONObject("{\"group\":\"group1\",\"visibility\":\"group\"}");
        params.put("privacy", privacy);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/share"), eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckProxyImpl target = new CheckProxyImpl(mixiContainer);
        PostCheckParams additionals = new PostCheckParams();
        additionals.setVisibility(visibility);
        additionals.setGroup(group);
        target.postCheck(key, title, primaryUrl, additionals, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
}
