package cubexsoft.studentsdetails_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AttendanceActivity extends AppCompatActivity {

    EditText sid,jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        sid=(EditText)findViewById(R.id.sid);

        jan=(EditText)findViewById(R.id.jan);
        feb=(EditText)findViewById(R.id.feb);
        mar=(EditText)findViewById(R.id.mar);
        apr=(EditText)findViewById(R.id.apr);
        may=(EditText)findViewById(R.id.may);
        jun=(EditText)findViewById(R.id.jun);
        jul=(EditText)findViewById(R.id.july);
        aug=(EditText)findViewById(R.id.aug);
        sep=(EditText)findViewById(R.id.sep);
        oct=(EditText)findViewById(R.id.oct);
        nov=(EditText)findViewById(R.id.nov);
        dec=(EditText)findViewById(R.id.dec);

    }


    public void save(View v){

        FirebaseDatabase dBase=FirebaseDatabase.getInstance();

        DatabaseReference ref=dBase.getReference("attendanse");

        DatabaseReference indi_rec=ref.child(sid.getText().toString());
        indi_rec.child("jan").setValue(jan.getText().toString());
        indi_rec.child("feb").setValue(feb.getText().toString());
        indi_rec.child("mar").setValue(mar.getText().toString());
        indi_rec.child("apr").setValue(apr.getText().toString());
        indi_rec.child("may").setValue(may.getText().toString());
        indi_rec.child("jun").setValue(jun.getText().toString());
        indi_rec.child("jul").setValue(jul.getText().toString());
        indi_rec.child("aug").setValue(aug.getText().toString());
        indi_rec.child("sep").setValue(sep.getText().toString());
        indi_rec.child("oct").setValue(oct.getText().toString());
        indi_rec.child("nov").setValue(nov.getText().toString());
        indi_rec.child("dec").setValue(dec.getText().toString());

        Toast.makeText(this,
                "Attendance Record Inserted ",Toast.LENGTH_LONG).show();

        finish();

    }

}
