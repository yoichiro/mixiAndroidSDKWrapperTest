package jp.eisbahn.android.sdk.wrapper.diary;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.Visibility;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class DiaryProxyImplTest extends AbstractTest {

    public void testPostPublicDiary() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String body = "body1";
        JSONObject params = new JSONObject();
        params.put("title", title);
        params.put("body", body);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", "everyone");
        privacy.put("show_users", "1");
        params.put("privacy", privacy);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/diary/articles/@me/@self"),
                eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        DiaryProxyImpl target = new DiaryProxyImpl(mixiContainer);
        target.postPublicDiary(title, body, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostDiaryWithVisibility() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String body = "body1";
        Visibility visibility = Visibility.friends;
        JSONObject params = new JSONObject();
        params.put("title", title);
        params.put("body", body);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        privacy.put("show_users", "0");
        params.put("privacy", privacy);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/diary/articles/@me/@self"),
                eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        DiaryProxyImpl target = new DiaryProxyImpl(mixiContainer);
        target.postDiary(title, body, visibility, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostDiaryWithGroup() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String body = "body1";
        String group = "group1";
        JSONObject params = new JSONObject();
        params.put("title", title);
        params.put("body", body);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", Visibility.group.toString());
        privacy.put("group", group);
        privacy.put("show_users", "0");
        params.put("privacy", privacy);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/diary/articles/@me/@self"),
                eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        DiaryProxyImpl target = new DiaryProxyImpl(mixiContainer);
        target.postDiary(title, body, group, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostDiaryWithVisibilityShowUsers() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String body = "body1";
        Visibility visibility = Visibility.friends;
        boolean showUsers = true;
        JSONObject params = new JSONObject();
        params.put("title", title);
        params.put("body", body);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        privacy.put("show_users", "1");
        params.put("privacy", privacy);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/diary/articles/@me/@self"),
                eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        DiaryProxyImpl target = new DiaryProxyImpl(mixiContainer);
        target.postDiary(title, body, visibility, showUsers, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostDiaryWithGroupShowUsers() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String body = "body1";
        String group = "group1";
        boolean showUsers = true;
        JSONObject params = new JSONObject();
        params.put("title", title);
        params.put("body", body);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", Visibility.group.toString());
        privacy.put("group", group);
        privacy.put("show_users", "1");
        params.put("privacy", privacy);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/diary/articles/@me/@self"),
                eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        DiaryProxyImpl target = new DiaryProxyImpl(mixiContainer);
        target.postDiary(title, body, group, showUsers, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}