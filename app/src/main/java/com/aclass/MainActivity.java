package com.aclass;
import com.aclass.adapter.TermAdapter;
import com.aclass.adapter.TermAdapter.OnItemClickListener;
import com.aclass.beans.ImgAndTxtEntity;
import com.aclass.beans.TextEntity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Object> termList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTermList();
        recyclerView = findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TermAdapter termAdapter = new TermAdapter(termList);
        recyclerView.setAdapter(termAdapter);
        termAdapter.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(View view , int position){
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                //intent.putExtra("search_name",termList.get(position));
                startActivity(intent);
            }
        });

    }
    public void initTermList() {
        ImgAndTxtEntity ie1 = new ImgAndTxtEntity();
        ie1.imageId = R.mipmap.ic_launcher_round;
        ie1.text = "MQTT";
        termList.add(ie1);

        ImgAndTxtEntity ie2 = new ImgAndTxtEntity();
        ie2.imageId = R.mipmap.ic_launcher_round;
        ie2.text = "MVVM";
        termList.add(ie2);

        ImgAndTxtEntity ie3 = new ImgAndTxtEntity();
        ie3.imageId = R.mipmap.ic_launcher_round;
        ie3.text = "MQTT";
        termList.add(ie3);

        ImgAndTxtEntity ie4 = new ImgAndTxtEntity();
        ie4.imageId = R.mipmap.ic_launcher_round;
        ie4.text = "MQTT";
        termList.add(ie4);

        ImgAndTxtEntity ie5 = new ImgAndTxtEntity();
        ie5.imageId = R.mipmap.ic_launcher_round;
        ie5.text = "MQTT";
        termList.add(ie5);

        TextEntity te3 = new TextEntity();
        te3.text = "asdfasdfasdf\n11111";
        termList.add(te3);

        TextEntity te1 = new TextEntity();
        te1.text = "asf\nadsfasdf";
        termList.add(te1);

        TextEntity te2 = new TextEntity();
        te2.text = "asdf\nfffffff";
        termList.add(te2);
    }
}
