package dblasena.css.favotiecontacts;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {
    TextView Name1, Name2, Name3, Number1, Number2, Number3, txtViewStatus;
    Button btncall1, btncall2, btncall3, btntxt1, btntxt2, btntxt3;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtonClickEvents();

        txtViewStatus = (TextView) findViewById(R.id.txtViewStatus);


        Name1 = (TextView) findViewById(R.id.txtName1);
        Name2 = (TextView) findViewById(R.id.txtName2);
        Name3 = (TextView) findViewById(R.id.txtName3);

        Number1 = (TextView) findViewById(R.id.txtNum1);
        Number2 = (TextView) findViewById(R.id.txtNum2);
        Number3 = (TextView) findViewById(R.id.txtNum3);

        Resources nam = getResources();
        String[] names = nam.getStringArray(R.array.Names);
        Name1.setText("Name: " + names[0]);
        Name2.setText("Name: " + names[1]);
        Name3.setText("Name: " + names[2]);

        Resources num = getResources();
        String[] numbers = num.getStringArray(R.array.Numbers);
        Number1.setText("Number: " + numbers[0]);
        Number2.setText("Number: " + numbers[1]);
        Number3.setText("Number: " + numbers[2]);





    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void composeMmsMessage(String number, String message) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:" + number));
        sendIntent.putExtra("sms_body", message);
        startActivity(sendIntent);
    }




    private void setupButtonClickEvents() {
        final Resources  nam2 = getResources();
        final String[] names2 = nam2.getStringArray(R.array.Names);
        final Resources num2 = getResources();
        final String[] numbers2 = num2.getStringArray(R.array.Numbers);




        btncall1 = (Button) findViewById(R.id.btncall1);
        btncall1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               dialPhoneNumber(numbers2[0]);
                txtViewStatus.setText("Now Calling: " +  names2[0]);
            }
        });

        btncall2 = (Button) findViewById(R.id.btncall2);
        btncall2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               dialPhoneNumber(numbers2[1]);
               txtViewStatus.setText("Now Calling: " + names2[1]);
            }
        });

        btncall3 = (Button) findViewById(R.id.btnCall3);
       btncall3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialPhoneNumber(numbers2[2]);
                txtViewStatus.setText("Now Calling: " + names2[2]);
            }
        });
        btntxt1 = (Button) findViewById(R.id.btntxt1);
        btntxt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                composeMmsMessage(numbers2[0],"Hi");
                txtViewStatus.setText("Sending Text To: " + names2[0]);
            }
        });
        btntxt2 = (Button) findViewById(R.id.btntxt2);
        btntxt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                composeMmsMessage(numbers2[1],"Hi");
                txtViewStatus.setText("Sending Text To: " + names2[1]);
            }
        });
        btntxt3 = (Button) findViewById(R.id.btntxt3);
        btntxt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                composeMmsMessage(numbers2[2],"Hi");
                txtViewStatus.setText("Sending Text To: " + names2[2]);
            }
        });






        };





    }



