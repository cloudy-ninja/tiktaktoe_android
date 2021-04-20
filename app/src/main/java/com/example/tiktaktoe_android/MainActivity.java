package com.example.tiktaktoe_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] gameStatus = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    int activePlayer = 0;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        Log.d("Hello", Integer.toString(gameStatus[tappedCounter]));
        if(gameStatus[tappedCounter] ==  2) {
            gameStatus[tappedCounter] = activePlayer;
            if(activePlayer == 0) {
                counter.setImageResource(R.drawable.circle);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.cross);
                activePlayer = 0;
            }

            for(int[] winningPosition: winningPositions) {

                if(gameStatus[winningPosition[0]] == gameStatus[winningPosition[1]] && gameStatus[winningPosition[1]] == gameStatus[winningPosition[2]] && gameStatus[winningPosition[0]] != 2) {
                    String winner;
                    if(activePlayer == 0) {
                        winner = "cross";
                    } else {
                        winner = "circle";
                    }
                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_LONG).show();
                }
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}