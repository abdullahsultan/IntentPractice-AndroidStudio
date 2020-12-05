package com.example.testing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

 ///////////////////////////////////////// Global Variables/////////////////////////////////////
    String res;
    TextView ans;
    int x = 0;
    int y = 0;
    int z = 0;
    EditText no1;
    EditText no2;
/////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, MainActivity2.class);

///////////////////////////// Checking previous instance activity////////////////////////////////////
        if(savedInstanceState != null) {
            savedInstanceState.getInt("No1");
            savedInstanceState.getInt("No2");
            savedInstanceState.getInt("Ans");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////// Getting Ids///////////////////////////////////////////////////////
        no1 = findViewById(R.id.no1);
        no2 = findViewById(R.id.no2);
        ans = findViewById(R.id.result);
        Button add = findViewById(R.id.btn_add);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////// Onclick add Button ///////////////////////////////////////////////
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ONClick", "Clicked");

                if(!no1.getText().toString().isEmpty() && !no2.getText().toString().isEmpty() && no1.getText().toString() != null && no2.getText().toString() != null)
                {
                    x = Integer.parseInt(no1.getText().toString());
                    y = Integer.parseInt(no2.getText().toString());
                    z = x + y;
                    res = Integer.toString(z);
                    ans.setText(res);
                    startActivity(intent);
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS},1);
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED)
                    {
                        Toast.makeText(MainActivity.this, "PermissionNotGranted", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "PermissionGranted", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Venom", "onStartCalled");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Venom", "onPauseCalled");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Venom", "onStopCalled");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Venom", "onCResumeCalled");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Venom", "onDestroyCalled");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("No1",x);
        outState.putInt("No2",y);
        outState.putInt("Ans",z);
    }
}