package com.example.intente_p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class about_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        ImageView call_btn = (ImageView) findViewById(R.id.call_btn);
        ImageView map_btn = (ImageView) findViewById(R.id.map_btn);
        ImageView mail_btn =(ImageView) findViewById(R.id.mail_btn);
        ImageView search_btn = (ImageView) findViewById(R.id.search_btn);
        EditText search_txt = (EditText) findViewById(R.id.search_txt);
        ImageView btn_share = (ImageView) findViewById(R.id.btn_share);

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876543210"));
                startActivity(intent);
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Download EdTech APP");
                intent.putExtra(Intent.EXTRA_TEXT,"Application Link Here");
                startActivity(Intent.createChooser(intent,"Share Via"));

            }
        });

        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:12.936769473648695, 77.60612442370513"));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });

        mail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:ok@christuniversity.in"));
                startActivity(intent);
            }
        });

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchterms = search_txt.getText().toString();
                if(!searchterms.equals("")){
                    searchnet(searchterms);
                }
            }
        });

    }
    private void searchnet(String words)
    {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY,words);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            e.printStackTrace();
            searchnet(words);
        }
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
                Intent intent = new Intent(about_us.this,welcome.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.search:
//                Toast.makeText(this,"Searching..." , Toast.LENGTH_SHORT).show();
                Intent intent_course = new Intent(about_us.this,fragment_main.class);
                startActivity(intent_course);
                return true;

            case R.id.profile:
                Toast.makeText(this,"Details" , Toast.LENGTH_SHORT).show();
                new MaterialAlertDialogBuilder(about_us.this)
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
                Intent intent3 = new Intent(about_us.this,about_us.class);
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