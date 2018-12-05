package blahblah.hihi.btl.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import blahblah.hihi.btl.R;
import blahblah.hihi.btl.doituong.ChiTra;

/**
 * Created by Hihi on 24/10/2017.
 */

public class ChiTraAdapter extends ArrayAdapter<ChiTra> {
    Activity context;
    int resource;
    public ChiTraAdapter( Activity context,  int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customview = inflater.inflate(this.resource,null);

        ImageView imageView = customview.findViewById(R.id.imgicon);
        TextView textView = customview.findViewById(R.id.tvNoiDung);

        ChiTra chiTra = getItem(position);
        imageView.setImageResource(chiTra.getHinh());
        textView.setText(chiTra.getNoiDung());

        return customview;

    }
}
