package com.example.intente_p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class teacher_list extends AppCompatActivity {

    private ImageView imageView;

    private ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        imageView = findViewById(R.id.im1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.im3);
        ImageView imageView4 = findViewById(R.id.im4);
//        registerForContextMenu(imageView);
        registerForContextMenu(imageView2);
        registerForContextMenu(imageView3);
        registerForContextMenu(imageView4);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null) {
                    return false;
                }
                mActionMode = startActionMode(mActionModeCallback);
                return true;

            }
        });
    }



    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.contextmenu, menu);
            mode.setTitle("Choose your option");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.option_1:
                    Toast.makeText(teacher_list.this, "Option 1 selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.option_2:
                    Toast.makeText(teacher_list.this, "Option 2 selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };


    //floating contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
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
                Intent intent = new Intent(teacher_list.this,welcome.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.search:
//                Toast.makeText(this,"Searching..." , Toast.LENGTH_SHORT).show();
                Intent intent_course = new Intent(teacher_list.this,fragment_main.class);
                startActivity(intent_course);
                return true;

            case R.id.profile:
                Toast.makeText(this,"Details" , Toast.LENGTH_SHORT).show();
                new MaterialAlertDialogBuilder(teacher_list.this)
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
                Intent intent3 = new Intent(teacher_list.this,about_us.class);
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