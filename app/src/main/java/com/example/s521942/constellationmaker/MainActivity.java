package com.example.s521942.constellationmaker;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements MakeFragment.OnFragmentInteractionListener {
    ActionBar.Tab tab1;
    ActionBar.Tab tab2;
    ActionBar.Tab tab3;
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getActionBar();

//        drawView = new DrawView(this);
//        drawView.setBackgroundColor(Color.WHITE);
//        setContentView(drawView);
//        drawView.requestFocus();



        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        tab1 = actionBar.newTab().setText("List")
                .setTabListener(new TabListener<MakeFragment>(this, "Sports", MakeFragment.class));
        actionBar.addTab(tab1);

//        tab2 = actionBar.newTab()
//                .setText("Viewer")
//                .setTabListener(new TabListener<ImageFragment>(this, "Images", ImageFragment.class));
//        actionBar.addTab(tab2);
//        tab3 = actionBar.newTab()
//                .setText("Maker")
//                .setTabListener(new TabListener<Add>(this, "Additions", Add.class));
//        actionBar.addTab(tab3);
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
