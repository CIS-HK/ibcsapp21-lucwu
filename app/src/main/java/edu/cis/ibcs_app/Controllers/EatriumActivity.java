package edu.cis.ibcs_app.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.cis.ibcs_app.Models.Request;
import edu.cis.ibcs_app.Models.SimpleClient;
import edu.cis.ibcs_app.R;
import edu.cis.ibcs_app.Utils.CISConstants;
import java.util.*;

public class EatriumActivity extends AppCompatActivity {
    EditText userInput;
    EditText idInput;
    EditText yearInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eatrium);

        userInput = (EditText) findViewById(R.id.Namex);
        idInput = (EditText) findViewById(R.id.IDx);
        yearInput = (EditText) findViewById(R.id.Yearx);


    }

    public void pingTheServer(View v)
    {
        try
        {
            Request request = new Request("ping");
            String result = SimpleClient.makeRequest(CISConstants.HOST, request);
            System.out.println("result from server for ping command: " + result);

        }
        catch (Exception err)
        {
            err.printStackTrace();
        }
    }


    public void addUser(View v)
    {
        try
        {
            String userNameInput = userInput.getText().toString();
            String userIDInput = idInput.getText().toString();
            String userYearInput = yearInput.getText().toString();
            Request addUserRequest = new Request(CISConstants.CREATE_USER);
            addUserRequest.addParam(CISConstants.USER_NAME_PARAM, userNameInput);
            addUserRequest.addParam(CISConstants.USER_ID_PARAM, userIDInput);
            addUserRequest.addParam(CISConstants.YEAR_LEVEL_PARAM, userYearInput);
            String resultFromServer = SimpleClient.makeRequest(CISConstants.HOST, addUserRequest);
            Toast messageToUser = Toast.makeText(this, "Message from Eatrium: " + resultFromServer, Toast.LENGTH_LONG);
            messageToUser.show();
        }
        catch (Exception err)
        {
            Toast messageToUser = Toast.makeText(this, "Error" + err.toString(), Toast.LENGTH_LONG);
            messageToUser.show();
        }
    }

    public void goToMain(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), MainActivity.class);
        startActivity(nextScreen);
    }

    public void goToOrders(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), OrderActivity.class);
        startActivity(nextScreen);
    }


}