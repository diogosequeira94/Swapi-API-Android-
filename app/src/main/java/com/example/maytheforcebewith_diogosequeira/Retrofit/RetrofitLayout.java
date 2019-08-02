package com.example.maytheforcebewith_diogosequeira.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.rest.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitLayout extends AppCompatActivity {

    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("People");
        setContentView(R.layout.activity_retrofit_layout);

        edSearch = (EditText) findViewById(R.id.edSearch);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnSearch = (Button) findViewById(R.id.btnSearch);

    }

    public void btnSearch_onClick(View v)
    {

        searchPeople(edSearch.getText().toString());
    }

    private void getPerson(){


    }

    private void searchPeople(String tagword)
    {

        Call<CharacterResults> call = APIClient.get().searchPeople(tagword);

        call.enqueue(new Callback<CharacterResults>()
        {
            @Override
            public void onFailure(Call<CharacterResults> call, Throwable t)
            {
                txtResult.setText("An error ocurred: " + t.toString());
                edSearch.setText("");
            }

            @Override
            public void onResponse(Call<CharacterResults> call, Response<CharacterResults> response)
            {


                Log.d("APIPlug", "Successfully response fetched" );
                edSearch.setText("");
                CharacterResults people = response.body();

                if(people.results.size() > 0)
                    txtResult.setText(people.results.get(0).toString());
                else
                    txtResult.setText("Your request was not found!");

            }
        });
    }
}
