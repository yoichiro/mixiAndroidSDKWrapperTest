package jp.eisbahn.android.sdk.wrapper.people;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.common.Field;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleParams;
import jp.eisbahn.android.sdk.wrapper.people.SortBy;
import jp.eisbahn.android.sdk.wrapper.people.SortOrder;
import jp.eisbahn.android.sdk.wrapper.people.ThumbnailPrivacy;

public class GetPeopleParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        int startIndex = 1;
        int count = 2;
        GetPeopleParams target = new GetPeopleParams();
        target.setStartIndex(startIndex);
        target.setCount(count);
        target.setSortBy(SortBy.displayName);
        target.setSortOrder(SortOrder.descending);
        target.setThumbnailPrivacy(ThumbnailPrivacy.friends);
        target.setFields(new Field[] {
                Field.id,
                Field.displayName,
                Field.thumbnailUrl
        });
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("1", actual.get("startIndex"));
        assertEquals("2", actual.get("count"));
        assertEquals("displayName", actual.get("sortBy"));
        assertEquals("descending", actual.get("sortOrder"));
        assertEquals("friends", actual.get("thumbnailPrivacy"));
        assertEquals("id,displayName,thumbnailUrl", actual.get("fields"));
    }
    
}
