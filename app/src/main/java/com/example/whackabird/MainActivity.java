package com.example.whackabird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.application.whackABird.EXTRA_TEXT";
    public EditText name;
    private Button play_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_game = (Button)findViewById(R.id.btn_new_game);
        name = (EditText)findViewById(R.id.name);

        addListenerOnButton();
    }
    public void addListenerOnButton() {

        play_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=name.getText().toString();
                Toast.makeText(getApplicationContext(),"Hello "+userName, Toast.LENGTH_LONG).show();
                openGameActivity();
            }
        });
    }
    public void openGameActivity() {
        String userName=name.getText().toString();

        Intent intent  = new Intent(this,Game_Activity.class);
        intent.putExtra(EXTRA_TEXT,userName);
        startActivity(intent);
    }
    public String getName(){
        return name.getText().toString();
    }

}
