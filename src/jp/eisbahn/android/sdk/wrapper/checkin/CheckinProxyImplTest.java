package jp.eisbahn.android.sdk.wrapper.checkin;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.Field;
import jp.eisbahn.android.sdk.wrapper.GetCommentsCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.GetUsersCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.Visibility;
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
    
    public void testCheckin() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        String message = "message1";
        Visibility visibility = Visibility.friends_of_friends;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        JSONObject json = new JSONObject();
        json.put("message", message);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        json.put("privacy", privacy);
        mixiContainer.send(
                AndroidMock.eq("/checkins/" + spotId),
                eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, message, visibility, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCheckinForGroup() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        String message = "message1";
        String groupId = "groupId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        JSONObject json = new JSONObject();
        json.put("message", message);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", Visibility.group.toString());
        privacy.put("group", groupId);
        json.put("privacy", privacy);
        mixiContainer.send(
                AndroidMock.eq("/checkins/" + spotId),
                eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, message, groupId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCheckinWithParams() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        double latitude = 123.456;
        double longitude = 789.123;
        String message = "message1";
        Visibility visibility = Visibility.friends_of_friends;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        JSONObject json = new JSONObject();
        json.put("message", message);
        JSONObject location = new JSONObject();
        location.put("latitude", String.valueOf(latitude));
        location.put("longitude", String.valueOf(longitude));
        json.put("location", location);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        json.put("privacy", privacy);
        mixiContainer.send(
                AndroidMock.eq("/checkins/" + spotId),
                eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, latitude, longitude, message, visibility, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCheckinForGroupWithParams() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        double latitude = 123.456;
        double longitude = 789.123;
        String message = "message1";
        String groupId = "groupId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        JSONObject json = new JSONObject();
        json.put("message", message);
        JSONObject location = new JSONObject();
        location.put("latitude", String.valueOf(latitude));
        location.put("longitude", String.valueOf(longitude));
        json.put("location", location);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", Visibility.group.toString());
        privacy.put("group", groupId);
        json.put("privacy", privacy);
        mixiContainer.send(
                AndroidMock.eq("/checkins/" + spotId),
                eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, latitude, longitude, message, groupId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCheckinWithImage() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        String message = "message1";
        Visibility visibility = Visibility.friends_of_friends;
        byte[] image = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        
        JSONObject params = new JSONObject();
        params.put("message", message);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        params.put("privacy", privacy);
        StringBuilder sb = new StringBuilder();
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"request\"\r\n");
        sb.append("\r\n");
        sb.append(params.toString());
        sb.append("\r\n");
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"photo1\"; filename=\"photo1.jpg\"\r\n");
        sb.append("\r\n");
        byte[] header = sb.toString().getBytes("UTF-8");
        
        byte[] request = new byte[header.length + image.length];
        System.arraycopy(header, 0, request, 0, header.length);
        System.arraycopy(image, 0, request, header.length, image.length);
        ByteArrayInputStream in = new ByteArrayInputStream(request);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/checkins/" + spotId),
                AndroidMock.eq("multipart/form-data; boundary=-mixi_android_sdk_wrapper"),
                eqByteArrayInputStream(in), AndroidMock.eq((long)request.length), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, message, visibility, new ByteArrayInputStream(image), handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCheckinForGroupWithImage() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        String message = "message1";
        String groupId = "groupId1";
        byte[] image = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        
        JSONObject params = new JSONObject();
        params.put("message", message);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", Visibility.group.toString());
        privacy.put("group", groupId);
        params.put("privacy", privacy);
        StringBuilder sb = new StringBuilder();
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"request\"\r\n");
        sb.append("\r\n");
        sb.append(params.toString());
        sb.append("\r\n");
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"photo1\"; filename=\"photo1.jpg\"\r\n");
        sb.append("\r\n");
        byte[] header = sb.toString().getBytes("UTF-8");
        
        byte[] request = new byte[header.length + image.length];
        System.arraycopy(header, 0, request, 0, header.length);
        System.arraycopy(image, 0, request, header.length, image.length);
        ByteArrayInputStream in = new ByteArrayInputStream(request);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/checkins/" + spotId),
                AndroidMock.eq("multipart/form-data; boundary=-mixi_android_sdk_wrapper"),
                eqByteArrayInputStream(in), AndroidMock.eq((long)request.length), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, message, groupId, new ByteArrayInputStream(image), handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCheckinWithParamsAndImage() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        double latitude = 123.456;
        double longitude = 789.123;
        String message = "message1";
        Visibility visibility = Visibility.friends_of_friends;
        byte[] image = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        
        JSONObject params = new JSONObject();
        params.put("message", message);
        JSONObject location = new JSONObject();
        location.put("latitude", String.valueOf(latitude));
        location.put("longitude", String.valueOf(longitude));
        params.put("location", location);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", visibility.toString());
        params.put("privacy", privacy);
        StringBuilder sb = new StringBuilder();
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"request\"\r\n");
        sb.append("\r\n");
        sb.append(params.toString());
        sb.append("\r\n");
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"photo1\"; filename=\"photo1.jpg\"\r\n");
        sb.append("\r\n");
        byte[] header = sb.toString().getBytes("UTF-8");
        
        byte[] request = new byte[header.length + image.length];
        System.arraycopy(header, 0, request, 0, header.length);
        System.arraycopy(image, 0, request, header.length, image.length);
        ByteArrayInputStream in = new ByteArrayInputStream(request);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/checkins/" + spotId),
                AndroidMock.eq("multipart/form-data; boundary=-mixi_android_sdk_wrapper"),
                eqByteArrayInputStream(in), AndroidMock.eq((long)request.length), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, latitude, longitude, message, visibility,
                new ByteArrayInputStream(image), handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testCheckinForGroupWithParamsAndImage() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String spotId = "spotId1";
        double latitude = 123.456;
        double longitude = 789.123;
        String message = "message1";
        String groupId = "groupId1";
        byte[] image = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        
        JSONObject params = new JSONObject();
        params.put("message", message);
        JSONObject location = new JSONObject();
        location.put("latitude", String.valueOf(latitude));
        location.put("longitude", String.valueOf(longitude));
        params.put("location", location);
        JSONObject privacy = new JSONObject();
        privacy.put("visibility", Visibility.group.toString());
        privacy.put("group", groupId);
        params.put("privacy", privacy);
        StringBuilder sb = new StringBuilder();
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"request\"\r\n");
        sb.append("\r\n");
        sb.append(params.toString());
        sb.append("\r\n");
        sb.append("---mixi_android_sdk_wrapper\r\n");
        sb.append("Content-Disposition: form-data; name=\"photo1\"; filename=\"photo1.jpg\"\r\n");
        sb.append("\r\n");
        byte[] header = sb.toString().getBytes("UTF-8");
        
        byte[] request = new byte[header.length + image.length];
        System.arraycopy(header, 0, request, 0, header.length);
        System.arraycopy(image, 0, request, header.length, image.length);
        ByteArrayInputStream in = new ByteArrayInputStream(request);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/checkins/" + spotId),
                AndroidMock.eq("multipart/form-data; boundary=-mixi_android_sdk_wrapper"),
                eqByteArrayInputStream(in), AndroidMock.eq((long)request.length), AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.checkin(spotId, latitude, longitude, message, groupId,
                new ByteArrayInputStream(image), handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testDeleteCheckin() throws Exception {
        CallbackAdapter handler = new GetIdCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/@me/@self/" + checkinId, HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.deleteCheckin(checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testGetMyCheckinComments() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/comments/@me/@self/" + checkinId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getMyCheckinComments(checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyCheckinCommentsWithParams() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        CommentField[] fields = new CommentField[] {
                CommentField.text,
                CommentField.user_profileUrl
        };
        int startIndex = 2;
        int count = 3;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "text,user.profileUrl");
        map.put("startIndex", "2");
        map.put("count", "3");
        mixiContainer.send("/checkins/comments/@me/@self/" + checkinId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetCommentsParams params = new GetCommentsParams();
        params.setFields(fields);
        params.setStartIndex(startIndex);
        params.setCount(count);
        target.getMyCheckinComments(checkinId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckinComments() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/comments/" + userId + "/@self/" + checkinId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getFriendCheckinComments(userId, checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckinCommentsWithParams() throws Exception {
        GetCommentsCallbackHandler handler = new GetCommentsCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        CommentField[] fields = new CommentField[] {
                CommentField.text,
                CommentField.user_profileUrl
        };
        int startIndex = 2;
        int count = 3;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "text,user.profileUrl");
        map.put("startIndex", "2");
        map.put("count", "3");
        mixiContainer.send("/checkins/comments/" + userId + "/@self/" + checkinId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetCommentsParams params = new GetCommentsParams();
        params.setFields(fields);
        params.setStartIndex(startIndex);
        params.setCount(count);
        target.getFriendCheckinComments(userId, checkinId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testPostMyCheckinComment() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        String text = "text1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        JSONObject json = new JSONObject();
        json.put("text", text);
        mixiContainer.send(
                AndroidMock.eq("/checkins/comments/@me/@self/" + checkinId),
                eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.postMyCheckinComment(checkinId, text, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostFriendCheckinComment() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        String text = "text1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        JSONObject json = new JSONObject();
        json.put("text", text);
        mixiContainer.send(
                AndroidMock.eq("/checkins/comments/" + userId + "/@self/" + checkinId),
                eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.postFriendCheckinComment(userId, checkinId, text, handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
    public void testDeleteMyCheckinComment() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String checkinId = "checkinId1";
        String commentId = "commentId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/comments/@me/@self/" + checkinId + "/" + commentId,
                HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.deleteMyCheckinComment(checkinId, commentId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteFriendCheckinComment() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        String commentId = "commentId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/comments/" + userId + "/@self/" + checkinId + "/" + commentId,
                HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.deleteFriendCheckinComment(userId, checkinId, commentId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyCheckinFavorites() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/favorites/@me/@self/" + checkinId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getMyCheckinFavorites(checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetMyCheckinFavoritesWithParams() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String checkinId = "checkinId1";
        Field[] fields = new Field[] {
                Field.profileUrl,
                Field.thumbnailUrl
        };
        int startIndex = 2;
        int count = 3;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "profileUrl,thumbnailUrl");
        map.put("startIndex", "2");
        map.put("count", "3");
        mixiContainer.send("/checkins/favorites/@me/@self/" + checkinId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetFavoritesParams params = new GetFavoritesParams();
        params.setFields(fields);
        params.setStartIndex(startIndex);
        params.setCount(count);
        target.getMyCheckinFavorites(checkinId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckinFavorites() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/favorites/" + userId + "/@self/" + checkinId, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.getFriendCheckinFavorites(userId, checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testGetFriendCheckinFavoritesWithParams() throws Exception {
        GetUsersCallbackHandler handler = new GetUsersCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        Field[] fields = new Field[] {
                Field.profileUrl,
                Field.thumbnailUrl
        };
        int startIndex = 2;
        int count = 3;
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields", "profileUrl,thumbnailUrl");
        map.put("startIndex", "2");
        map.put("count", "3");
        mixiContainer.send("/checkins/favorites/" + userId + "/@self/" + checkinId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        GetFavoritesParams params = new GetFavoritesParams();
        params.setFields(fields);
        params.setStartIndex(startIndex);
        params.setCount(count);
        target.getFriendCheckinFavorites(userId, checkinId, params, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testPostFriendCheckinFavorite() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/favorites/" + userId + "/@self/" + checkinId,
                HttpMethod.POST, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.postFriendCheckinFavorite(userId, checkinId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteMyCheckinFavorite() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String checkinId = "checkinId1";
        String favoriteUserId = "favoriteUserId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/favorites/@me/@self/" + checkinId + "/" + favoriteUserId,
                HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.deleteMyCheckinFavorite(checkinId, favoriteUserId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteFriendCheckinFavorite() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String userId = "userId1";
        String checkinId = "checkinId1";
        String favoriteUserId = "favoriteUserId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/checkins/favorites/" + userId + "/@self/" + checkinId + "/" + favoriteUserId,
                HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        CheckinProxyImpl target = new CheckinProxyImpl(mixiContainer);
        target.deleteFriendCheckinFavorite(userId, checkinId, favoriteUserId, handler);
        
        AndroidMock.verify(mixiContainer);
    }
}
