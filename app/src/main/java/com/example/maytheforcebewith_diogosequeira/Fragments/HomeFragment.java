package com.example.maytheforcebewith_diogosequeira.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.maytheforcebewith_diogosequeira.R;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class HomeFragment extends Fragment implements View.OnClickListener {

    Button character, favourites;

    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        character = v.findViewById(R.id.button1);
        favourites = v.findViewById(R.id.button2);

        character.setOnClickListener(this);
        favourites.setOnClickListener(this);



        return v;

    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.button1:

                if(isOnline()){

                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.replace(R.id.main_container, new ListFragment());
                    fragmentTransaction.commit();

                } else {

                    Toast.makeText(getContext(), "Please enable Internet access", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button2:
                Toast.makeText(getContext(), "Implementing...", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();

            return (exitValue == 0);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }



}
