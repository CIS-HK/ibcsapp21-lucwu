package edu.cis.ibcs_app.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cis.ibcs_app.Models.SimpleClient;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import edu.cis.ibcs_app.Models.Request;
import edu.cis.ibcs_app.Models.SimpleClient;
import edu.cis.ibcs_app.R;
import edu.cis.ibcs_app.Utils.CISConstants;
import java.io.IOException;
import java.util.*;

public class AllMenuItems extends AppCompatActivity {
    RecyclerView menuView;

    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<String> itemPrice = new ArrayList<>();
    ArrayList<String> itemDes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_menu_items);
        menuView = findViewById(R.id.menuView);

        Request addUserRequest = new Request(CISConstants.GET_MENU);
        try
        {
            String resultFromServer = SimpleClient.makeRequest(CISConstants.HOST, addUserRequest);
            String[] splitString = resultFromServer.split("'");
            for (int index = 1; index <= splitString.length; index++)
            {
                if (index % 8 == 2)
                {
                    itemNames.add(splitString[index]);
                }
                if (index % 8 == 3)
                {
                    itemDes.add(splitString[index]);
                }
                if (index % 8 == 4)
                {
                    itemPrice.add(splitString[index]);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        CISMenuAdapter menuAdapter = new CISMenuAdapter(itemNames, itemPrice, itemDes);
        menuView.setAdapter(menuAdapter);
        menuView.setLayoutManager(new LinearLayoutManager(this));
    }

}