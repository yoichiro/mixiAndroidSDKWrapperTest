package jp.eisbahn.android.sdk.wrapper.message;

import java.util.Date;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;

public class GetMessagesParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        int startIndex = 1;
        int count = 2;
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        GetMessagesParams target = new GetMessagesParams();
        target.setStartIndex(startIndex);
        target.setCount(count);
        target.setFields(new Field[] {
                Field.id,
                Field.title,
                Field.body,
                Field.timeSent,
                Field.status,
                Field.displayName,
                Field.profileUrl,
                Field.thumbnailUrl
        });
        target.setUpdatedSince(updatedSince);
        target.setRelatedUserType("recipient");
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("1", actual.get("startIndex"));
        assertEquals("2", actual.get("count"));
        assertEquals(
                "id,title,body,timeSent,status,recipient.displayName,recipient.profileUrl,recipient.thumbnailUrl",
                actual.get("fields"));
        assertEquals(DateUtils.convertDate(updatedSince), actual.get("updatedSince"));
    }
    
}
