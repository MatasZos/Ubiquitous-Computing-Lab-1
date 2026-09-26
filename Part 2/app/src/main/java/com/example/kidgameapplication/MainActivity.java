package com.example.kidgameapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int SecretNumber;
    int numberofGuesses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SecretNumber = (int) (Math.random() * 30)+1;
        numberofGuesses = 0;

    }


    public void guessNumber(View view){

        EditText guess = (EditText)findViewById(R.id.guessInput);
        TextView result = (TextView) findViewById(R.id.result);
        TextView count = (TextView)findViewById(R.id.counter);


        int userGuess = Integer.parseInt(guess.getText().toString());
        numberofGuesses++;

        if (userGuess == SecretNumber){
            result.setText("Correct answer");
        }
        else if (userGuess < SecretNumber){
            result.setText("Higher!");
        }

        else if(userGuess > SecretNumber){
            result.setText("Lower!");
        }

        count.setText("Number of guesses is:" + numberofGuesses);

    }

    public void playAgain(View view){
        SecretNumber = (int) (Math.random() *30)+1;
        numberofGuesses = 0;

        EditText guess = (EditText) findViewById(R.id.guessInput);
        TextView result = (TextView) findViewById(R.id.result);
        TextView count = (TextView) findViewById(R.id.counter);


        guess.setText("");
        result.setText("");
        count.setText("Number of Guesses: 0");


    }
}