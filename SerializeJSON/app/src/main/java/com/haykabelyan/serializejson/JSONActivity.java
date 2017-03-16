package com.haykabelyan.serializejson;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONActivity extends AppCompatActivity {

    Fragment fragment1, fragment2;
    RecyclerView recyclerView1, recyclerView2;
    String date;
    TextView textView;
    ProgressDialog PD;
    String url = "http://myandroid.000webhostapp.com/read_horoscope.php";
    String[][] data1, data2;
    String[] signs, horoscopes;
    LinearLayoutManager mLayoutManager1, mLayoutManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        textView = (TextView) findViewById(R.id.textViewDate);
        fragment1 = getFragmentManager().findFragmentById(R.id.f1);
        fragment2 = getFragmentManager().findFragmentById(R.id.f2);
        recyclerView1 = (RecyclerView) fragment1.getView().findViewById(R.id.rv1);
        recyclerView2 = (RecyclerView) fragment2.getView().findViewById(R.id.rv2);
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView1.setLayoutManager(mLayoutManager1);
        recyclerView2.setLayoutManager(mLayoutManager2);
        PD = new ProgressDialog(this);

        signs = new String[]{"Խոյ", "Ցուլ", "Երկվորյակներ", "Խեցգետին", "Առյուծ", "Կույս", "Կշեռք",
                "Կարիճ", "Աղեղնավոր", "Այծեղջյուր", "Ջրհոս", "Ձկներ"};
        horoscopes = new String[12];
        PD.setMessage("Loading");
        PD.setCancelable(false);
        PD.show();
        JsonObjectRequest jreq0 = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int success = response.getInt("success");
                            if (success == 1) {
                                JSONArray ja = response.getJSONArray("aforizmner");
                                for (int i = ja.length() - 1; i >= 0; i--) {
                                    JSONObject jobj = ja.getJSONObject(i);
                                    date = jobj.getString("date");
                                    horoscopes[0] = jobj.getString("xoy");
                                    horoscopes[1] = jobj.getString("cul");
                                    horoscopes[2] = jobj.getString("erkvoryakner");
                                    horoscopes[3] = jobj.getString("xecgetin");
                                    horoscopes[4] = jobj.getString("aryuc");
                                    horoscopes[5] = jobj.getString("kuys");
                                    horoscopes[6] = jobj.getString("ksherq");
                                    horoscopes[7] = jobj.getString("karich");
                                    horoscopes[8] = jobj.getString("agheghnavor");
                                    horoscopes[9] = jobj.getString("ayceghjyur");
                                    horoscopes[10] = jobj.getString("jrhos");
                                    horoscopes[11] = jobj.getString("dzkner");
                                    if (date.length() > 4) {
                                        PD.dismiss();
                                        i = -1;
                                        textView.setText(textView.getText() + date);
                                        data1 = new String[6][2];
                                        data2 = new String[6][2];
                                        for (int k = 0; k < 6; k++) {
                                            data1[k][0] = signs[k];
                                            data1[k][1] = horoscopes[k];
                                            data2[k][0] = signs[6 + k];
                                            data2[k][1] = horoscopes[6 + k];
                                        }

                                        RecyclerAdapter adapter1 = new RecyclerAdapter(data1);
                                        RecyclerAdapter adapter2 = new RecyclerAdapter(data2);
                                        recyclerView1.setAdapter(adapter1);
                                        recyclerView2.setAdapter(adapter2);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            PD.dismiss();
                            Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                PD.dismiss();
                Toast.makeText(getApplicationContext(), "Internet connection error", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        MyApplication.getInstance().addToReqQueue(jreq0);
    }
}