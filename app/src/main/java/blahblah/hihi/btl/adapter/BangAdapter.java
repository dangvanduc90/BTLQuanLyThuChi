package blahblah.hihi.btl.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import blahblah.hihi.btl.R;
import blahblah.hihi.btl.doituong.Bang;

/**
 * Created by Hihi on 24/10/2017.
 */

public class BangAdapter extends ArrayAdapter<Bang> {
    Activity context;
    int resource;
    public BangAdapter( Activity context,  int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        TextView tvTieude = customView.findViewById(R.id.tvTieude);
        TextView tvNoidung = customView.findViewById(R.id.tvNoiDung);

        Bang bang = getItem(position);
        tvNoidung.setText(bang.getNoiDung());
        tvTieude.setText(bang.getTieuDe());
        return customView;
    }
}
