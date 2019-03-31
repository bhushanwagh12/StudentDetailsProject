package cubexsoft.studentsdetails_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ParentDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_dashboard);
    }

    public void results(View v){

        startActivity(new Intent(this,ResultsActivity.class));


    }

    public void attendance(View v){

        startActivity(new Intent(this,ParentAttendance.class));

    }

    public void editprofile(View v){

        startActivity(new Intent(this,EditProfile.class));

    }
}
