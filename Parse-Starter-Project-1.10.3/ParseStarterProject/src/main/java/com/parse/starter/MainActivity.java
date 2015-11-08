/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.ParsePush;

import java.util.LinkedList;


public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      //Parse.initialize(this, "tl7nv5D5MmXNV1h3qxLfNOjQp5EHa8d13KYFzsF6", "VPqX9BorF997Z7Kis6X2p5wdXQDetJe4OcNZgFhU");
    ParseInstallation.getCurrentInstallation().saveInBackground();
    ParsePush.subscribeInBackground("Giants");
    ParsePush.subscribeInBackground("rshah");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

   public void onBroadcast(View view){
       LinkedList<String> channels = new LinkedList<String>();
       //channels.add("Giants");
       channels.add("msamant");
       ParsePush push = new ParsePush();
       push.setChannels(channels); // Notice we use setChannels not setChannel
       push.setMessage("The Giants won against the Mets 2-3.");
       push.sendInBackground();
    }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
