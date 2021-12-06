package edu.cis.ibcs_app.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import edu.cis.ibcs_app.Models.Request;
import edu.cis.ibcs_app.Models.SimpleClient;
import edu.cis.ibcs_app.R;
import edu.cis.ibcs_app.Utils.CISConstants;

public class KitchenActivity extends AppCompatActivity
{
    EditText itemnameInput;
    EditText itempriceInput;
    EditText itemtypeInput;
    EditText itemdesInput;
    EditText itemiDInput;
    EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        itemnameInput = (EditText) findViewById(R.id.itemName);
        itemdesInput = (EditText) findViewById(R.id.itemDes);
        itemtypeInput = (EditText) findViewById(R.id.itemType);
        itemiDInput = (EditText) findViewById(R.id.itemID);
        itempriceInput = (EditText) findViewById(R.id.itemPrice);
        passwordInput = (EditText) findViewById(R.id.inputPassword);
    }

    public void addMenuItem(View v)
    {
        try
        {
            if (!passwordInput.getText().toString().equals("cishkadmin"))
            {
                Toast messageToUser = Toast.makeText(this, "Access Denied, Try Again", Toast.LENGTH_LONG);
                messageToUser.show();
                Intent nextScreen = new Intent(getBaseContext(), MainActivity.class);
                startActivity(nextScreen);
            }
            String itemNameInput = itemnameInput.getText().toString();
            String itemDescriptionInput = itemdesInput.getText().toString();
            String itemIDInput = itemiDInput.getText().toString();
            String itemTypeInput = itemtypeInput.getText().toString();
            String itemPriceInput = itempriceInput.getText().toString();
            Request addUserRequest = new Request(CISConstants.ADD_MENU_ITEM);
            addUserRequest.addParam(CISConstants.ITEM_NAME_PARAM, itemNameInput);
            addUserRequest.addParam(CISConstants.DESC_PARAM, itemDescriptionInput);
            addUserRequest.addParam(CISConstants.ITEM_ID_PARAM, itemIDInput);
            addUserRequest.addParam(CISConstants.ITEM_TYPE_PARAM, itemTypeInput);
            addUserRequest.addParam(CISConstants.PRICE_PARAM, itemPriceInput);
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
}