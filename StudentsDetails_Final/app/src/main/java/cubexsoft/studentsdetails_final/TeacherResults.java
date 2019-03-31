package cubexsoft.studentsdetails_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherResults extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5,et6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_results);

        et1=(EditText)findViewById(R.id.ret1);
        et2=(EditText)findViewById(R.id.ret_sub1);
        et3=(EditText)findViewById(R.id.ret_sub2);
        et4=(EditText)findViewById(R.id.ret_sub3);
        et5=(EditText)findViewById(R.id.ret_sub4);
        et6=(EditText)findViewById(R.id.ret_sub5);


    }


    public void update(View v){

        FirebaseDatabase dBase=FirebaseDatabase.getInstance();
        DatabaseReference ref=dBase.getReference("results");

        DatabaseReference result=ref.child(et1.getText().toString());

        result.child("maths").setValue(et2.getText().toString());
        result.child("english").setValue(et3.getText().toString());
        result.child("science").setValue(et4.getText().toString());
        result.child("social").setValue(et5.getText().toString());
        result.child("total").setValue(et6.getText().toString());

        Toast.makeText(this,"Record Updated Successfully ",
                                            Toast.LENGTH_LONG).show();
        finish();

    }


}
