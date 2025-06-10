package com.example.pdfviewerapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.io.InputStream;

public class PdfViewActivity extends AppCompatActivity {

    public static final String EXTRA_FILE_NAME = "fileName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        String fileName = getIntent().getStringExtra(EXTRA_FILE_NAME);

        PDFView pdfView = findViewById(R.id.pdfView);
        try {
            InputStream input = getResources().openRawResource(getResources().getIdentifier(fileName.replace(".pdf", ""), "raw", getPackageName()));
            pdfView.fromStream(input).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
