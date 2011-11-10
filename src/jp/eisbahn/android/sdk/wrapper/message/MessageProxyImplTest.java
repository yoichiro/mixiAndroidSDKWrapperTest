package jp.eisbahn.android.sdk.wrapper.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.eisbahn.android.sdk.wrapper.Utils;
import jp.eisbahn.android.sdk.wrapper.common.CallbackAdapter;
import jp.eisbahn.android.sdk.wrapper.common.GetIdCallbackHandler;
import jp.eisbahn.android.sdk.wrapper.util.DateUtils;
import jp.mixi.android.sdk.HttpMethod;
import jp.mixi.android.sdk.MixiContainer;

import org.json.JSONArray;
import org.json.JSONObject;

import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class MessageProxyImplTest extends AbstractTest {

    public void testGetReceivedMessages() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@inbox", handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.getReceivedMessages(handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("sender", handler.getRelatedUserType());
    }

    public void testGetReceivedMessagesWithParams() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        Map<String, String> map = new HashMap<String, String>();
        map.put("startIndex", "1");
        map.put("count", "2");
        map.put("fields",
                "id,title,body,timeSent,status,sender.displayName,sender.profileUrl,sender.thumbnailUrl");
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        map.put("updatedSince", DateUtils.convertDate(updatedSince));
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@inbox", map, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        GetMessagesParams params = new GetMessagesParams();
        params.setStartIndex(1);
        params.setCount(2);
        params.setFields(new Field[] {
                Field.id,
                Field.title,
                Field.body,
                Field.timeSent,
                Field.status,
                Field.displayName,
                Field.profileUrl,
                Field.thumbnailUrl
        });
        params.setUpdatedSince(updatedSince);
        target.getReceivedMessages(params, handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("sender", handler.getRelatedUserType());
    }

    public void testGetReceivedMessage() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        String messageId = "messageId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@inbox/" + messageId, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.getReceivedMessage(messageId, handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("sender", handler.getRelatedUserType());
    }

    public void testGetReceivedMessageWithParams() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        String messageId = "messageId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields",
                "id,title,body,timeSent,status,sender.displayName,sender.profileUrl,sender.thumbnailUrl");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@inbox/" + messageId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        GetMessagesParams params = new GetMessagesParams();
        params.setFields(new Field[] {
                Field.id,
                Field.title,
                Field.body,
                Field.timeSent,
                Field.status,
                Field.displayName,
                Field.profileUrl,
                Field.thumbnailUrl
        });
        target.getReceivedMessage(messageId, params, handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("sender", handler.getRelatedUserType());
    }

    public void testGetSentMessages() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@outbox", handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.getSentMessages(handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("recipient", handler.getRelatedUserType());
    }

    public void testGetSentMessagesWithParams() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        Map<String, String> map = new HashMap<String, String>();
        map.put("startIndex", "1");
        map.put("count", "2");
        map.put("fields",
                "id,title,body,timeSent,status,recipient.displayName,recipient.profileUrl,recipient.thumbnailUrl");
        Date updatedSince = Utils.createDate(2011, 8, 21, 17, 21, 34);
        map.put("updatedSince", DateUtils.convertDate(updatedSince));
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@outbox", map, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        GetMessagesParams params = new GetMessagesParams();
        params.setStartIndex(1);
        params.setCount(2);
        params.setFields(new Field[] {
                Field.id,
                Field.title,
                Field.body,
                Field.timeSent,
                Field.status,
                Field.displayName,
                Field.profileUrl,
                Field.thumbnailUrl
        });
        params.setUpdatedSince(updatedSince);
        target.getSentMessages(params, handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("recipient", handler.getRelatedUserType());
    }

    public void testGetSentMessage() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        String messageId = "messageId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@outbox/" + messageId, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.getSentMessage(messageId, handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("recipient", handler.getRelatedUserType());
    }

    public void testGetSentMessageWithParams() throws Exception {
        GetMessagesCallbackHandler handler = new GetMessagesCallbackHandler(new MockContext());
        String messageId = "messageId1";
        Map<String, String> map = new HashMap<String, String>();
        map.put("fields",
                "id,title,body,timeSent,status,recipient.displayName,recipient.profileUrl,recipient.thumbnailUrl");
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@outbox/" + messageId, map, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        GetMessagesParams params = new GetMessagesParams();
        params.setFields(new Field[] {
                Field.id,
                Field.title,
                Field.body,
                Field.timeSent,
                Field.status,
                Field.displayName,
                Field.profileUrl,
                Field.thumbnailUrl
        });
        target.getSentMessage(messageId, params, handler);
        
        AndroidMock.verify(mixiContainer);
        assertEquals("recipient", handler.getRelatedUserType());
    }
    
    public void testSendMessage() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String body = "body1";
        String recipient = "recipient1";
        
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("body", body);
        JSONArray array = new JSONArray();
        array.put(recipient);
        json.put("recipients", array);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/messages/@me/@self/@outbox"), eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.sendMessage(title, body, recipient, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testReplyMessage() throws Exception {
        GetIdCallbackHandler handler = new GetIdCallbackHandler(new MockContext());
        String title = "title1";
        String body = "body1";
        String inReplyTo = "inReplyTo1";
        
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("body", body);
        json.put("inReplyTo", inReplyTo);
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send(AndroidMock.eq("/messages/@me/@self/@outbox"), eqJSONObject(json),
                AndroidMock.same(handler));
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.replyMessage(title, body, inReplyTo, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteReceivedMessage() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String messageId = "messageId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@self/@inbox/" + messageId, HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.deleteReceivedMessage(messageId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

    public void testDeleteSentMessage() throws Exception {
        CallbackAdapter handler = new CallbackAdapter(new MockContext());
        String messageId = "messageId1";
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/messages/@me/@self/@outbox/" + messageId, HttpMethod.DELETE, handler);
        AndroidMock.replay(mixiContainer);
        
        MessageProxyImpl target = new MessageProxyImpl(mixiContainer);
        target.deleteSentMessage(messageId, handler);
        
        AndroidMock.verify(mixiContainer);
    }

}
