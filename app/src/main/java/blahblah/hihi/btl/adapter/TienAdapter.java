package blahblah.hihi.btl.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import blahblah.hihi.btl.R;
import blahblah.hihi.btl.doituong.Tien;

/**
 * Created by Hihi on 23/10/2017.
 */

public class TienAdapter extends ArrayAdapter<Tien> {
    Activity context;
    int resource;
    public TienAdapter( Activity context,  int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        ImageView imageView = customView.findViewById(R.id.imgHinh);
        TextView tvSoTien = customView.findViewById(R.id.tvSoTien);


        Tien tien = getItem(position);
        imageView.setImageResource(tien.getHinh());
        tvSoTien.setText(tien.getSoTien()+" VND");

        return customView;
    }
}
