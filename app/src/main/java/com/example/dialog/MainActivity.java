package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bgButton;
    public ConstraintLayout constraintLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgButton = (Button)findViewById(R.id.button_bg_change);
        constraintLayout = (ConstraintLayout)findViewById(R.id.constraintlayout);
        context = MainActivity.this;

        bgButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final CharSequence[] items = {getText(R.string.redColor), getText(R.string.yellowColor), getText(R.string.greenColor)};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        constraintLayout.setBackgroundResource(R.color.red);
                        Toast.makeText(context, R.string.redColor, Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        constraintLayout.setBackgroundResource(R.color.yellow);
                        Toast.makeText(context, R.string.yellowColor, Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        constraintLayout.setBackgroundResource(R.color.green);
                        Toast.makeText(context, R.string.greenColor, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}