package com.plenart.lolstats.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.plenart.lolstats.API.ServiceAPI;
import com.plenart.lolstats.Adapters.RecyclerRunesAdapter;
import com.plenart.lolstats.LOLPOJO.Runes.Rune;
import com.plenart.lolstats.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RunesFragment extends Fragment {

    private RecyclerView recyclerRunes;
    private RecyclerRunesAdapter adapter;

    private Call<List<Rune>> apiCall;

    public static RunesFragment newInstance() {
        RunesFragment fragment = new RunesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_runes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerRunes = view.findViewById(R.id.recyclerRunes);
        recyclerRunes.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new RecyclerRunesAdapter();
        recyclerRunes.setAdapter(adapter);

        setUpApiCall();
    }

    private void setUpApiCall() {
        apiCall = ServiceAPI.getApiInterface().getRunes();

        apiCall.enqueue(new Callback<List<Rune>>() {
            @Override
            public void onResponse(Call<List<Rune>> call, Response<List<Rune>> response) {
                if(response.isSuccessful() && response.body() != null){
                    if(response.body().size() == 0){
                        showToast("no results on runes api call");
                    }
                    else{
                        adapter.addRunes(response.body());
                        for(Rune rune : response.body()){
                            System.out.println(rune.getName());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Rune>> call, Throwable t) {
                Log.d("TAG","Kod api poziva runes");
                showToast("Unable to make runes api call " + t.getMessage());
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

}