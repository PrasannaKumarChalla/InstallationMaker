package com.example.s521942.constellationmaker;

import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.s521942.constellationmaker.Drawing.DrawView;
import com.example.s521942.constellationmaker.Drawing.MakeFragment;
import com.example.s521942.constellationmaker.Viewer.DrawingsFragment;
import com.example.s521942.constellationmaker.Viewer.ViewerFragment;


public class MainActivity extends Activity implements MakeFragment.OnFragmentInteractionListener,DrawingsFragment.OnFragmentInteractionListener {
    ActionBar.Tab tab1;
    ActionBar.Tab tab2;
    ActionBar.Tab tab3;
    DrawView drawView;
    MakeFragment makeFragment=new MakeFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getActionBar();
        //drawView=(DrawView)findViewById(R.id.DrawV);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        tab1 = actionBar.newTab().setText("Make")
                .setTabListener(new TabListener<MakeFragment>(this, "Make", MakeFragment.class));
        actionBar.addTab(tab1);

        tab2 = actionBar.newTab()
                .setText("DrawingsList")
                .setTabListener(new TabListener<DrawingsFragment>(this, "Images", DrawingsFragment.class));
        actionBar.addTab(tab2);
        tab3 = actionBar.newTab()
                .setText("Viewer")
                .setTabListener(new TabListener<ViewerFragment>(this, "Viewer", ViewerFragment.class));
        actionBar.addTab(tab3);
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

 //   @Override
    public void clear(View v) {
        drawView=new DrawView(this);
        drawView.clearCanvas();
    }

    @Override
    public void onFragmentInteraction(String id) {

    }
}
