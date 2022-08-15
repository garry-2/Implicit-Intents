package com.example.implintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.ExtractedText;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btn1,btn2,btn3,btn4,btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 =findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        //dial intent
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent();
                iDial.setAction(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +917499519834"));
                startActivity(iDial);

            }
        });

        // message intent
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iText = new Intent();
                iText.setAction(Intent.ACTION_SENDTO);
                iText.setType("text/plain");
                iText.setData(Uri.parse("smsto: "+Uri.encode("+7499519834")));
                iText.putExtra("sms_body","This App is Awesome !");
                startActivity(Intent.createChooser(iText,"Share via"));


            }
        });

        //email intent
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent();
                iEmail.setAction(Intent.ACTION_SEND);
                iEmail.setType("text/plain");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"wanigaurav24@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Android intent testing");
                iEmail.putExtra(Intent.EXTRA_TEXT,"This app is running fine");
                startActivity(iEmail);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent();
                iShare.setAction(Intent.ACTION_SEND);
                iShare.setType("plain/text");
                iShare.putExtra(Intent.EXTRA_TEXT,"This is My Android App");
                startActivity(Intent.createChooser(iShare,"Share via"));

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMaps = new Intent();
                iMaps.setAction(Intent.ACTION_VIEW);
                iMaps.setData(Uri.parse("geo:21.0077,75.5626"));
                startActivity(iMaps);

            }
        });

    }
}