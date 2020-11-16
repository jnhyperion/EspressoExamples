package com.vgrec.espressoexamples;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UIAutomatorTest {

    @Test
    public void PT_1_Test() throws Throwable {
        Context context = InstrumentationRegistry.getContext();
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        String pkgName = InstrumentationRegistry.getTargetContext().getPackageName();
        final Intent intent = InstrumentationRegistry.getTargetContext().getPackageManager()
                .getLaunchIntentForPackage(pkgName);
        context.startActivity(intent);
        UiDevice uiDevice = UiDevice.getInstance(instrumentation);
        uiDevice.wait(Until.hasObject(By.pkg(pkgName).depth(0)),
                60000);
        BySelector bySelector = By.res("com.vgrec.espressoexamples:id/type_text_button");
        BySelector nextBtn = By.text("NEXT");
        uiDevice.wait(Until.hasObject(bySelector), 3000);
        uiDevice.findObject(bySelector).click();
        uiDevice.wait(Until.hasObject(nextBtn), 3000);
    }

}
