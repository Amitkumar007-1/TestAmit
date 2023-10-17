package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example2.writerpad.R;

import java.util.List;

import Models.User;


public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {
private List<User> list_of_users;
    public LogAdapter(List<User> list_of_users) {
        this.list_of_users=list_of_users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator=LayoutInflater.from(parent.getContext());
       View view= inflator.inflate(R.layout.logs_adapter,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.log_time.setText(String.valueOf(list_of_users.get(position).getUserId()));
        holder.log_person_name.setText(String.valueOf(list_of_users.get(position).getId()));

        //Setting Title  Of Json Data in TextView
        String title=list_of_users.get(position).getTitle();
        String title_user[]=title.split(" ");
        holder.log_weight.setText(title_user[0].toString());


        //Setting Body Of Json Data in TextView
        String body=list_of_users.get(position).getBody();
        String body_user[]=body.split(" ");
        holder.log_status.setText(body_user[0].toString());

    }

    @Override
    public int getItemCount() {
        return list_of_users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
private TextView log_time;
private TextView log_person_name;
private TextView log_weight;
private TextView log_status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            log_time= itemView.findViewById(R.id.log_time);
            log_person_name=itemView.findViewById(R.id.log_person_name);
            log_weight=itemView.findViewById(R.id.log_weight);
            log_status=itemView.findViewById(R.id.log_status);

        }
    }
}
