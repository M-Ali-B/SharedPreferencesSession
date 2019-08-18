package com.github.malib.sharedpreferencessession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name, age;
Button save,clear,retrieve;
String nameString="" , ageString="";
String myPreferences = "myPref";
SharedPreferences mSharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    name = findViewById(R.id.editText);
    age = findViewById(R.id.editText2);
    save = findViewById(R.id.button);
    clear = findViewById(R.id.button2);
    retrieve = findViewById(R.id.button3);


    mSharedPreferences = getSharedPreferences(myPreferences,0); // 0 means Private_MODE


    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nameString = String.valueOf(name.getText());
            ageString = String.valueOf(age.getText());

        //mSharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putString("name",nameString);
            editor.putString("age",ageString);
            editor.commit();
            Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
        }
    });

clear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        name.setText("");
        age.setText("");
        Toast.makeText(MainActivity.this, "Data Cleared", Toast.LENGTH_SHORT).show();

    }
});
retrieve.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        mSharedPreferences = getSharedPreferences(myPreferences,Context.MODE_PRIVATE);
name.setText(mSharedPreferences.getString("name",""));
age.setText(mSharedPreferences.getString("age",""));

        Toast.makeText(MainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();

    }
});

    }
}
