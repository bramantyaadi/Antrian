package com.example.antrian;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antrian.contans.contans;
import com.example.antrian.models.Result_last_call;
import com.example.antrian.models.Result_next_antrian;
import com.example.antrian.models.Result_wait_done;
import com.example.antrian.services.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    TextView txt_antri , txt_wait , txt_done;
    CardView cv_next , cv_refresh;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt_antri = view.findViewById(R.id.txt_antrian);
        cv_next = view.findViewById(R.id.card_next);
        cv_refresh = view.findViewById(R.id.card_refresh);
        txt_done = view.findViewById(R.id.txt_done);
        txt_wait = view.findViewById(R.id.txt_wait);
        WaitAndDone();
        LastCall();


        cv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerNext();
            }
        });

        cv_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerRefresh();
            }
        });
    }

    public void onListenerNext(){
//        Toast.makeText(getActivity() , "Next" , Toast.LENGTH_SHORT).show();
        final ProgressDialog progres = new ProgressDialog(getActivity());
        progres.setMessage("Please Wait......");
        progres.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(contans.URL_API)
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIService apiService = retrofit.create(APIService.class);

        final Call<Result_next_antrian> result_nextAntrian = apiService.NextAntrian();
        System.out.println("CekData1 " + result_nextAntrian.toString());
        result_nextAntrian.enqueue(new Callback<Result_next_antrian>() {
            @Override
            public void onResponse(Call<Result_next_antrian> call, Response<Result_next_antrian> response) {
                progres.dismiss();
                Result_next_antrian result_next = response.body();
                txt_antri.setText(result_next.getNomor_antrian());
                WaitAndDone();
            }

            @Override
            public void onFailure(Call<Result_next_antrian> call, Throwable t) {
//                System.out.println("ERROR NEXT : " + t);
                progres.dismiss();
                Toast.makeText(getActivity() , "Maaf Nomor Antrian Selanjutnya Sudah Habis" , Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onListenerRefresh(){
//        Toast.makeText(getActivity() , "Refresh" , Toast.LENGTH_SHORT).show();
        LastCall();
        WaitAndDone();
    }
    public void LastCall(){
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please Wait.....");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(contans.URL_API)
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIService apiService = retrofit.create(APIService.class);

        final Call<Result_last_call> result_last_callCall = apiService.lastCall();
        result_last_callCall.enqueue(new Callback<Result_last_call>() {
            @Override
            public void onResponse(Call<Result_last_call> call, Response<Result_last_call> response) {
                progressDialog.dismiss();
                Result_last_call result_last_call = response.body();
                txt_antri.setText(result_last_call.getNomor_antrian());;
            }

            @Override
            public void onFailure(Call<Result_last_call> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
    public void WaitAndDone(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(contans.URL_API)
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIService apiService = retrofit.create(APIService.class);

        final Call<Result_wait_done> result_wait_doneCall = apiService.WaitAndDone();
        result_wait_doneCall.enqueue(new Callback<Result_wait_done>() {
            @Override
            public void onResponse(Call<Result_wait_done> call, Response<Result_wait_done> response) {
                Result_wait_done result_wait_done = response.body();
                txt_done.setText(result_wait_done.getDone());
                txt_wait.setText(result_wait_done.getWait());
            }

            @Override
            public void onFailure(Call<Result_wait_done> call, Throwable t) {

            }
        });
    }
}