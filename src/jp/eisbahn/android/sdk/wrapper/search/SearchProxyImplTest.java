package jp.eisbahn.android.sdk.wrapper.search;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class SearchProxyImplTest extends AbstractTest {

    public void testGetPeople() throws Exception {
        GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", "e1,e2,e3");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/search/people/@all", params, handler);
        AndroidMock.replay(mixiContainer);
        
        SearchProxyImpl target = new SearchProxyImpl(mixiContainer);
        String[] emails = {"e1", "e2", "e3"};
        target.getPeople("@all", emails, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetPeopleWithoutGroupId() throws Exception {
        GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", "e1,e2,e3");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/search/people", params, handler);
        AndroidMock.replay(mixiContainer);
        
        SearchProxyImpl target = new SearchProxyImpl(mixiContainer);
        String[] emails = {"e1", "e2", "e3"};
        target.getPeople(emails, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
