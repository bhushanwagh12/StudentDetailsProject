package cubexsoft.studentsdetails_final;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by maheshthippala on 03/04/17.
 */

public class TeacherNotifications extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.teacher_notifications);

    }

    public void update(View v){

        EditText et1=(EditText)findViewById(R.id.et1);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("notifications");

        myRef.push().setValue(et1.getText().toString());

        Toast.makeText(this,"Notification Added Successfully",Toast.LENGTH_LONG).show();

     }




}
