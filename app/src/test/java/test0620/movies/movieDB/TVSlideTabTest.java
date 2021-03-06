
package test0620.movies.movieDB;

import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.test.InstrumentationTestCase;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;


import test0620.movies.movieDB.controller.TVSlideTab;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class TVSlideTabTest extends InstrumentationTestCase {

    private static final String FRAGMENT_TAG = "fragment";
    private MainActivity activity;
    private TVSlideTab tvSlideTab;


    /**
     * Adds the fragment to a new blank activity, thereby fully
     * initializing its view.
     */
    @Before
    public void setUp() throws Exception {
        tvSlideTab = new TVSlideTab();
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        FragmentManager manager = activity.getFragmentManager();
        manager.beginTransaction().add(tvSlideTab, FRAGMENT_TAG).commit();
    }

    @Test
    public void testPreconditions() throws Exception {
        assertNotNull("activity is null", activity);
        assertNotNull("DrawerLayout is null", activity.getMDrawerLayout());
        assertNotNull("movieSlideTab is null", tvSlideTab);
        assertNotNull("cant find fragment", activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG));
    }

    @Test
    public void testViews() throws Exception {
        View tvSlideTabRoot = tvSlideTab.getView();
        assertNotNull("tvSlideTab rootView is null", tvSlideTabRoot);
        assertNotNull("tvSlideTab slidingTab is null", tvSlideTabRoot.findViewById(R.id.sliding_tabs));
        ViewPager mViewPager = (ViewPager) tvSlideTabRoot.findViewById(R.id.tvPager);
        int expected = 1;
        assertNotNull("tvSlideTab mViewPager is null", mViewPager);
        assertNotNull("tvSlideTab mViewPager adapter is null", mViewPager.getAdapter());
        assertEquals("mViewPager offScreenLimit is different!", expected, mViewPager.getOffscreenPageLimit());
    }

}
