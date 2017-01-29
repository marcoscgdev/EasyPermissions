package com.marcoscg.easypermissionssample;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.marcoscg.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    private String[] perms = {EasyPermissions.WRITE_EXTERNAL_STORAGE, EasyPermissions.ACCESS_FINE_LOCATION};
    Button mRequestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRequestButton = (Button) findViewById(R.id.requestButton);
        mRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyPermissions.requestPermissions(MainActivity.this, perms, 0);
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < permissions.length; i++) {
            String permission = permissions[i];
            int grantResult = grantResults[i];
            if (permission.equals(EasyPermissions.WRITE_EXTERNAL_STORAGE)) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    ((TextView) findViewById(R.id.externalStorage)).setText("WRITE_EXTERNAL_STORAGE Granted.");
                }
            }
            if (permission.equals(EasyPermissions.ACCESS_FINE_LOCATION)) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    ((TextView) findViewById(R.id.location)).setText("ACCESS_FINE_LOCATION Granted.");
                }
            }
        }
    }
}
