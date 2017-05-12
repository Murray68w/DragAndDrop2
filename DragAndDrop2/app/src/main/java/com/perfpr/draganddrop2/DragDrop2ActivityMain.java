package com.perfpr.draganddrop2;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class DragDrop2ActivityMain extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_save_week:
                    mTextMessage.setText(R.string.save_week);
                    fragment = new TimeFragment();
                    replaceFragment(fragment);
                    break;
                case R.id.navigation_new_week:
                    mTextMessage.setText(R.string.title_new);
                    return true;
                case R.id.navigation_previous:
                    mTextMessage.setText(R.string.title_past);
                    return true;
            }
            return false;
        }

        public void replaceFragment(Fragment someFragment) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.content, someFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop2_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
