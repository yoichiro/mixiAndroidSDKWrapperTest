package jp.eisbahn.android.sdk.wrapper.people.image;

import jp.eisbahn.android.sdk.wrapper.AbstractTest;
import jp.mixi.android.sdk.MixiContainer;
import android.test.mock.MockContext;

import com.google.android.testing.mocking.AndroidMock;

public class ProfileImageProxyImplTest extends AbstractTest {
    
    public void testGetMyProfileImages() throws Exception {
        GetProfileImagesCallbackHandler handler = new GetProfileImagesCallbackHandler(new MockContext());
        
        MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
        mixiContainer.send("/people/images/@me/@self", handler);
        AndroidMock.replay(mixiContainer);
        
        ProfileImageProxyImpl target = new ProfileImageProxyImpl(mixiContainer);
        target.getMyProfileImages(handler);
        
        AndroidMock.verify(mixiContainer);
    }
    
}
