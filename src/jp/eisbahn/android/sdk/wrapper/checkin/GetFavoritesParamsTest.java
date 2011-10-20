package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Field;

public class GetFavoritesParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        int startIndex = 1;
        int count = 2;
        GetFavoritesParams target = new GetFavoritesParams();
        target.setStartIndex(startIndex);
        target.setCount(count);
        target.setFields(new Field[] {
                Field.id,
                Field.displayName,
                Field.thumbnailUrl
        });
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("1", actual.get("startIndex"));
        assertEquals("2", actual.get("count"));
        assertEquals("id,displayName,thumbnailUrl", actual.get("fields"));
    }
    
}
