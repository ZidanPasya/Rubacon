package com.example.projekakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class SearchBar extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private ArrayList<Book> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(BookData.getListData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardViewBookAdapter cardViewBookAdapter = new CardViewBookAdapter(this, this);
        cardViewBookAdapter.setBookList(list);
        recyclerView.setAdapter(cardViewBookAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, BookDetails.class);
        startActivity(intent);
    }
}