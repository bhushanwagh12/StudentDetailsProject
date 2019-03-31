package cubexsoft.studentsdetails_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotificationsActivity extends AppCompatActivity {

    ArrayList<String> list=new ArrayList<>();

    ListView lview;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        lview=(ListView)findViewById(R.id.lview);

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,list);

        lview.setAdapter(adapter);


        FirebaseDatabase dBase=FirebaseDatabase.getInstance();
        DatabaseReference ref=dBase.getReference("notifications");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              Iterable<DataSnapshot> snaps=dataSnapshot.getChildren();

              for(DataSnapshot snap:snaps){

               //   Toast.makeText(NotificationsActivity.this,snap.getValue()+"",Toast.LENGTH_LONG).show();

                  list.add(snap.getValue().toString());
                  adapter.notifyDataSetChanged();

              }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
