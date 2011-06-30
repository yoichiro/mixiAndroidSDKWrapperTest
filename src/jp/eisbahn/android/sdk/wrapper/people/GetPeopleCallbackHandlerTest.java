package jp.eisbahn.android.sdk.wrapper.people;

import java.util.List;

import android.os.Bundle;
import android.test.mock.MockContext;
import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.people.GetPeopleCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.people.Person;

public class GetPeopleCallbackHandlerTest extends AbstractTest {

    private GetPeopleCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetPeopleCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"entry\":[{\"id\":\"id1\",\"displayName\":\""
            + "displayName1\",\"thumbnailUrl\":\"thumbnailUrl1\",\""
            + "profileUrl\":\"profileUrl1\"},{\"id\":\"id2\",\"displayName\""
            + ":\"displayName2\",\"thumbnailUrl\":\"thumbnailUrl2\",\""
            + "profileUrl\":\"profileUrl2\"}],\"totalResults\":123,\""
            + "itemsPerPage\":456,\"startIndex\":789}";
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        
        target.onComplete(bundle);
        
        int totalResults = target.getTotalResults();
        int itemsPerPage = target.getItemsPerPage();
        int startIndex = target.getStartIndex();
        assertEquals(123, totalResults);
        assertEquals(456, itemsPerPage);
        assertEquals(789, startIndex);
        List<Person> people = target.getPeople();
        assertEquals(2, people.size());
        Person person1 = people.get(0);
        assertEquals("id1", person1.getId());
        assertEquals("displayName1", person1.getDisplayName());
        assertEquals("thumbnailUrl1", person1.getThumbnailUrl());
        assertEquals("profileUrl1", person1.getProfileUrl());
        Person person2 = people.get(1);
        assertEquals("id2", person2.getId());
        assertEquals("displayName2", person2.getDisplayName());
        assertEquals("thumbnailUrl2", person2.getThumbnailUrl());
        assertEquals("profileUrl2", person2.getProfileUrl());
    }
    
}
