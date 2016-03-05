package com.example.jasonxu.mobiletester.activity;


import android.widget.Button;
import android.widget.CheckBox;

import com.example.jasonxu.mobiletester.BuildConfig;
import com.example.jasonxu.mobiletester.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

/**
 * Created by jasonxu on 16/3/5.
 * Email: 573654699@qq.com
 **/
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class SettingsActivityTest {

    private SettingsActivity settingsActivity;
    private Button toastBtn;
    @Before
    public void setUp() {
        settingsActivity = Robolectric.setupActivity(SettingsActivity.class);
//        toastBtn = (Button) settingsActivity.findViewById(R.id.btn_toast);

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
}
