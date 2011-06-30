package jp.eisbahn.android.sdk.wrapper.people;

import org.json.JSONObject;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.people.Person;

public class PersonTest extends AbstractTest {
    
    public void testProperties() throws Exception {
        String json = "{\"id\":\"id1\",\"displayName\":\"displayName1\""
            + ",\"thumbnailUrl\":\"thumbnailUrl1\",\"profileUrl\":\"profileUrl1\"}";
        JSONObject obj = new JSONObject(json);
        
        Person target = new Person(obj);
        
        assertEquals("id1", target.getId());
        assertEquals("displayName1", target.getDisplayName());
        assertEquals("thumbnailUrl1", target.getThumbnailUrl());
        assertEquals("profileUrl1", target.getProfileUrl());
    }

}
