package edu.cis.ibcs_app.Controllers;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import edu.cis.ibcs_app.Models.Request;
import edu.cis.ibcs_app.Models.SimpleClient;
import edu.cis.ibcs_app.Utils.CISConstants;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import edu.cis.ibcs_app.R;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
    }

    public void goToEatrium(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), EatriumActivity.class);
        startActivity(nextScreen);
    }

    public void goToKitchen(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), KitchenActivity.class);
        startActivity(nextScreen);
    }
}