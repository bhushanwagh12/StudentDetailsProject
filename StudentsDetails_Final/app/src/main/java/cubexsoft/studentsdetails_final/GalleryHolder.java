package cubexsoft.studentsdetails_final;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by maheshthippala on 30/03/17.
 */

public class GalleryHolder extends RecyclerView.ViewHolder {

    ImageView iview;

    public GalleryHolder(View itemView) {
        super(itemView);

        iview=(ImageView)itemView.findViewById(R.id.cview1);

    }
}
