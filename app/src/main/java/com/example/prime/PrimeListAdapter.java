package com.example.prime;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prime.prime.R;


/**
 * This is the recycler adapter.
 */
public class PrimeListAdapter extends RecyclerView.Adapter<PrimeListAdapter.ViewHolder> {

  Context mContext;

  public PrimeListAdapter(Context context) {
    this.mContext = context;
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
    return new ViewHolder(view);
  }


  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
      // This will recalculate the prime numbers each time.
      final Prime aprime = new PrimeData().primeList().get(position);

      // Convert the prime integer to its text.
      holder.pnumber.setText(String.valueOf(aprime.pnumber));
  }


  @Override
  public int getItemCount() {
    return new PrimeData().primeList().size();
  }


  public class ViewHolder extends RecyclerView.ViewHolder {

    // Fields
    CardView cv;
    TextView pnumber;

    public ViewHolder(View itemView) {
        super(itemView);
        cv              = (CardView) itemView.findViewById(R.id.recycler_id);
        pnumber         = (TextView) itemView.findViewById(R.id.pnumber);
    }
  }

}
