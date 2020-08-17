package com.nextgenlabs.shareitscreen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.transition.CircularPropagation;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.nextgenlabs.shareitscreen.Adapter.Adapter;
import com.ogaclejapan.arclayout.ArcLayout;

import java.util.List;

public class SendingActivity extends AppCompatActivity {

    Button cardView;
    CardView one,three,four,five;
    WifiManager mWifiManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.backgroundBar));
        window.setNavigationBarColor(ContextCompat.getColor(this,R.color.backgroundBar));


        mWifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        registerReceiver(mWifiScanReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mWifiManager.startScan();

        cardView = findViewById(R.id.visibility_Button);
        one = findViewById(R.id.one);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(one.getVisibility() == View.INVISIBLE) {
                    one.setVisibility(View.VISIBLE);
                    three.setVisibility(View.VISIBLE);
                    four.setVisibility(View.VISIBLE);
                    five.setVisibility(View.VISIBLE);
                    Toast.makeText(SendingActivity.this,"icon ",Toast.LENGTH_SHORT).show();
                }else {
                    one.setVisibility(View.INVISIBLE);
                    three.setVisibility(View.INVISIBLE);
                    four.setVisibility(View.INVISIBLE);
                    five.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                List<ScanResult> mScanResults = mWifiManager.getScanResults();
                // add your logic here

            }
        }
    };
}