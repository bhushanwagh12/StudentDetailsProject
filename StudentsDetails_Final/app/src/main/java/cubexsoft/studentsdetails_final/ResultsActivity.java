package cubexsoft.studentsdetails_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultsActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5,et6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        et1=(EditText)findViewById(R.id.ret1);
        et2=(EditText)findViewById(R.id.ret_sub1);
        et3=(EditText)findViewById(R.id.ret_sub2);
        et4=(EditText)findViewById(R.id.ret_sub3);
        et5=(EditText)findViewById(R.id.ret_sub4);
        et6=(EditText)findViewById(R.id.ret_sub5);

    }

    public void go(View v){

        FirebaseDatabase dBase=FirebaseDatabase.getInstance();
        final DatabaseReference ref=dBase.getReference("results");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


            Iterable<DataSnapshot> results=dataSnapshot.getChildren();

                for(DataSnapshot result:results)
                {
                    if(result.getKey().equalsIgnoreCase(et1.getText().toString()))
                    {

                       Iterable<DataSnapshot> result_childs=result.getChildren();

                       for(DataSnapshot snap:result_childs)
                       {

                           if(snap.getKey().equalsIgnoreCase("maths")){
                               et2.setText("Maths :"+snap.getValue().toString());
                           }

                           if(snap.getKey().equalsIgnoreCase("english")){
                               et3.setText("English :"+snap.getValue().toString());
                           }

                           if(snap.getKey().equalsIgnoreCase("science")){
                               et4.setText("Science :"+snap.getValue().toString());
                           }

                           if(snap.getKey().equalsIgnoreCase("social")){
                               et5.setText("Social :"+snap.getValue().toString());
                           }

                           if(snap.getKey().equalsIgnoreCase("total")){
                               et6.setText("Total :"+snap.getValue().toString());
                           }
                       }

                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
