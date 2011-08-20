package jp.eisbahn.android.sdk.wrapper;

import java.io.ByteArrayInputStream;

import junit.framework.AssertionFailedError;

import org.json.JSONObject;

import android.test.AndroidTestCase;

import com.google.android.testing.mocking.AndroidMock;

public abstract class AbstractTest extends AndroidTestCase {

    protected void assertArrayEquals(Object[] expected, Object[] actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected == actual) {
            return;
        }
        if (expected != null && expected.equals(actual)) {
            return;
        }
        if (expected == null && actual != null) {
            throw new AssertionFailedError("expected is null, but actual is not null.");
        }
        if (expected != null && actual == null) {
            throw new AssertionFailedError("expected is not null, but actual is null.");
        }
        if (expected.length != actual.length) {
            throw new AssertionFailedError("expected.length is not actual.length");
        }
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                throw new AssertionFailedError("expected[" + i + "] is not actual[" + i + "]");
            }
        }
    }
    
    protected JSONObject eqJSONObject(JSONObject expected) {
        AndroidMock.reportMatcher(new JSONObjectMatcher(expected));
        return null;
    }
    
    protected ByteArrayInputStream eqByteArrayInputStream(ByteArrayInputStream expected) {
        AndroidMock.reportMatcher(new ByteArrayInputStreamMatcher(expected));
        return null;
    }

}
