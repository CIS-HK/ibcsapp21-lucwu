package edu.cis.ibcs_app.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import edu.cis.ibcs_app.Models.Request;
import edu.cis.ibcs_app.Models.SimpleClient;
import edu.cis.ibcs_app.R;
import edu.cis.ibcs_app.Utils.CISConstants;
import java.util.*;

public class OrderActivity extends AppCompatActivity {
    EditText orderIDInput;
    EditText userIDInput;
    EditText itemIDInput;
    EditText orderTypeInput;
    EditText delOrderIDInput;
    EditText delUserIDInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);
        orderIDInput = (EditText) findViewById(R.id.OrderID);
        userIDInput = (EditText) findViewById(R.id.UserID);
        itemIDInput = (EditText) findViewById(R.id.ItemID);
        orderTypeInput = (EditText) findViewById(R.id.OrderType);
        orderIDInput = (EditText) findViewById(R.id.DELorderID);
        userIDInput = (EditText) findViewById(R.id.DELuserID);

    }

    public void placeOrder(View v)
    {
        try
        {
            String order = orderIDInput.getText().toString();
            String user = userIDInput.getText().toString();
            String item = itemIDInput.getText().toString();
            String type = orderTypeInput.getText().toString();
            Request addUserRequest = new Request(CISConstants.PLACE_ORDER);
            addUserRequest.addParam(CISConstants.ORDER_ID_PARAM, order);
            addUserRequest.addParam(CISConstants.ITEM_ID_PARAM, item);
            addUserRequest.addParam(CISConstants.USER_ID_PARAM, user);
            addUserRequest.addParam(CISConstants.ORDER_TYPE_PARAM, type);
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

    public void deleteOrder(View v)
    {
        try
        {
            String orderDel = delOrderIDInput.getText().toString();
            String userDel = delUserIDInput.getText().toString();
            Request addUserRequest = new Request(CISConstants.PLACE_ORDER);
            addUserRequest.addParam(CISConstants.ORDER_ID_PARAM, orderDel);
            addUserRequest.addParam(CISConstants.USER_ID_PARAM, userDel);
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

    public void goToEat(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), EatriumActivity.class);
        startActivity(nextScreen);
    }
    public void goToMenu(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), AllMenuItems.class);
        startActivity(nextScreen);
    }

}