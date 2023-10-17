package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example2.recyclerview.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<String> list;
    public Adapter(List<String> list) {
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator=LayoutInflater.from(parent.getContext());
        View view=inflator.inflate(R.layout.single_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemText.setText(list.get(position));

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

     private TextView itemText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             itemText=(TextView)itemView.findViewById(R.id.itemText);


        }
    }
}
