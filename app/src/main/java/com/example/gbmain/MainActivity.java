package com.example.gbmain;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbmain.Vendor;
import com.example.gbmain.VendorAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VendorAdapter vendorAdapter;
    private List<Vendor> vendorList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        vendorList = new ArrayList<>();
        vendorAdapter = new VendorAdapter(vendorList);
        recyclerView.setAdapter(vendorAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("VendorsDetail");

        fetchVendorData();
    }

    private void fetchVendorData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                vendorList.clear();
                for (DataSnapshot vendorSnapshot : dataSnapshot.getChildren()) {
                    Vendor vendor = vendorSnapshot.getValue(Vendor.class);
                    vendorList.add(vendor);
                }
                vendorAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle possible errors
            }
        });
    }
}
