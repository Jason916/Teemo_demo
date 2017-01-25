package com.example.jasonxu.mobiletester.activity;


import android.content.Intent;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.jasonxu.mobiletester.BuildConfig;
import com.example.jasonxu.mobiletester.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jasonxu on 16/3/5.
 * Email: 573654699@qq.com
 **/
//@RunWith(RobolectricGradleTestRunner.class)
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SettingsActivityTest {

    private SettingsActivity settingsActivity;
    private LinearLayout about;
    private LinearLayout mailSettings;
    private LinearLayout layGoBack;

    @Before
    public void setUp() {
        settingsActivity = Robolectric.setupActivity(SettingsActivity.class);
        layGoBack = (LinearLayout) settingsActivity.findViewById(R.id.lay_go_back);
        mailSettings = (LinearLayout) settingsActivity.findViewById(R.id.mail_settings);
        about = (LinearLayout) settingsActivity.findViewById(R.id.about);
    }

    @Test
    public void testActivity() {
        SettingsActivity settingsActivity = Robolectric.setupActivity(SettingsActivity.class);
        assertNotNull(settingsActivity);
        assertEquals(settingsActivity.getTitle(), "MobileTester");
    }

    /**
     * Test CheckBox
     */
    @Test
    public void testCheckBox() {
        CheckBox chkFloat = (CheckBox) settingsActivity.findViewById(R.id.floating);
        CheckBox chkAutoStop = (CheckBox) settingsActivity.findViewById(R.id.auto_stop);
        CheckBox chkRoot = (CheckBox) settingsActivity.findViewById(R.id.is_root);
        //checkbox enable
        assertTrue(chkFloat.isEnabled());
        assertTrue(chkAutoStop.isEnabled());
        assertTrue(chkRoot.isEnabled());
        //checkbox checkable
        chkFloat.setChecked(true);
        assertTrue(chkFloat.isChecked());
        chkFloat.setChecked(false);
        assertTrue(!chkFloat.isChecked());
        chkAutoStop.setChecked(true);
        assertTrue(chkAutoStop.isChecked());
        chkAutoStop.setChecked(false);
        assertTrue(!chkAutoStop.isChecked());
        chkRoot.setChecked(true);
        assertTrue(chkRoot.isChecked());
        chkRoot.setChecked(false);
        assertTrue(!chkRoot.isChecked());
    }

    /**
     * Test Click to NextActivity
     */
    @Test
    public void testNextActivity() {
        layGoBack.performClick();
        Intent expectedIntent = new Intent(settingsActivity, MainPageActivity.class);
        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();
//        System.out.println(expectedIntent);
//        System.out.println(actualIntent);
        // activity intent
        assertEquals(String.valueOf(expectedIntent),String.valueOf(actualIntent));
        mailSettings.performClick();
        Intent mailSettingExpectedIntent = new Intent(settingsActivity, MailSettingsActivity.class);
        Intent mailSettingActualIntent = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(String.valueOf(mailSettingExpectedIntent), String.valueOf(mailSettingActualIntent));
        about.performClick();
        Intent aboutExpectedIntent = new Intent(settingsActivity, AboutActivity.class);
        Intent aboutActualIntent = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(String.valueOf(aboutExpectedIntent), String.valueOf(aboutActualIntent));
    }

}
