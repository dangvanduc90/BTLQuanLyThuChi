package blahblah.hihi.btl.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import blahblah.hihi.btl.R;
import blahblah.hihi.btl.doituong.MainDanhSach;

/**
 * Created by Hihi on 26/10/2017.
 */

public class MainAdapter extends ArrayAdapter<MainDanhSach> {
    Activity context;
    int resource;
    public MainAdapter( Activity context,  int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        ImageView imageView = customView.findViewById(R.id.imageView2);
        TextView tvTittle = customView.findViewById(R.id.tvTittle);
        TextView tvDate = customView.findViewById(R.id.tvDate);

        MainDanhSach mainDanhSach = getItem(position);
        imageView.setImageResource(mainDanhSach.getHinh());
        tvTittle.setText(mainDanhSach.getLoai()+": "+mainDanhSach.getMuc()+" ("+mainDanhSach.getSotien() +"VND)");
        tvDate.setText(mainDanhSach.getNgay());
        return customView;
    }

}
