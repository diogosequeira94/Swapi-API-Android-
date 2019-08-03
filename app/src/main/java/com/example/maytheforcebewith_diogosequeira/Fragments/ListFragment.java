package com.example.maytheforcebewith_diogosequeira.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerItemClickListener;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerViewAdapter;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterResults;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterItem;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterRecycler;
import com.example.maytheforcebewith_diogosequeira.Rest.SwapiAPIClient;
import com.example.maytheforcebewith_diogosequeira.Rest.SwapiAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CharacterItem> characterArrayList = new ArrayList<>();
    private boolean isLoaded;
    private CharacterPersonalPage uniqueCharacter = new CharacterPersonalPage();
    private ArrayList<CharacterRecycler> recyclerViewCharacters = new ArrayList<>();

    //New Part
    private EditText searchField;
    private Button submit;
    private ImageView backButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.mrecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerViewAdapter(recyclerViewCharacters);

        recyclerView.setLayoutManager(layoutManager);

        initComponents(view);

        if(!isLoaded){
            loadRecyclerViewData();
            isLoaded = true;
        }


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                               loadCharacterInfo(position);

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadDataSearchBox(searchField.getText().toString());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFragment();
            }
        });





        return view;
    }

    private void initComponents(View view){
        searchField = view.findViewById(R.id.editSearchBox);
        submit = view.findViewById(R.id.searchButton);
        backButton = view.findViewById(R.id.imageBack);
    }


    private void loadRecyclerViewData(){

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading List");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                SwapiAPI.getBaseUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {

                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray array = jsonObject.getJSONArray("results");

                            for(int i = 0; i < array.length(); i++){
                                JSONObject o = array.getJSONObject(i);

                                CharacterItem characterItem = new CharacterItem(
                                        o.getString("name"),o.getString("birth_year"),o.getString("eye_color"),o.getString("gender"),o.getString("hair_color"),o.getString("mass")
                                        ,o.getString("height"),o.getString("skin_color"),o.getString("homeworld"));


                                recyclerViewCharacters.add(new CharacterRecycler(R.drawable.r2, o.getString("name")));

                                characterArrayList.add(characterItem);

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


    //Load specific Character from RecyclerView into fragment

    private synchronized void loadCharacterInfo(final int position){


        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Character");
        progressDialog.show();


        final Bundle bundle = new Bundle();

        //Fetching data for each position and passing it to next fragment

        String url = SwapiAPI.getBaseUrl() + (position + 1);


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();

                        try {

                            String name = response.getString("name");
                            String birthYear = response.getString("birth_year");
                            String eyeColor = response.getString("eye_color");
                            String gender = response.getString("gender");
                            String hair = response.getString("hair_color");
                            String height = response.getString("height");
                            String homeworld = response.getString("homeworld");
                            String mass = response.getString("mass");
                            String skin = response.getString("skin_color");


                            bundle.putString("Titulo", name);
                            bundle.putString("birth", birthYear);
                            bundle.putString("eyecolor", eyeColor);
                            bundle.putString("gender", gender);
                            bundle.putString("hair", hair);
                            bundle.putString("height", height);
                            bundle.putString("homeworld", homeworld);
                            bundle.putString("mass", mass);
                            bundle.putString("skin", skin);
                            uniqueCharacter.setArguments(bundle);

                            /*Need to call fragmentTransaction here, otherwise it will change fragments before fetching the data,
                                 need to figure out solution
                             */


                            nextFragment();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error");
            }
        });

        RequestQueue mQueue = Volley.newRequestQueue(getContext());
        mQueue.add(request);


    }

    //New method to get data from searchBox using Retrofit instead

    private void loadDataSearchBox(String character) {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Character");
        progressDialog.show();

       final Bundle bundle = new Bundle();

        Call<CharacterResults> call = SwapiAPIClient.get().searchPeople(character);

        call.enqueue(new Callback<CharacterResults>()
        {
            @Override
            public void onFailure(Call<CharacterResults> call, Throwable t)
            {
                searchField.setText("");
            }

            @Override
            public void onResponse(Call<CharacterResults> call, retrofit2.Response<CharacterResults> response)
            {
                progressDialog.dismiss();

                Log.d("APIPlaceHolder", "Successfully response fetched" );
                searchField.setText("");

                CharacterResults people = response.body();
                String textResult;
                String name;

                if(people.results.size() > 0){

                    textResult = people.results.get(0).toString();
                    name = people.results.get(0).getName();
                    System.out.println(textResult);

                    bundle.putString("details", textResult);
                    bundle.putString("newname", name);
                    uniqueCharacter.setArguments(bundle);
                    nextFragment();
                }


                else {

                    Toast.makeText(getContext(),"Your request was not found!", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

    private void nextFragment(){
        FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction5.addToBackStack(null);
        fragmentTransaction5.replace(R.id.main_container, uniqueCharacter);
        fragmentTransaction5.commit();


    }

    private void homeFragment(){

        FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction5.addToBackStack(null);
        fragmentTransaction5.replace(R.id.main_container, new HomeFragment());
        fragmentTransaction5.commit();

    }


    }



