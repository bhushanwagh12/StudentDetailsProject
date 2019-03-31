package cubexsoft.studentsdetails_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import com.squareup.picasso.Picasso;

public class TimeTableActivity extends AppCompatActivity {

    Spinner sp1;
    ImageView iview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        iview=(ImageView)findViewById(R.id.iv1);

        sp1=(Spinner)findViewById(R.id.sp1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(sp1.getSelectedItem().toString().equalsIgnoreCase("class-V")){

                     Picasso.with(TimeTableActivity.this).load("https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table5.png?alt=media&token=ee484175-dcad-4774-9233-a7f1e1536d7f").into(iview);

                }else if(sp1.getSelectedItem().toString().equalsIgnoreCase("class-VI")){
         //  https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table6.png?alt=media&token=4f4aafa6-d85b-402b-96b3-d4b1a81d3ca7
                    Picasso.with(TimeTableActivity.this).load("https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table6.png?alt=media&token=4f4aafa6-d85b-402b-96b3-d4b1a81d3ca7").into(iview);

                }else if(sp1.getSelectedItem().toString().equalsIgnoreCase("class-VII")){
// https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table7.png?alt=media&token=663acbe8-d188-49eb-b3aa-7d4d90a7780f
                    Picasso.with(TimeTableActivity.this).load("https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table7.png?alt=media&token=663acbe8-d188-49eb-b3aa-7d4d90a7780f").into(iview);

                }else if(sp1.getSelectedItem().toString().equalsIgnoreCase("class-VIII")){

// https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table8.png?alt=media&token=1f4edb3a-87cc-47ed-aeff-ad987802d8d4

                    Picasso.with(TimeTableActivity.this).load("https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table8.png?alt=media&token=1f4edb3a-87cc-47ed-aeff-ad987802d8d4").into(iview);

                }else if(sp1.getSelectedItem().toString().equalsIgnoreCase("class-IX")){
// https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table9.png?alt=media&token=4f118511-96ca-43e4-9f76-a676c7fed2d4

                    Picasso.with(TimeTableActivity.this).load("https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table9.png?alt=media&token=4f118511-96ca-43e4-9f76-a676c7fed2d4").into(iview);

                }else if(sp1.getSelectedItem().toString().equalsIgnoreCase("class-X")){
// https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table10.png?alt=media&token=113dfac7-bd64-4980-8387-f9a9524f1856

                    Picasso.with(TimeTableActivity.this).load("https://firebasestorage.googleapis.com/v0/b/studentsdetailsfinal.appspot.com/o/time_table10.png?alt=media&token=113dfac7-bd64-4980-8387-f9a9524f1856").into(iview);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
