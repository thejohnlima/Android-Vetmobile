package android.vetmobile.com.vet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeVetActivity extends AppCompatActivity {

    private LinearLayout listItem1;
    private LinearLayout listItem2;
    private LinearLayout listItem3;
    private LinearLayout listItem4;
    private String currentUserLogin = null;
    private FloatingActionButton fab1;
    private boolean isFABOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_vet);

        listItem1 = findViewById(R.id.item1_list_id);
        listItem2 = findViewById(R.id.item2_list_id);
        listItem3 = findViewById(R.id.item3_list_id);
        listItem4 = findViewById(R.id.item4_list_id);

        addActionForListItem1();
        addActionForListItem2();
        addActionForListItem3();
        addActionForListItem4();

        setOrientation();
        setCurrentUserLogin();
        configureFAB();
    }

    private void setOrientation() {
        if (Support.isTablet(getWindowManager())) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    private void addActionForListItem1() {
        listItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something here
            }
        });
    }

    private void addActionForListItem2() {
        listItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something here
            }
        });
    }

    private void addActionForListItem3() {
        listItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something here
            }
        });
    }

    private void addActionForListItem4() {
        listItem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something here
            }
        });
    }

    private void setCurrentUserLogin() {
        Intent intent = this.getIntent();
        Bundle extras = intent.getExtras();
        if (intent != null && extras != null) {
            currentUserLogin = intent.getStringExtra(getResources().getString(R.string.key_current_user));
            if (currentUserLogin == null) {return;}
            User.updateStatusLogged(true, currentUserLogin);
        }
    }

    private void configureFAB() {

        FloatingActionButton fab = findViewById(R.id.homevet_fab_id);
        fab1 = findViewById(R.id.homevet_fab1_id);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFABOpen) {
                    showFABMenu();
                }else {
                    closeFABMenu();
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Do something now", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showFABMenu() {
        isFABOpen = true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_64));
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fab1.animate().translationY(0);
    }

    @Override
    public void onBackPressed() {
        if (!isFABOpen) {
            super.onBackPressed();
        }else {
            closeFABMenu();
        }
    }

}
