package cubexsoft.studentsdetails_final;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by maheshthippala on 30/03/17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryHolder>{


    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(GalleryActivity.gActivity);

        View v=inflater.inflate(R.layout.indiview,parent,false);

        return new GalleryHolder(v);
    }

    @Override
    public void onBindViewHolder(GalleryHolder holder, int position) {

        holder.iview.setImageResource(GalleryActivity.list.get(position));


    }

    @Override
    public int getItemCount() {


        return GalleryActivity.list.size();
    }
}
