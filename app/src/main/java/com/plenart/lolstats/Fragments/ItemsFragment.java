package com.plenart.lolstats.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.plenart.lolstats.API.ServiceAPI;
import com.plenart.lolstats.Adapters.RecyclerItemsAdapter;
import com.plenart.lolstats.LOLPOJO.Items.Item;
import com.plenart.lolstats.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemsFragment extends Fragment {

    private RecyclerView recyclerItems;
    private RecyclerItemsAdapter adapter;

    private Call<List<Item>> apiCall;

    public static ItemsFragment newInstance() {
        ItemsFragment fragment = new ItemsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerItems= view.findViewById(R.id.recyclerItems);
        recyclerItems.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new RecyclerItemsAdapter();
        recyclerItems.setAdapter(adapter);

        setupApiCall();

    }

    private void setupApiCall() {
        apiCall = ServiceAPI.getApiInterface().getItems();

        apiCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(response.isSuccessful() && response.body()!= null){
                    if(response.body().size() == 0){
                        showToast("no results on items api call");
                    }
                    else{
                        adapter.addItems(response.body());
                        for(Item item : response.body()){
                            System.out.println(item.getName());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.d("TAG","Kod api poziva items");
                showToast("Unable to make items api call " + t.getMessage());
            }
        });

    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }


}
