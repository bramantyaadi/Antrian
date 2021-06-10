package com.example.antrian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.antrian.R;
import com.example.antrian.models.Item_antrian;

import java.util.ArrayList;

public class Rv_antrian extends RecyclerView.Adapter<Rv_antrian.ItemViewHolder> {
    final ArrayList<Item_antrian> listItem = new ArrayList<Item_antrian>();
    private Context context;

    public Rv_antrian(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Rv_antrian.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_antrian_view , parent , false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rv_antrian.ItemViewHolder holder, int position) {
        holder.tvNomor.setText(listItem.get(position).getNomor_antrian());
        holder.tvParent_nomor.setText(listItem.get(position).getNomor_antrian());
        holder.tvJamPanggil.setText(listItem.get(position).getJam_dipanggil());
        holder.tvJamBuat.setText(listItem.get(position).getJam_dibuat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context , listItem.get(position).getNomor_antrian() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setListItem(ArrayList<Item_antrian> items){
        if (items.size() > 0){
            this.listItem.clear();
        }
        this.listItem.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvNomor , tvJamPanggil , tvJamBuat , tvParent_nomor;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvParent_nomor = itemView.findViewById(R.id.nomor_antri_parent);
            tvNomor = itemView.findViewById(R.id.nomor_antrian);
            tvJamBuat = itemView.findViewById(R.id.jam_dibuat);
            tvJamPanggil = itemView.findViewById(R.id.jam_dipanggil);
        }
    }
}
