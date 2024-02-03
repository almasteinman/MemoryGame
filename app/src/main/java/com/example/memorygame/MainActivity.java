package com.example.memorygame;

import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    int card1;
    int counterPlayer1 = 0;
    int counterPlayer2 = 0;
    String turn = "counterPlayer1";
    ImageView[] imageViewsArray = new ImageView[16];
    Integer[] drawablesArray = new Integer[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillImageViewsArray();
        fillDrawablesArray();
        shuffleDrawablesArray();
    }

    // First array - Image views
    private void fillImageViewsArray() {
        for (int i = 0; i < 16; i++) {
            int imageViewId = getResources().getIdentifier("imageview_card" + (i + 1), "id", getPackageName());
            imageViewsArray[i] = findViewById(imageViewId);
        }
    }

    // Second array - Drawables (Images) identifiers
    private void fillDrawablesArray() {
        for (int i = 0; i < 16; i++) {
            // Fill in the drawable's identifier
            int drawableId = getResources().getIdentifier("card" + ((i % 8) + 1), "drawable", getPackageName());
            drawablesArray[i] = drawableId;
        }
    }

    // Second array - Shuffle the array
    private void shuffleDrawablesArray() {
        List<Integer> drawablesList = Arrays.asList(drawablesArray); // Convert array to list
        Collections.shuffle(drawablesList); // Shuffle list
        drawablesList.toArray(drawablesArray); // Convert list to array
    }

    public void openCard(View view) throws InterruptedException {
        ImageView imageView = (ImageView) view;

        int id_of_imageview_in_array = 0;

        for (int i = 0; i < 16; i++) {
            if (imageViewsArray[i] == imageView) {
                id_of_imageview_in_array = i;
                break;
            }
        }

        imageView.setImageResource(drawablesArray[id_of_imageview_in_array]);
        count++;
        turnEnd1(imageView);
    }

    public void closeCard(int card1, ImageView view) {
        ImageView card1Closed = findViewById(card1);
        card1Closed.setImageResource(R.drawable.blue_card);
        ImageView card2Closed = findViewById(view.getId());
        card2Closed.setImageResource(R.drawable.blue_card);
    }

    public void turnEnd1(ImageView imageView) throws InterruptedException {
        if (count == 1) {
            Log.e("XXXXX", "count = " + count);
            card1 = imageView.getId();
            return;
        }
        if (count == 2) {
            Log.e("XXXXX", "count = " + count);
            ImageView imageViewCard1 = findViewById(card1);
            Drawable image1 = imageViewCard1.getDrawable();
            Drawable image2 = imageView.getDrawable();
            if (image1.getConstantState().equals(image2.getConstantState())) {
                if (turn.equals("counterPlayer1")) {
                    counterPlayer1++;
                    String p1 = String.valueOf(counterPlayer1);
                    TextView tv1 = findViewById(R.id.textView1);
                    tv1.setText(p1.toString());
                    Log.e("XXXXX", "counterPlayer1 = " + counterPlayer1);
                    turn = "counterPlayer2";
                    Log.e("XXXXX", "counterPlayer2 turn:");
                } else {
                    counterPlayer2++;
                    String p2 = String.valueOf(counterPlayer2);
                    TextView tv2 = findViewById(R.id.textView2);
                    tv2.setText(p2.toString());
                    Log.e("XXXXX", "counterPlayer2 = " + counterPlayer2);
                    turn = "counterPlayer1";
                    Log.e("XXXXX", "counterPlayer1 turn:");
                }
            } else {
                final Handler handler = new Handler();
                handler.postDelayed(() -> closeCard(card1, imageView), 400);
                if (turn.equals("counterPlayer1")) {
                    turn = "counterPlayer2";
                    Log.e("XXXXX", "counterPlayer2 turn:");
                } else {
                    turn = "counterPlayer1";
                    Log.e("XXXXX", "counterPlayer1 turn:");
                }

            }
            count = 0;
        }

    }
}
