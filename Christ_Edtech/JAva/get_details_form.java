package com.example.intente_p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class get_details_form extends AppCompatActivity {


    private CheckBox ch1,ch2,ch3,ch4,ch5,ch6;
    private RadioGroup rb_grp;
    private RadioButton rb_gender;
    private Switch switch1;

//    SharedPreferences sp1;

//    String name = ch1.getText().toString();
//    String gender = rb_gender.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_details_form);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        init();
        FloatingActionButton fab = findViewById(R.id.flt_btn);

//        sp1 = getSharedPreferences("MyUserprefs1", Context.MODE_PRIVATE);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer result = new StringBuffer();
                result.append("Courses Selected : \n");
                if (ch1.isChecked()){
                    result.append(ch1.getText().toString()).append("\n");
                }
                if (ch2.isChecked()){
                    result.append(ch2.getText().toString()).append("\n");
                }
                if (ch3.isChecked()){
                    result.append(ch3.getText().toString()).append("\n");
                }
                if (ch4.isChecked()){
                    result.append(ch4.getText().toString()).append("\n");
                }
                if (ch5.isChecked()){
                    result.append(ch5.getText().toString()).append("\n");
                }
                if (ch6.isChecked()){
                    result.append(ch6.getText().toString()).append("\n");
                }

                int gender = rb_grp.getCheckedRadioButtonId();
                rb_gender = findViewById(gender);

                if (rb_gender!=null){
                    result.append("\n Gender: \n").append(rb_gender.getText().toString());
                }

                Toast.makeText(get_details_form.this, result.toString(), Toast.LENGTH_LONG)
                        .show();

                Intent intent = new Intent(get_details_form.this,menupage2.class); //need to chenge
                startActivity(intent);

//                SharedPreferences.Editor editor = sp1.edit();
//                editor.putString("checkboxvalue",name);
//                editor.putString("gendervalue",gender);
//                editor.commit();
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (switch1.isChecked()){
                    Toast toast = Toast.makeText(get_details_form.this,"Congo!! Hackathon Selected",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(get_details_form.this,"See you Next Time",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            }
        });


    }

    private void init()
    {
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);
        ch5 = findViewById(R.id.ch5);
        ch6 = findViewById(R.id.ch6);

        rb_grp = findViewById(R.id.rb_grp);
        switch1 =findViewById(R.id.switch1);

    }

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
                Intent intent = new Intent(get_details_form.this,welcome.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.search:
//                Toast.makeText(this,"Searching..." , Toast.LENGTH_SHORT).show();
                Intent intent_course = new Intent(get_details_form.this,fragment_main.class);
                startActivity(intent_course);
                return true;

            case R.id.profile:
                Toast.makeText(this,"Details" , Toast.LENGTH_SHORT).show();
                new MaterialAlertDialogBuilder(get_details_form.this)
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
                Intent intent3 = new Intent(get_details_form.this,about_us.class);
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
