package com.example.restapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restapi.R;
import com.example.restapi.model.Item;

import java.util.List;

import butterknife.BindView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemHolder> {


    List<Item> itemList;

    public ItemListAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.a_item, parent, false);
        return new ItemHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private Context context;


        TextView itemCategoty;

        TextView itemName;

        TextView itemPrice;


        public ItemHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
           itemName = itemView.findViewById(R.id.tv_itemName_itemAdapter);
           itemPrice = itemView.findViewById(R.id.tv_itemPrice_itemAdapter);
           itemCategoty = itemView.findViewById(R.id.tv_itemCate_itemAdapter);
        }

        public void bind(Item item) {
            itemCategoty.setText(item.getCategory().getType());
itemPrice.setText(String.valueOf(item.getPrice()));
            itemName.setText(item.getName());
        }
    }
}
