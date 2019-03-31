package cubexsoft.studentsdetails_final;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudentDashboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
    }

    public void timetable(View v){

        startActivity(new Intent(this,TimeTableActivity.class));

    }
    public void results(View v){

        startActivity(new Intent(this,ResultsActivity.class));

    }
    public void notifications(View v){

        startActivity(new Intent(this,NotificationsActivity.class));

    }
    public void events(View v){

        startActivity(new Intent(this,EventsActivity.class));

    }
    public void editprofile(View v){


        startActivity(new Intent(this,EditProfile.class));


    }
    public void gallery(View v){

        startActivity(new Intent(this,GalleryActivity.class));

    }






}
