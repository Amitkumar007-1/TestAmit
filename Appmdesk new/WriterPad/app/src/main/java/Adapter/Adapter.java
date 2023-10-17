package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example2.writerpad.ItemDetails;
import com.example2.writerpad.MainActivity;
import com.example2.writerpad.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private MainActivity mainActivity;
    private List<ItemDetails> itemDetailsList;
    private int newPos = -1;

    public Adapter(MainActivity mainActivity, List<ItemDetails> listOfItemDetails) {
        this.mainActivity = mainActivity;
        this.itemDetailsList = listOfItemDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.buyerMark.setText(itemDetailsList.get(position).getBuyerMark());
        holder.lotName.setText(itemDetailsList.get(position).getLotName());
        holder.lotQuantity.setText(itemDetailsList.get(position).getLotQuantity());
        holder.bidQuantity.setText(itemDetailsList.get(position).getBidQuantity());
        holder.packageName.setText(itemDetailsList.get(position).getPackageName());

        if (newPos == position) {
            holder.materialCardView.setCardBackgroundColor(mainActivity.getResources().getColor(R.color.consideredCardColor));
        } else {
            holder.materialCardView.setCardBackgroundColor(mainActivity.getResources().getColor(R.color.white));
        }

        if (holder.progressBar.getProgress() == 100) {
            // Set alpha to 0.6f and make the card unclickable
            holder.materialCardView.setAlpha(0.6f);
            holder.materialCardView.setClickable(false);
        } else {
            // Reset alpha and clickability if the progress is not 100
            holder.materialCardView.setAlpha(1.0f);
            holder.materialCardView.setClickable(true);
        }
    }

    @Override
    public int getItemCount() {
        return itemDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int bar = 0;
        private MaterialCardView materialCardView;
        private ProgressBar progressBar;
        private TextView buyerMark;
        private TextView lotName;
        private TextView lotQuantity;
        private TextView bidQuantity;
        private TextView packageName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            materialCardView = itemView.findViewById(R.id.singleCard);
            progressBar = itemView.findViewById(R.id.pbLot);
            buyerMark = itemView.findViewById(R.id.buyerMark);
            lotName = itemView.findViewById(R.id.lotName);
            lotQuantity = itemView.findViewById(R.id.lotQuantity);
            bidQuantity = itemView.findViewById(R.id.bidQuantity);
            packageName = itemView.findViewById(R.id.packageName);

            materialCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int oldPos = newPos;
                    newPos = getAdapterPosition();

                    if (oldPos != -1) {
                        notifyItemChanged(oldPos); // Reset the background color of the previous card
                    }
                    if (progressBar.getProgress() == 75) {
                        bar += 25;
                        progressBar.setProgress(bar);
                    } else {
                        bar += 25;
                        progressBar.setProgress(bar);
                    }
//                    if (progressBar.getProgress() == 75) {
//
//                    } else {
//                       // materialCardView.setCardBackgroundColor(mainActivity.getResources().getColor(R.color.white));
//                    }

                    if (progressBar.getProgress() == 100) {
                        // Set alpha to 0.6f and make the card unclickable
                       materialCardView.setAlpha(0.6f);
                        materialCardView.setClickable(false);
                    }

                    notifyItemChanged(newPos); // Update the background color of the new card
                }
            });
        }
    }
}
