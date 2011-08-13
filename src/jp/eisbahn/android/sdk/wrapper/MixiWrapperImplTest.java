package jp.eisbahn.android.sdk.wrapper;

import jp.eisbahn.android.sdk.wrapper.people.PeopleProxyImpl;
import jp.eisbahn.android.sdk.wrapper.photo.PhotoProxyImpl;
import jp.eisbahn.android.sdk.wrapper.request.RequestProxyImpl;
import jp.eisbahn.android.sdk.wrapper.search.SearchProxyImpl;
import jp.eisbahn.android.sdk.wrapper.check.CheckProxyImpl;
import jp.eisbahn.android.sdk.wrapper.groups.GroupsProxyImpl;
import jp.mixi.android.sdk.MixiContainer;

import org.easymock.EasyMock;

public class MixiWrapperImplTest extends AbstractTest {

    public void testSimple() throws Exception {
        MixiContainer container = EasyMock.createMock(MixiContainer.class);
        MixiWrapperImpl target = new MixiWrapperImpl(container);
        assertTrue(target.getPeopleAPI() instanceof PeopleProxyImpl);
        assertTrue(target.getRequestAPI() instanceof RequestProxyImpl);
        assertTrue(target.getPhotoAPI() instanceof PhotoProxyImpl);
        assertTrue(target.getGroupsAPI() instanceof GroupsProxyImpl);
        assertTrue(target.getSearchAPI() instanceof SearchProxyImpl);
        assertTrue(target.getCheckAPI() instanceof CheckProxyImpl);
    }
    
}
