package com.example.maytheforcebewith_diogosequeira.Fragments;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerViewCharacters;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerItemClickListener;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerViewAdapter;
import com.example.maytheforcebewith_diogosequeira.Utils.CharactersList;
import com.example.maytheforcebewith_diogosequeira.newTryRetrofit.CharacterItem;
import com.example.maytheforcebewith_diogosequeira.newTryRetrofit.CharacterRecycler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private static final String URL_DATA = "https://swapi.co/api/people";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CharacterItem> characterArrayList = new ArrayList<>();
    private boolean loaded;


    CharactersList peopleClass = new CharactersList();
    private ArrayList<CharacterRecycler> arrayOfpeople = new ArrayList<>();


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.mrecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerViewAdapter(arrayOfpeople);

        recyclerView.setLayoutManager(layoutManager);

        if(!loaded){
            loadRecyclerViewData();
            loaded = true;
        }


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
                                fragmentTransaction5.addToBackStack(null);
                                CharacterPersonalPage uniqueCharacter = new CharacterPersonalPage();
                                Bundle bundle = new Bundle();
                                bundle.putString("Titulo", characterArrayList.get(position).getName());
                                bundle.putString("birth", characterArrayList.get(position).getBirthyear());
                                bundle.putString("eyecolor", characterArrayList.get(position).getEyeColor());
                                bundle.putString("gender", characterArrayList.get(position).getGender());
                                bundle.putString("hair", characterArrayList.get(position).getHairColor());
                                bundle.putString("height", characterArrayList.get(position).getHeight());
                                bundle.putString("homeworld", characterArrayList.get(position).getHomeWorld());
                                bundle.putString("mass", characterArrayList.get(position).getMass());
                                bundle.putString("skin", characterArrayList.get(position).getSkinColor());
                                uniqueCharacter.setArguments(bundle);
                                fragmentTransaction5.replace(R.id.main_container, uniqueCharacter);
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

    //fetch the data

    private void loadRecyclerViewData(){

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray array = jsonObject.getJSONArray("results");
                            System.out.println(array.length() + "AQUI");

                            for(int i = 0; i < array.length(); i++){
                                JSONObject o = array.getJSONObject(i);

                                CharacterItem characterItem = new CharacterItem(
                                        o.getString("name"),o.getString("birth_year"),o.getString("eye_color"),o.getString("gender"),o.getString("hair_color"),o.getString("mass")
                                ,o.getString("height"),o.getString("skin_color"),o.getString("homeworld"));

                                characterArrayList.add(characterItem);
                                arrayOfpeople.add(new CharacterRecycler(o.getString("name")));

                                recyclerView.setAdapter(adapter);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
