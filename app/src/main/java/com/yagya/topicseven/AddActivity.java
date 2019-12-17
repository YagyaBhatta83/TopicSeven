package com.yagya.topicseven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddActivity extends AppCompatActivity {
    private EditText etenterword, etentermeaning;
    private Button btnaddword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etenterword=findViewById(R.id.etenterword);
        etentermeaning =findViewById(R.id.etentermeaning);
        btnaddword = findViewById(R.id.btnaddword);

        btnaddword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }
    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE |MODE_APPEND));
            printStream.println(etenterword.getText().toString() + "->" +etentermeaning.getText().toString());
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Log.d("Dictionary app", "Error" +e.toString());
            e.printStackTrace();
        }
    }
}
