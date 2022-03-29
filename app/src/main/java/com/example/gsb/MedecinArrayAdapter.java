package com.example.gsb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MedecinArrayAdapter extends ArrayAdapter<Medecin> {
    private List<Medecin> MedecinList;

    static class MedecinViewHolder {
        TextView medNum;
        TextView medNom;
        TextView medPrenom;
        TextView medAdresse;
        TextView medCp;
        TextView medVille;
        TextView medCoeff;
        TextView medType;
    }

    public MedecinArrayAdapter(Context context, int textViewResourceId, ArrayList<Medecin> medecinList) {
        super(context, textViewResourceId);
        this.MedecinList = medecinList;
    }

    @Override
    public void add(Medecin object) {
        MedecinList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.MedecinList.size();
    }

    @Override
    public Medecin getItem(int index) {
        return this.MedecinList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MedecinViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview_medecin_layout, parent, false);
            viewHolder = new MedecinViewHolder();
            viewHolder.medNum = (TextView) row.findViewById(R.id.medNum);
            viewHolder.medNom = (TextView) row.findViewById(R.id.medNom);
            viewHolder.medPrenom = (TextView) row.findViewById(R.id.medPrenom);
            viewHolder.medAdresse = (TextView) row.findViewById(R.id.medAdresse);
            viewHolder.medCp = (TextView) row.findViewById(R.id.medCp);
            viewHolder.medVille = (TextView) row.findViewById(R.id.medVille);
            viewHolder.medCoeff = (TextView) row.findViewById(R.id.medCoeff);
            viewHolder.medType = (TextView) row.findViewById(R.id.medType);
            row.setTag(viewHolder);
        } else {
            viewHolder = (MedecinViewHolder)row.getTag();
        }
        Medecin medecin = getItem(position);
        viewHolder.medNum.setText(String.valueOf(medecin.getNumero()));
        viewHolder.medNom.setText(medecin.getNom());
        viewHolder.medPrenom.setText(medecin.getPrenom());
        viewHolder.medAdresse.setText(medecin.getAdresse());
        viewHolder.medCp.setText(medecin.getCodePostal());
        viewHolder.medVille.setText(medecin.getVille());
        viewHolder.medCoeff.setText(String.valueOf(medecin.getCoefNotoriete()));
        viewHolder.medType.setText(medecin.getTypeLibelle());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}