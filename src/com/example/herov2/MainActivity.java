package com.example.herov2;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	public String login, password;
	
	private String[] dr;
	private DrawerLayout mDrawerLayout;
	private ListView mListView;
	int n = -1;
	
	MySearch ms;
	MyUser mu;
	MyResume mr;
	MyOffers mo;
	MySelected msl;
	FragmentTransaction fTran;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dr = getResources().getStringArray(R.array.drawer_list);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView = (ListView) findViewById(R.id.left_drawer);
        ms = new MySearch();
        mu = new MyUser();
        mr = new MyResume();
        mo = new MyOffers();
        msl = new MySelected();
        
//        Intent intent = new Intent(MainActivity.this, StartActivity.class);
//       startActivity(intent);
        
        selectItem(1);
        
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, dr));
        mListView.setOnItemClickListener(new DrawerItemClickListener());                      
    }
    
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    
    private void selectItem(int p) {
    	fTran = getFragmentManager().beginTransaction();
    	fTran.setCustomAnimations(R.animator.left, R.animator.right);
    	switch (p) {
    	case 0:
    		if (n != 0) {
    			fTran.replace(R.id.content_frame, ms);
    			n = 0;
    		}
    		break;
    	case 1:
    		if (n != 1) {
    			fTran.replace(R.id.content_frame, mu);
    			n = 1;
    		}
    		break;
    	case 2:
    		if (n != 2) {
    			fTran.replace(R.id.content_frame, mr);
    			n = 2;
    		}
    		break;
    	case 3:
    		if (n != 3) {
    			fTran.replace(R.id.content_frame, mo);
    			n = 3;
    		}
    		break;
    	case 4:
    		if (n != 4) {
    			fTran.replace(R.id.content_frame, msl);
    			n = 4;
    		}
    		break;
    	default:
    		break;
    	}
    	fTran.commit();
		mDrawerLayout.closeDrawer(mListView);   	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
