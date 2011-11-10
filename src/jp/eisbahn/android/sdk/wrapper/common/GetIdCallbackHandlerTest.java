package jp.eisbahn.android.sdk.wrapper.common;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetIdCallbackHandlerTest extends AbstractTest {

    private GetIdCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetIdCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"id\":\"id1\"}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        String id = target.getId();
        assertEquals("id1", id);
    }
    
}
