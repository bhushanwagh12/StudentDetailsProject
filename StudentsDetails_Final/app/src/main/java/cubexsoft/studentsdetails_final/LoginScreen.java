package cubexsoft.studentsdetails_final;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginScreen extends Activity
{

    EditText username, password;
    ProgressDialog mProgressDialog;

    RadioButton student, teacher, parent;

    boolean from_register,from_login;
    String type="";

    FirebaseDatabase database;
    DatabaseReference myRef;

    static  ArrayList<User> users_list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_screen);

        database=FirebaseDatabase.getInstance();

        myRef= database.getReference("users");

        username=(EditText)findViewById(R.id.uname);
        password=(EditText)findViewById(R.id.pass);

        student=(RadioButton)findViewById(R.id.r1);
        teacher=(RadioButton)findViewById(R.id.r2);
        parent=(RadioButton)findViewById(R.id.r3);

        mProgressDialog=new ProgressDialog(this);
        mProgressDialog.setCancelable(false);

        student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    parent.setChecked(false);
                    teacher.setChecked(false);
                    type="Student";
                }
            }
        });
        teacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    parent.setChecked(false);
                    student.setChecked(false);
                    type="Teacher";
                }
            }
        });
        parent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    student.setChecked(false);
                    teacher.setChecked(false);
                    type="Parent";
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void login(View v){


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                users_list.clear();

                Iterable<DataSnapshot> users= dataSnapshot.getChildren();

                for(DataSnapshot user:users)
                {
                    User u=new User();

                    Iterable<DataSnapshot> user_chids=user.getChildren();

                    for(DataSnapshot user_child:user_chids)
                    {
                        if(user_child.getKey().equals("uname")){
                            u.setName(user_child.getValue().toString());
                        }
                        if(user_child.getKey().equals("pass")){
                            u.setPass(user_child.getValue().toString());
                        }
                        if(user_child.getKey().equals("type")){
                            u.setType(user_child.getValue().toString());
                        }
                    } // for


                    users_list.add(u);
                } // main


                boolean found=false;

                for(User u: users_list)
                {
                    if(u.getName().equalsIgnoreCase(username.getText().toString())
                            && u.getPass().equalsIgnoreCase(password.getText().toString()) &&
                            u.getType().equalsIgnoreCase(type)) {


                        ApplicationConstants.uname=u.getName();

                        ApplicationConstants.pass=u.getPass();

                        ApplicationConstants.type=u.getType();


                        found=true;

                        Toast.makeText(LoginScreen.this,"Welcome 2 Students Details App...",Toast.LENGTH_LONG).show();

                        if(type.equalsIgnoreCase("student")){
                            startActivity(new Intent(LoginScreen.this,StudentDashboard.class));
                        }else if(type.equalsIgnoreCase("teacher")){
                            startActivity(new Intent(LoginScreen.this,TeacherDashboard.class));
                        }else if(type.equalsIgnoreCase("parent")){
                            startActivity(new Intent(LoginScreen.this,ParentDashboard.class));
                        }


                    }else{



                    }
                } // for

                if(!found){

                    Toast.makeText(LoginScreen.this,"Invalid User Credentials...",Toast.LENGTH_LONG).show();


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public void register(View v){

        users_list.clear();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              Iterable<DataSnapshot> users= dataSnapshot.getChildren();

                for(DataSnapshot user:users)
                {
                    User u=new User();

                    Iterable<DataSnapshot> user_chids=user.getChildren();

                    for(DataSnapshot user_child:user_chids)
                    {
                        if(user_child.getKey().equals("uname")){
                            u.setName(user_child.getValue().toString());
                        }
                        if(user_child.getKey().equals("pass")){
                            u.setPass(user_child.getValue().toString());
                        }
                        if(user_child.getKey().equals("type")){
                            u.setType(user_child.getValue().toString());
                        }
                    } // for

                    users_list.add(u);
                } // main


                boolean found=false;

                for(User u: users_list)
                {
                    if(u.getName().equalsIgnoreCase(username.getText().toString())
                            && u.getPass().equalsIgnoreCase(password.getText().toString()) &&
                            u.getType().equalsIgnoreCase(type)) {

                        found=true;

                        Toast.makeText(LoginScreen.this,"User is Alredy Registered..., please try with other credentials ",Toast.LENGTH_LONG).show();

                    }else{


                    }
                } // for

                if(!found){

                    Toast.makeText(LoginScreen.this,users_list.size()+"",Toast.LENGTH_LONG).show();

                    FirebaseDatabase  database=FirebaseDatabase.getInstance();

                    DatabaseReference  myRef= database.getReference("users");

                    DatabaseReference user_=myRef.push();

                    Toast.makeText(LoginScreen.this,user_+"",Toast.LENGTH_LONG).show();

                    user_.child("uname").setValue(username.getText().toString());
                    user_.child("pass").setValue(password.getText().toString());
                    user_.child("type").setValue(type);

                    Toast.makeText(LoginScreen.this,"Registered Successfully",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}