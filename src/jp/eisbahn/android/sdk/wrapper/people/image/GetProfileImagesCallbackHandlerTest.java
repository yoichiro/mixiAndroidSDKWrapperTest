package jp.eisbahn.android.sdk.wrapper.people.image;

import java.util.Date;
import java.util.List;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import android.os.Bundle;
import android.test.mock.MockContext;

public class GetProfileImagesCallbackHandlerTest extends AbstractTest {

    private GetProfileImagesCallbackHandler target;
    
    @Override
    protected void setUp() {
        target = new GetProfileImagesCallbackHandler(new MockContext());
    }
    
    @Override
    protected void tearDown() {
        target = null;
    }
    
    public void testSimple() throws Exception {
        String json = "{\"entry\":[{\"id\":\"id1\",\"privacy\":\"friends\""
            + ",\"thumbnailUrl\":\"thumbnailUrl1\",\"primary\":true,"
            + "\"created\":\"2010-06-10T01:32:13+09:00\","
            + "\"recommender\":{\"thumbnailUrl\":\"thumbnailUrl2\","
            + "\"id\":\"id2\",\"displayName\":\"displayName1\","
            + "\"profileUrl\":\"profileUrl1\",\"message\":\"message1\"}}"
            + "],\"totalResults\":123,\""
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
        List<ProfileImage> images = target.getProfileImages();
        assertEquals(1, images.size());
        ProfileImage image1 = images.get(0);
        assertEquals("id1", image1.getId());
        assertEquals(Privacy.friends, image1.getPrivacy());
        assertEquals("thumbnailUrl1", image1.getThumbnailUrl());
        assertEquals(true, image1.isPrimary());
        Date date = Utils.createDate(2010, 6, 10, 1, 32, 13);
        assertEquals(date.getTime(), image1.getCreated().getTime());
        Recommender recommender = image1.getRecommender();
        assertEquals("id2", recommender.getId());
        assertEquals("thumbnailUrl2", recommender.getThumbnailUrl());
        assertEquals("displayName1", recommender.getDisplayName());
        assertEquals("profileUrl1", recommender.getProfileUrl());
        assertEquals("message1", recommender.getMessage());
    }
    
}
