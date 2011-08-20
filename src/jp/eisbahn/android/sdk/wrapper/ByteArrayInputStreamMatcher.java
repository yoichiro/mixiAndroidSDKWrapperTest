package jp.eisbahn.android.sdk.wrapper;

import java.io.ByteArrayInputStream;

import org.easymock.IArgumentMatcher;

public class ByteArrayInputStreamMatcher implements IArgumentMatcher {
    
    private ByteArrayInputStream expected;
    
    public ByteArrayInputStreamMatcher(ByteArrayInputStream expected) {
        super();
        this.expected = expected;
    }

    @Override
    public void appendTo(StringBuffer sb) {
        sb.append(expected.getClass().getCanonicalName());
    }

    @Override
    public boolean matches(Object actualStream) {
        if (!(actualStream instanceof ByteArrayInputStream)) {
            return false;
        }
        ByteArrayInputStream actual = (ByteArrayInputStream)actualStream;
        if (expected.available() != actual.available()) {
            return false;
        }
        int length = expected.available();
        for (int i = 0; i < length; i++) {
            int evalue = expected.read();
            int avalue = actual.read();
            if (evalue != avalue) {
                return false;
            }
        }
        return true;
    }

}
