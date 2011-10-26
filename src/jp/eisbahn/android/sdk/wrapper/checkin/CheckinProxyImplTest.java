package jp.eisbahn.android.sdk.wrapper.checkin;

import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;

import org.json.JSONObject;

import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class CheckinProxyImplTest extends AbstractTest {

    public void testGetSpot() throws Exception {
        GetSpotCallbackHandler handler = new GetSpotCallbackHandler(new MockContext());
        String spotId = "spotId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/spots/" + spotId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getSpot(spotId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetSpotWithFields() throws Exception {
        GetSpotCallbackHandler handler = new GetSpotCallbackHandler(new MockContext());
        String spotId = "spotId1";
        SpotField[] fields = new SpotField[] {
                SpotField.owner_id,
                SpotField.address_distance
        };
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "owner.id,address.distance");
        mixiContainer.send("/spots/" + spotId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getSpot(spotId, fields, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testSearchSpots() throws Exception {
        GetSpotsCallbackHandler handler = new GetSpotsCallbackHandler(new MockContext());
        double latitude = 123.456;
        double longitude = 789.321;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("center", "123.456,789.321");
        mixiContainer.send("/search/spots", map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.searchSpots(latitude, longitude, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testSearchSpotsWithParams() throws Exception {
        GetSpotsCallbackHandler handler = new GetSpotsCallbackHandler(new MockContext());
        double latitude = 123.456;
        double longitude = 789.321;
        SpotField[] fields = new SpotField[] {
                SpotField.owner_id,
                SpotField.address_distance
        };
        String keyword = "keyword1";
        String sinceId = "sinceId1";
        ResultsDirection resultsDirection = ResultsDirection.recent;
        int count = 123;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("center", "123.456,789.321");
        map.put("fields", "owner.id,address.distance");
        map.put("q", keyword);
        map.put("sinceId", sinceId);
        map.put("resultsDirection", resultsDirection.toString());
        map.put("count", String.valueOf(count));
        mixiContainer.send("/search/spots", map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        SearchSpotsParams params = new SearchSpotsParams();
        params.setCenter(latitude, longitude);
        params.setCount(count);
        params.setFields(fields);
        params.setKeyword(keyword);
        params.setResultsDirection(resultsDirection);
        params.setSinceId(sinceId);
        target.searchSpots(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMySpots() throws Exception {
        GetSpotsCallbackHandler handler = new GetSpotsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/spots/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getMySpots(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendSpots() throws Exception {
        GetSpotsCallbackHandler handler = new GetSpotsCallbackHandler(new MockContext());
        String userId = "userId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/spots/" + userId + "/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getFriendSpots(userId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetMySpotsWithParams() throws Exception {
        GetSpotsCallbackHandler handler = new GetSpotsCallbackHandler(new MockContext());
        SpotField[] fields = new SpotField[] {
                SpotField.owner_id,
                SpotField.address_distance
        };
        int startIndex = 2;
        int count = 3;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "owner.id,address.distance");
        map.put("startIndex", String.valueOf(startIndex));
        map.put("count", String.valueOf(count));
        mixiContainer.send("/spots/@me/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetSpotsParams params = new GetSpotsParams();
        params.setFields(fields);
        params.setStartIndex(startIndex);
        params.setCount(count);
        target.getMySpots(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetFriendSpotsWithParams() throws Exception {
        GetSpotsCallbackHandler handler = new GetSpotsCallbackHandler(new MockContext());
        String userId = "userId1";
        SpotField[] fields = new SpotField[] {
                SpotField.owner_id,
                SpotField.address_distance
        };
        int startIndex = 2;
        int count = 3;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "owner.id,address.distance");
        map.put("startIndex", String.valueOf(startIndex));
        map.put("count", String.valueOf(count));
        mixiContainer.send("/spots/" + userId + "/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetSpotsParams params = new GetSpotsParams();
        params.setFields(fields);
        params.setStartIndex(startIndex);
        params.setCount(count);
        target.getFriendSpots(userId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testCreateSpot() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String name = "name1";
        double latitude = 123.456;
        double longitude = 789.321;
        String description = "description1";

        JSONObject params = new JSONObject();
        params.put("name", name);
        JSONObject location = new JSONObject();
        location.put("latitude", String.valueOf(latitude));
        location.put("longitude", String.valueOf(longitude));
        params.put("location", location);
        params.put("description", description);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/spots/@me/@self"),
                eqJSONObject(params), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.createSpot(name, description, latitude, longitude, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testDeleteSpot() throws Exception {
        CallbackAdapter handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/spots/@me/@self/" + spotId, HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.deleteSpot(spotId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetMyCheckins() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getMyCheckins(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyCheckinsWithParams() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        CheckinField[] fields = new CheckinField[] {
                CheckinField.comments_created,
                CheckinField.location_longitude
        };
        String spotId = "spotId1";
        String sinceId = "sinceId1";
        double latitude = 123.456;
        double longitude = 789.321;
        ResultsDirection resultsDirection = ResultsDirection.recent;
        int count = 123;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("center", "123.456,789.321");
        map.put("fields", "comments.created,location.longitude");
        map.put("spotId", spotId);
        map.put("sinceId", sinceId);
        map.put("resultsDirection", resultsDirection.toString());
        map.put("count", String.valueOf(count));
        mixiContainer.send("/checkins/@me/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetCheckinsParams params = new GetCheckinsParams();
        params.setCenter(latitude, longitude);
        params.setCount(count);
        params.setFields(fields);
        params.setResultsDirection(resultsDirection);
        params.setSinceId(sinceId);
        params.setSpotId(spotId);
        target.getMyCheckins(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckins() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        String userId = "userId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/" + userId + "/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getFriendCheckins(userId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckinsWithParams() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        String userId = "userId1";
        CheckinField[] fields = new CheckinField[] {
                CheckinField.comments_created,
                CheckinField.location_longitude
        };
        String spotId = "spotId1";
        String sinceId = "sinceId1";
        double latitude = 123.456;
        double longitude = 789.321;
        ResultsDirection resultsDirection = ResultsDirection.recent;
        int count = 123;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("center", "123.456,789.321");
        map.put("fields", "comments.created,location.longitude");
        map.put("spotId", spotId);
        map.put("sinceId", sinceId);
        map.put("resultsDirection", resultsDirection.toString());
        map.put("count", String.valueOf(count));
        mixiContainer.send("/checkins/" + userId + "/@self", map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetCheckinsParams params = new GetCheckinsParams();
        params.setCenter(latitude, longitude);
        params.setCount(count);
        params.setFields(fields);
        params.setResultsDirection(resultsDirection);
        params.setSinceId(sinceId);
        params.setSpotId(spotId);
        target.getFriendCheckins(userId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetGroupCheckins() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        String groupId = "groupId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/@me/" + groupId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getGroupCheckins(groupId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetGroupCheckinsWithParams() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        String groupId = "groupId1";
        CheckinField[] fields = new CheckinField[] {
                CheckinField.comments_created,
                CheckinField.location_longitude
        };
        String spotId = "spotId1";
        String sinceId = "sinceId1";
        double latitude = 123.456;
        double longitude = 789.321;
        ResultsDirection resultsDirection = ResultsDirection.recent;
        int count = 123;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("center", "123.456,789.321");
        map.put("fields", "comments.created,location.longitude");
        map.put("spotId", spotId);
        map.put("sinceId", sinceId);
        map.put("resultsDirection", resultsDirection.toString());
        map.put("count", String.valueOf(count));
        mixiContainer.send("/checkins/@me/" + groupId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetCheckinsParams params = new GetCheckinsParams();
        params.setCenter(latitude, longitude);
        params.setCount(count);
        params.setFields(fields);
        params.setResultsDirection(resultsDirection);
        params.setSinceId(sinceId);
        params.setSpotId(spotId);
        target.getGroupCheckins(groupId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsCheckins() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/@me/@friends", handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getFriendsCheckins(handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendsCheckinsWithParams() throws Exception {
        GetCheckinsCallbackHandler handler = new GetCheckinsCallbackHandler(new MockContext());
        CheckinField[] fields = new CheckinField[] {
                CheckinField.comments_created,
                CheckinField.location_longitude
        };
        String spotId = "spotId1";
        String sinceId = "sinceId1";
        double latitude = 123.456;
        double longitude = 789.321;
        ResultsDirection resultsDirection = ResultsDirection.recent;
        int count = 123;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("center", "123.456,789.321");
        map.put("fields", "comments.created,location.longitude");
        map.put("spotId", spotId);
        map.put("sinceId", sinceId);
        map.put("resultsDirection", resultsDirection.toString());
        map.put("count", String.valueOf(count));
        mixiContainer.send("/checkins/@me/@friends", map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetCheckinsParams params = new GetCheckinsParams();
        params.setCenter(latitude, longitude);
        params.setCount(count);
        params.setFields(fields);
        params.setResultsDirection(resultsDirection);
        params.setSinceId(sinceId);
        params.setSpotId(spotId);
        target.getFriendsCheckins(params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyCheckin() throws Exception {
        GetCheckinCallbackHandler handler = new GetCheckinCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/@me/@self/" + checkinId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getMyCheckin(checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyCheckinWithFields() throws Exception {
        GetCheckinCallbackHandler handler = new GetCheckinCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        CheckinField[] fields = new CheckinField[] {
                CheckinField.comments_created,
                CheckinField.location_longitude
        };
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "comments.created,location.longitude");
        mixiContainer.send("/checkins/@me/@self/" + checkinId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getMyCheckin(checkinId, fields, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckin() throws Exception {
        GetCheckinCallbackHandler handler = new GetCheckinCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/" + userId + "/@self/" + checkinId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getFriendCheckin(userId, checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckinWithFields() throws Exception {
        GetCheckinCallbackHandler handler = new GetCheckinCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        CheckinField[] fields = new CheckinField[] {
                CheckinField.comments_created,
                CheckinField.location_longitude
        };
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "comments.created,location.longitude");
        mixiContainer.send("/checkins/" + userId + "/@self/" + checkinId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getFriendCheckin(userId, checkinId, fields, handler);
        
        AndroidMock.verify(mixiContainer);
    }
}
