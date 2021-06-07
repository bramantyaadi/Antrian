package com.example.antrian;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antrian.adapter.Rv_antrian;
import com.example.antrian.contans.contans;
import com.example.antrian.models.Item_antrian;
import com.example.antrian.models.Result_rv;
import com.example.antrian.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    ArrayList<Item_antrian> item = new ArrayList<Item_antrian>();
    RecyclerView rv_antrian;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_antrian = view.findViewById(R.id.rvlist);
        loadData();
    }

    public void loadData(){
        final ProgressDialog progres = new ProgressDialog(getActivity());
        progres.setMessage("Please Wait......");
        progres.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(contans.URL_API)
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIService apiService = retrofit.create(APIService.class);

        final Call<Result_rv> result_rvCall = apiService.getAll();
        System.out.println("CekData1 " + result_rvCall.toString());
        result_rvCall.enqueue(new Callback<Result_rv>() {
            @Override
            public void onResponse(Call<Result_rv> call, Response<Result_rv> response) {
                progres.dismiss();
                Result_rv jsonResult = response.body();
//                System.out.println("Cektdata "+response.body().toString());
//                System.out.println("JSON" + jsonResult.toString());
                item = jsonResult.getItems();
                System.out.println("ITEM " + item);
                rv_antrian.setLayoutManager(new LinearLayoutManager(getActivity()));
                Rv_antrian itemAdapter = new Rv_antrian(getActivity());
                rv_antrian.setAdapter(itemAdapter);
                if (item != null){
                    itemAdapter.setListItem(item);
                }
            }

            @Override
            public void onFailure(Call<Result_rv> call, Throwable t) {
                System.out.println("ERROR"+t.toString());
            }
        });

    }
}