package jp.eisbahn.android.sdk.wrapper.people.image;

import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetImagesParamsTest extends AbstractTest {

    public void testConvertParameterMapFull() throws Exception {
        int startIndex = 1;
        int count = 2;
        boolean primary = true;
        Privacy privacy = Privacy.friends;
        GetImagesParams target = new GetImagesParams();
        target.setStartIndex(startIndex);
        target.setCount(count);
        target.setPrimary(primary);
        target.setPrivacy(privacy);
        target.setFields(new Field[] {
                Field.id,
                Field.recommender,
                Field.thumbnailUrl
        });
        Map<String, String> actual = target.convertParameterMap();
        assertEquals("1", actual.get("startIndex"));
        assertEquals("2", actual.get("count"));
        assertEquals("true", actual.get("primary"));
        assertEquals("friends", actual.get("privacy"));
        assertEquals("id,recommender,thumbnailUrl", actual.get("fields"));
    }
    
}
