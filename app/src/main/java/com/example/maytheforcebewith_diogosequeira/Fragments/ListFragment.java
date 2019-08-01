package com.example.maytheforcebewith_diogosequeira.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.PeopleItem;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerItemClickListener;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerViewAdapter;
import com.example.maytheforcebewith_diogosequeira.Utils.PeopleList;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        final PeopleList peopleClass = new PeopleList();

        final ArrayList<PeopleItem> arrayOfpeople = peopleClass.giveArray();
        recyclerView = view.findViewById(R.id.mrecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerViewAdapter(arrayOfpeople);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                PeopleItem peopleItem = peopleClass.getDisplayPeople().get(position);

                                FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
                                fragmentTransaction5.addToBackStack(null);
                                PeoplePersonal item = new PeoplePersonal();
                                Bundle bundle = new Bundle();
                                bundle.putString("Titulo", peopleItem.getName());
                                //  saco.putString("Descricao", exampleItem.getmDescricao());
                                item.setArguments(bundle);
                                fragmentTransaction5.replace(R.id.main_container, item);
                                fragmentTransaction5.commit();


                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );









        return view;
    }

/*
    public void initComponents(){

        peopleList = new PeopleList();
        recyclerView = recyclerView.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerViewAdapter(peopleList.giveArray());
        recyclerView.setAdapter(adapter);
    }
*/
    //OnCli


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
