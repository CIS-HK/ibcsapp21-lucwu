package edu.cis.ibcs_app.Controllers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cis.ibcs_app.R;

public class CISMenuViewHolder extends RecyclerView.ViewHolder
{
    protected TextView menuItemName;
    protected TextView menuItemDes;
    protected TextView menuItemPrice;

    public CISMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        menuItemName = itemView.findViewById(R.id.MenuItemView);
        menuItemDes = itemView.findViewById(R.id.DesView);
        menuItemPrice = itemView.findViewById(R.id.PriceView);

    }
}
