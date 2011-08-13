package jp.eisbahn.android.sdk.wrapper;

import org.easymock.IArgumentMatcher;
import org.json.JSONObject;

public class JSONObjectMatcher implements IArgumentMatcher {
    
    private JSONObject expected;
    
    public JSONObjectMatcher(JSONObject expected) {
        super();
        this.expected = expected;
    }

    @Override
    public void appendTo(StringBuffer sb) {
        sb.append(expected.toString());
    }

    @Override
    public boolean matches(Object actual) {
        if (!(actual instanceof JSONObject)) {
            return false;
        }
        return expected.toString().equals(((JSONObject)actual).toString());
    }

}
