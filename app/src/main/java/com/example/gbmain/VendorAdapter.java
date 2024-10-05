package com.example.gbmain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbmain.Vendor;

import java.util.List;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.VendorViewHolder> {

    private List<Vendor> vendorList;

    public VendorAdapter(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_item, parent, false);
        return new VendorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int position) {
        Vendor vendor = vendorList.get(position);
        holder.shopName.setText(vendor.getOwnerShopName());
        holder.ownerName.setText(vendor.getOwnerName());
        holder.contact.setText(vendor.getOwnerContact());
        holder.email.setText(vendor.getEmail());
    }

    @Override
    public int getItemCount() {
        return vendorList.size();
    }

    public static class VendorViewHolder extends RecyclerView.ViewHolder {
        TextView shopName, ownerName, contact, email;

        public VendorViewHolder(@NonNull View itemView) {
            super(itemView);
            shopName = itemView.findViewById(R.id.shopName);
            ownerName = itemView.findViewById(R.id.ownerName);
            contact = itemView.findViewById(R.id.contact);
            email = itemView.findViewById(R.id.email);
        }
    }
}
