package com.example.antrian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    TextView txt_antri;
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
        Toast.makeText(getActivity() , "Next" , Toast.LENGTH_SHORT).show();
    }
    public void onListenerRefresh(){
        Toast.makeText(getActivity() , "Refresh" , Toast.LENGTH_SHORT).show();
    }
}