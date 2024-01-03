package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int count=0;
    int card1;
    int counterPlayer1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCard1(View view) {
        ImageView cardImageView1 = findViewById(R.id.imageview_card11);
        cardImageView1.setImageResource(R.drawable.card1);
        count++;
        turnEnd(view);

    }
    public void openCard2(View view) {
        ImageView cardImageView2 = findViewById(R.id.imageview_card34);
        cardImageView2.setImageResource(R.drawable.card1);
        count++;
        turnEnd(view);
    }

    public void openCard3(View view) {
        ImageView cardImageView3 = findViewById(R.id.imageview_card42);
        cardImageView3.setImageResource(R.drawable.card2);
        count++;
        turnEnd(view);
    }

    public void openCard4(View view) {
        ImageView cardImageView4 = findViewById(R.id.imageview_card31);
        cardImageView4.setImageResource(R.drawable.card2);
        count++;
        turnEnd(view);
    }

    public void openCard5(View view) {
        ImageView cardImageView5 = findViewById(R.id.imageview_card13);
        cardImageView5.setImageResource(R.drawable.card3);
        count++;
        turnEnd(view);
    }

    public void openCard6(View view) {
        ImageView cardImageView6 = findViewById(R.id.imageview_card22);
        cardImageView6.setImageResource(R.drawable.card3);
        count++;
        turnEnd(view);
    }

    public void openCard7(View view) {
        ImageView cardImageView7 = findViewById(R.id.imageview_card24);
        cardImageView7.setImageResource(R.drawable.card4);
        count++;
        turnEnd(view);
    }

    public void openCard8(View view) {
        ImageView cardImageView8 = findViewById(R.id.imageview_card43);
        cardImageView8.setImageResource(R.drawable.card4);
        count++;
        turnEnd(view);
    }

    public void openCard9(View view) {
        ImageView cardImageView9 = findViewById(R.id.imageview_card23);
        cardImageView9.setImageResource(R.drawable.card5);
        count++;
        turnEnd(view);
    }

    public void openCard10(View view) {
        ImageView cardImageView10 = findViewById(R.id.imageview_card41);
        cardImageView10.setImageResource(R.drawable.card5);
        count++;
        turnEnd(view);
    }

    public void openCard11(View view) {
        ImageView cardImageView11 = findViewById(R.id.imageview_card14);
        cardImageView11.setImageResource(R.drawable.card6);
        count++;
        turnEnd(view);
    }

    public void openCard12(View view) {
        ImageView cardImageView12 = findViewById(R.id.imageview_card33);
        cardImageView12.setImageResource(R.drawable.card6);
        count++;
        turnEnd(view);
    }

    public void openCard13(View view) {
        ImageView cardImageView13 = findViewById(R.id.imageview_card32);
        cardImageView13.setImageResource(R.drawable.card7);
        count++;
        turnEnd(view);
    }

    public void openCard14(View view) {
        ImageView cardImageView14 = findViewById(R.id.imageview_card21);
        cardImageView14.setImageResource(R.drawable.card7);
        count++;
        turnEnd(view);
    }

    public void openCard15(View view) {
        ImageView cardImageView15 = findViewById(R.id.imageview_card12);
        cardImageView15.setImageResource(R.drawable.card8);
        count++;
        turnEnd(view);
    }

    public void openCard16(View view) {
        ImageView cardImageView16 = findViewById(R.id.imageview_card44);
        cardImageView16.setImageResource(R.drawable.card8);
        count++;
        turnEnd(view);
    }


       public void turnEnd(View view){
        //כמה קלפים פתוחים
           //אם פתוח קךף 1 לא קורה כלום
           // אם פתוחים 2 קלפים
           //   בודקים אם יש מאחוריהם את אותה תמונה
           //   אם לא אז הופכים את הקלפים בחזרה
           //אם כן אז הם נשארים פתוחים ומעלים לשחקן את מספר הזוגות שהוא מצא

           if(count == 1) {
               card1 = view.getId();
               return;
           }
           if(count == 2) {
               //לקבל תמונה משני הכרטיסים ולהשוות
                ImageView imageViewCard1 = findViewById(card1);
                if (imageViewCard1.getDrawable() == ((ImageView) view).getDrawable() )
                {
                    counterPlayer1++;
                }
                count=0;
           }

       }

    }
