package jp.eisbahn.android.sdk.wrapper.groups;

import java.util.List;

import android.os.Bundle;
import android.test.mock.MockContext;
import jp.eisbahn.android.sdk.wrapper.AbstractTest;

public class GetGroupsCallbackHandlerTest extends AbstractTest {

    private GetGroupsCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetGroupsCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"entry\":[{\"id\":\"id1\",\"title\":\""
            + "title1\"},{\"id\":\"id2\",\"title\""
            + ":\"title2\"}],\"totalResults\":123,\""
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
        List<Group> groups = target.getGroups();
        assertEquals(2, groups.size());
        Group group1 = groups.get(0);
        assertEquals("id1", group1.getId());
        assertEquals("title1", group1.getTitle());
        Group group2 = groups.get(1);
        assertEquals("id2", group2.getId());
        assertEquals("title2", group2.getTitle());
    }
    
}
