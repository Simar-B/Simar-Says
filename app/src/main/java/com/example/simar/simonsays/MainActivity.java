package com.example.simar.simonsays;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final private Handler mhandler = new Handler();


    Button[] colours;
    final int[] count = {0};
    TextView Final;
    public int score;
    final ArrayList<Integer> pattern = new ArrayList<>();
    final ArrayList<Integer> guess = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button green =  findViewById(R.id.Green);
        Button blue =  findViewById(R.id.Blue);
        Button red =  findViewById(R.id.Red);
        Button purple =  findViewById(R.id.purple);
        Final = findViewById(R.id.Score);
        colours = new Button[]{green, blue, red, purple};

        green.setOnClickListener(this);
        blue.setOnClickListener(this);
        red.setOnClickListener(this);
        purple.setOnClickListener(this);
        score = 0;
        showPattern(colours,score);
    }

    public void showPattern(final Button[] colours, int score) {
        String result = Integer.toString(score);
        Final.setText("score: " + result);
        for (int j = 1; j < score+2; j++) {
            mhandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Random rand = new Random();
                    Integer x = rand.nextInt(4);
                    final int[] b = {x};
                    pattern.add(x);
                    //colours[x].setBackgroundColor(Color.BLACK);
                    switch (x){
                        case 0:
                            colours[x].setBackgroundColor(getColor(R.color.lightGreen));
                            break;
                        case 1:
                            colours[x].setBackgroundColor(getColor(R.color.lightBlue));
                            break;
                        case 2:
                            colours[x].setBackgroundColor(getColor(R.color.lightRed));
                            break;
                        case 3:
                            colours[x].setBackgroundColor(getColor(R.color.lightPurple));
                            break;
                        default:
                            break;
                    }
                    mhandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            switch (b[0]){
                                case 0:
                                    colours[b[0]].setBackgroundColor(getColor(R.color.green));
                                    break;
                                case 1:
                                    colours[b[0]].setBackgroundColor(getColor(R.color.blue));
                                    break;
                                case 2:
                                    colours[b[0]].setBackgroundColor(getColor(R.color.red));
                                    break;
                                case 3:
                                    colours[b[0]].setBackgroundColor(getColor(R.color.purple));
                                    break;
                                default:
                                    break;
                            }
                        }
                    },1000);
                }
            },1250 * j);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Green:
                guess.add(0);
                count[0]++;
                if (pattern.equals(guess)){
                    pattern.clear();
                    guess.clear();
                    score++;
                    showPattern(colours,score);
                }
                else if(count[0] >= score + 1){
                    Final.setText("You're score is "+ score);

                }
                break;
            case R.id.Blue:
                guess.add(1);
                count[0]++;
                if (pattern.equals(guess)){
                    pattern.clear();
                    guess.clear();
                    score++;
                    showPattern(colours,score);

                }
                else if(count[0] >= score + 1){
                    Final.setText("You're score is "+ score);

                }
                break;
            case R.id.Red:
                guess.add(2);
                count[0]++;
                if (pattern.equals(guess)){
                    pattern.clear();
                    guess.clear();
                    score++;
                    showPattern(colours,score);
                }
                else if(count[0] >= score + 1){
                    Final.setText("You're score is "+ score);

                }
                break;
            case R.id.purple:
                guess.add(3);
                count[0]++;
                if (pattern.equals(guess)){
                    pattern.clear();
                    guess.clear();
                    score++;
                    showPattern(colours,score);
                }
                else if(count[0] >= score + 1){

                }
                break;
        }
    }
}