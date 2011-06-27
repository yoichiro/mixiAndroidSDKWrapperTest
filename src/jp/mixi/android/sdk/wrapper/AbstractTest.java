package jp.mixi.android.sdk.wrapper;

import junit.framework.AssertionFailedError;
import android.test.AndroidTestCase;

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
    

}
