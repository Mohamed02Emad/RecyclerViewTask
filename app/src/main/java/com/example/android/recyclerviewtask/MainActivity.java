package com.example.android.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.recyclerviewtask.RecyclerView.Adapter;
import com.example.android.recyclerviewtask.RecyclerView.DataClass;
import com.example.android.recyclerviewtask.RecyclerView.RecyclerInterFace;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    MediaPlayer mediaPlayer;
    ArrayList<DataClass> arrayList;
    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.click);
        arrayList= new ArrayList<DataClass>();
        setUpArrayList();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        adapter= new Adapter(arrayList);
        adapter.setClick(new RecyclerInterFace() {
            @Override
            public void OnCkick(int position) {
                mediaPlayer.start();
                Intent i = new Intent(getApplicationContext(),Info.class)
                        .putExtra("title",arrayList.get(position).getTitle())
                        .putExtra("content",arrayList.get(position).getContent())
                        .putExtra("img",arrayList.get(position).getImg()+"");
                startActivity(i);
            }

            @Override
            public boolean OnLongClick(int position) {
                ConstraintLayout constraintLayout = findViewById(R.id.parentt);
                Snackbar.make(constraintLayout,arrayList.get(position).getTitle(),Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });


        recyclerView=findViewById(R.id.recycler_from_xml);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

    }

    private void setUpArrayList() {


            arrayList.add(new DataClass("That Man","حسبي الله ونعم الوكيل",R.drawable.ragel));
            arrayList.add(new DataClass("Mo Salah","انا جبت جون ",R.drawable.mosalah));
            arrayList.add(new DataClass("شفيق","يارب اخلص",R.drawable.squid));


            arrayList.add(new DataClass("CAT Reloaded","good job",R.drawable.catreloaded));
            arrayList.add(new DataClass("بكار","مش لاقي رشيدة ",R.drawable.bkar));
            arrayList.add(new DataClass("Abu trika","اذكر الله",R.drawable.abutrika));



            arrayList.add(new DataClass("shikabala","يارب ",R.drawable.shikabala));
             arrayList.add(new DataClass("Google","congrats",R.drawable.google));
            arrayList.add(new DataClass("هنيدي","فينك ",R.drawable.mohamedhenedi));
            arrayList.add(new DataClass("Spongebob","hahahaha",R.drawable.spongebob));



    }


}