/*
 * Copyright (C) 2012-2015 The Android Money Manager Ex Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.moneymanagerex.android.espresso;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.money.manager.ex.R;
import com.money.manager.ex.home.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso tests for the Main Activity, using JUnit 3 and instrumentation test case.
 * This in NOT NEEDED as JUnit 4 tests can run in the emulator equally well.
 * Displayed here only as a sample.
 * Created by Alen Siljak on 24/09/2015.
 */
public class MainActivityJ3Tests
        extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity testObject;
//    private UiTestHelpers helper;

    public MainActivityJ3Tests() {
        super(MainActivity.class);

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

//        solo = new Solo(getInstrumentation(), getActivity());
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

        this.testObject = getActivity();
//        this.helper = new UiTestHelpers(solo);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        this.testObject = null;
    }

    public void testCreation() {
        assertNotNull(testObject);

        onView(withId(R.id.linearLayoutWelcome))
            .check(matches(isDisplayed()));
    }

    public void testWelcomeViewDisplayed() {
        onView(withText("Welcome to MoneyManagerEx!"))
            .check(matches(isDisplayed()));
    }

    public void testAccountsListDisplayed() {
        onView(withText("Bank Accounts"))
                .check(matches(isDisplayed()));
    }

}
