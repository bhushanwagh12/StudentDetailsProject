package cubexsoft.studentsdetails_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParentAttendance extends AppCompatActivity {

    EditText sid,jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_attendance);

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


    public void go(View v){

        FirebaseDatabase dBase=FirebaseDatabase.getInstance();

        DatabaseReference ref=dBase.getReference("attendanse");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            Iterable<DataSnapshot> snapshots= dataSnapshot.getChildren();

            for(DataSnapshot snap:snapshots){

                if(snap.getKey().equalsIgnoreCase(sid.getText().toString()))
                {

                    Iterable<DataSnapshot> months=snap.getChildren();

                    for(DataSnapshot month:months){

                        if(month.getKey().equalsIgnoreCase("jan")){
                            jan.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("feb")){
                            feb.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("mar")){
                            mar.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("apr")){
                            apr.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("may")){
                            may.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("jun")){
                            jun.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("jul")){
                            jul.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("aug")){
                            aug.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("sep")){
                            sep.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("oct")){
                            oct.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("nov")){
                            nov.setText(month.getValue().toString());
                        }

                        if(month.getKey().equalsIgnoreCase("dec")){
                            dec.setText(month.getValue().toString());
                        }
                      }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



       /* Toast.makeText(this,
                "Attendance Record Inserted ",Toast.LENGTH_LONG).show();

        finish();*/

    }

}
