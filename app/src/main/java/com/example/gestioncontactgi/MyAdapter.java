package com.example.gestioncontactgi;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Contact[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nom;
        private final TextView code;
        private final TextView tel;
        private final TextView mail;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nom = (TextView) view.findViewById(R.id.nomL);
            code = (TextView) view.findViewById(R.id.codeL);
            mail = (TextView) view.findViewById(R.id.mailL);
            tel = (TextView) view.findViewById(R.id.numL);
        }

        public TextView getCode() {
            return code;
        }
        public TextView getNom() {
            return nom;
        }
        public TextView getTel() {
            return tel;
        }
        public TextView getMail() {
            return mail;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public MyAdapter(Contact[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_element, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //Log.d("bindLog",String.valueOf(localDataSet[position].getCodeContact()));
        //Log.d("bindLog",String.valueOf(position));
        Contact contact = localDataSet[position];
        viewHolder.getCode().setText(String.format("Code : %s", String.valueOf(contact.getCodeContact())));
        viewHolder.getNom().setText(String.format("%s %s", contact.getNomContact(), contact.getPrenomContact()));
        viewHolder.getTel().setText(String.format("Num : %s", contact.getTelContact()));
        viewHolder.getMail().setText(String.format("Mail : %s", contact.getMailContact()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
