package com.example.intente_p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class menupage2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private Button next;
    private ConstraintLayout layout2;
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage2);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        spinner = findViewById(R.id.spinner);
        next = findViewById(R.id.next);
        layout2 = findViewById(R.id.layout2);
        toggleButton = findViewById(R.id.toggleButton);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()) {
                    Intent intent = new Intent(menupage2.this, menupage3.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(menupage2.this,"Have You Agreed Terms and Conditions",Toast.LENGTH_SHORT).show();
                }

            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()){
                    Snackbar.make(layout2,"Submitted Data", Snackbar.LENGTH_INDEFINITE)
                            .setTextColor(Color.CYAN)
                            .setBackgroundTint(Color.BLACK)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(Color.RED).show();
                }
                else{
                    Snackbar.make(layout2,"Please Agree T&C", Snackbar.LENGTH_INDEFINITE)
                            .setTextColor(Color.CYAN)
                            .setBackgroundTint(Color.BLACK)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(Color.RED).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(),choice,Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //menu filter
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.firstpage_menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Toast.makeText(this,"Returned to Home Page" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(menupage2.this,welcome.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.search:
//                Toast.makeText(this,"Searching..." , Toast.LENGTH_SHORT).show();
                Intent intent_course = new Intent(menupage2.this,fragment_main.class);
                startActivity(intent_course);
                return true;

            case R.id.profile:
                Toast.makeText(this,"Details" , Toast.LENGTH_SHORT).show();
                new MaterialAlertDialogBuilder(menupage2.this)
                        .setTitle("Details")
                        .setMessage("Name : SandeepSS\n " +
                                "Age: 22 \nCourse : MCA")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                return true;

            case R.id.about:
//                Toast.makeText(this,"Go to Settings " , Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(menupage2.this,about_us.class);
                startActivity(intent3);

                return true;

            case R.id.more:
//                Toast.makeText(this,"" , Toast.LENGTH_SHORT).show();
                return true;

            case R.id.logout:
                Toast.makeText(this,"Logged Out" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
                return true;

            case R.id.location:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("geo:12.9393585,77.5940298"));
                startActivity(intent1);
                return true;

            case R.id.phone:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:+91976543210"));
                startActivity(intent2);
                return true;

            case R.id.camera:
                Intent intentabout = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intentabout);
                return true;


            case R.id.message:

                Intent intent4 = new Intent(Intent.ACTION_SENDTO);
                intent4.setData(Uri.parse("mailto:ok@christuniversity.in"));
                startActivity(intent4);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}