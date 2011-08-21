package jp.eisbahn.android.sdk.wrapper.message;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class StatusTest extends AbstractTest {

    public void testReal() throws Exception {
        assertEquals("new", Status.unread.getReal());
        assertEquals("read", Status.read.getReal());
        assertEquals("replied", Status.replied.getReal());
    }
    
}
