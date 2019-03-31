package cubexsoft.studentsdetails_final;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    EditText username, password;

    RadioButton student, teacher, parent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username=(EditText)findViewById(R.id.uname);
        password=(EditText)findViewById(R.id.pass);

        student=(RadioButton)findViewById(R.id.r1);
        teacher=(RadioButton)findViewById(R.id.r2);
        parent=(RadioButton)findViewById(R.id.r3);


        username.setText(ApplicationConstants.uname);

        password.setText(ApplicationConstants.pass);

        if(ApplicationConstants.type.equalsIgnoreCase("student"))
        {
             student.setChecked(true);
             teacher.setChecked(false);
             parent.setChecked(false);
        }

        if(ApplicationConstants.type.equalsIgnoreCase("teacher"))
        {
            student.setChecked(false);
            teacher.setChecked(true);
            parent.setChecked(false);
        }

        if(ApplicationConstants.type.equalsIgnoreCase("parent"))
        {
            student.setChecked(false);
            teacher.setChecked(false);
            parent.setChecked(true);
        }
    }

    public void update(View v){

        Toast.makeText(EditProfile.this,
                "Record Updated..",Toast.LENGTH_LONG).show();
        finish();
    }

}
