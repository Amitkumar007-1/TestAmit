package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example2.writerpad.MainActivity;
import com.example2.writerpad.R;
import com.example2.writerpad.SelectDeviceActivity;
import com.example2.writerpad.WeighingMachineDetails;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SelectDeviceAdapter extends RecyclerView.Adapter<SelectDeviceAdapter.ViewHolder> {
    private int lastPostion = -1;
    private List<WeighingMachineDetails> listOfWeighingMachineDetails;


    private SelectDeviceActivity selectDeviceActivity;

    public SelectDeviceAdapter(SelectDeviceActivity selectDeviceActivity, List<WeighingMachineDetails> listOfWeighingMachineDetails) {
        this.listOfWeighingMachineDetails = listOfWeighingMachineDetails;
        this.selectDeviceActivity = selectDeviceActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.weighing_machine_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.weighing_machine_name.setText(listOfWeighingMachineDetails.get(position).getWeighingMachineName());
        holder.weighing_machine_availability.setText(listOfWeighingMachineDetails.get(position).getWeighing_machine_availability());
        holder.radioButton.setChecked(position == lastPostion);


    }

    @Override
    public int getItemCount() {
        return listOfWeighingMachineDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialRadioButton radioButton;
        private MaterialCardView singleWeighingCard;
        private TextView weighing_machine_name;
        private TextView weighing_machine_availability;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButton);
            singleWeighingCard = itemView.findViewById(R.id.singleWeighingCard);
            weighing_machine_name = itemView.findViewById(R.id.weighing_machine_name);
            weighing_machine_availability = itemView.findViewById(R.id.weighing_machine_availability);
            singleWeighingCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int copy_of_lastPosition = lastPostion;
                    lastPostion = getAdapterPosition();
                    notifyItemChanged(copy_of_lastPosition);
                    notifyItemChanged(lastPostion);
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(selectDeviceActivity, MainActivity.class);
                            intent.putExtra("weighingMachineName",weighing_machine_name.getText().toString());
                            selectDeviceActivity.startActivity(intent);

                        }
                    }, 1000);
                }
            });
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int copy_of_lastPosition=lastPostion;
                    lastPostion = getAdapterPosition();
                    notifyItemChanged(copy_of_lastPosition);
                    notifyItemChanged(lastPostion);
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(selectDeviceActivity, MainActivity.class);
                            intent.putExtra("weighingMachineName",weighing_machine_name.getText().toString());
                            selectDeviceActivity.startActivity(intent);

                        }
                    }, 1000);
                }
            });

        }
    }
}
