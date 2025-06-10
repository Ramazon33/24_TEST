package com.example.pdfviewerapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookAdapter.OnBookClickListener {

    private List<String> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = new ArrayList<>();
        books.add("book1.pdf");
        books.add("book2.pdf");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BookAdapter adapter = new BookAdapter(books, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBookClick(String fileName) {
        Intent intent = new Intent(this, PdfViewActivity.class);
        intent.putExtra(PdfViewActivity.EXTRA_FILE_NAME, fileName);
        startActivity(intent);
    }
}
