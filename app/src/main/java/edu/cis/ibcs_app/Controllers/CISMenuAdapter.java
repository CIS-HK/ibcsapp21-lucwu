package edu.cis.ibcs_app.Controllers;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

import edu.cis.ibcs_app.Models.Request;
import edu.cis.ibcs_app.R;
import edu.cis.ibcs_app.Utils.CISConstants;

public class CISMenuAdapter extends RecyclerView.Adapter<CISMenuViewHolder> {

    ArrayList<String> nameData;
    ArrayList<Integer> priceData;
    ArrayList<String> desData;


    public CISMenuAdapter(ArrayList nameData, ArrayList priceData, ArrayList desData)
    {
        this.nameData = nameData;
        this.priceData = priceData;
        this.desData = desData;
    }

    @NonNull
    @Override
    public CISMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View newView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_row_view, parent, false);
        CISMenuViewHolder holder = new CISMenuViewHolder(newView);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull CISMenuViewHolder holder, int position)
    {
        holder.menuItemName.setText(nameData.get(position));
        holder.menuItemDes.setText(desData.get(position));
        holder.menuItemPrice.setText(priceData.get(position));

    }

    @Override
    public int getItemCount() {
        return nameData.size();
    }
}
