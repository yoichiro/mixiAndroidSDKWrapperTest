package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetCommentsParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        GetCommentsParams target = new GetCommentsParams();
        target.setStartIndex(3);
        target.setCount(2);
        target.setFields(new CommentField[] {
                CommentField.id,
                CommentField.user_id,
                CommentField.user_displayName
        });
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("3", actual.get("startIndex"));
        assertEquals("2", actual.get("count"));
        assertEquals("id,user.id,user.displayName", actual.get("fields"));
    }
    
}
