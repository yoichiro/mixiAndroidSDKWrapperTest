package jp.eisbahn.android.sdk.wrapper.request;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.request.SendRequestCallbackHandler;
import android.os.Bundle;
import android.test.mock.MockContext;

public class SendRequestCallbackHandlerTest extends AbstractTest {
    
    private SendRequestCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new SendRequestCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putString("request_member", "123,456");
        bundle.putString("request_id", "requestId1");
        
        target.onComplete(bundle);
        
        String[] requestMembers = target.getRequestMembers();
        assertArrayEquals(new String[] {"123", "456"}, requestMembers);
        String requestId = target.getRequestId();
        assertEquals("requestId1", requestId);
        
    }

}
