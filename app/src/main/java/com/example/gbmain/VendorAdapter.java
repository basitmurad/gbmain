package com.example.gbmain;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbmain.Vendor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the shop name of the vendor to be deleted
                String shopName = vendor.getOwnerShopName();

                Log.d("shop" ,shopName);
                // Call the method to delete the vendor from Firebase
                deleteVendorFromFirebase(shopName);
            }
        });
    }

    // Method to delete vendor from Firebase
    private void deleteVendorFromFirebase(String shopName) {
        // Reference to the Firebase database
        DatabaseReference vendorRef = FirebaseDatabase.getInstance().getReference("VendorsDetail");

        // Query to find the vendor by shop name
        vendorRef.orderByChild("ownerShopName").equalTo(shopName).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Loop through the results and delete the matching vendor
                    for (DataSnapshot vendorSnapshot : dataSnapshot.getChildren()) {
                        vendorSnapshot.getRef().removeValue();  // Delete the vendor
                    }
                } else {
                    // Vendor not found
                    Log.d("DeleteVendor", "Vendor with shop name " + shopName + " not found.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("DeleteVendor", "Error deleting vendor: " + databaseError.getMessage());
            }
        });
    }


    @Override
    public int getItemCount() {
        return vendorList.size();
    }

    public static class VendorViewHolder extends RecyclerView.ViewHolder {
        TextView shopName, ownerName, contact, email;

        Button deleteButton;
        public VendorViewHolder(@NonNull View itemView) {
            super(itemView);
            shopName = itemView.findViewById(R.id.shopName);
            ownerName = itemView.findViewById(R.id.ownerName);
            contact = itemView.findViewById(R.id.contact);
            email = itemView.findViewById(R.id.email);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }


}
