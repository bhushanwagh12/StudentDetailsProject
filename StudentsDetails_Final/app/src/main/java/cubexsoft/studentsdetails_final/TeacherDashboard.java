package cubexsoft.studentsdetails_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TeacherDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

    }

    public void results(View v){

        startActivity(new Intent(this,TeacherResults.class));
   

    }

    public void attendance(View v){

        startActivity(new Intent(this,AttendanceActivity.class));

    }


    public void notification(View v){

        startActivity(new Intent(this,TeacherNotifications.class));


    }


    public void events(View v){


    startActivity(new Intent(this,TeacherEvents.class));


    }


    public void editprofile(View v){

        startActivity(new Intent(this,EditProfile.class));

    }





}
