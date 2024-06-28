package com.example.behealthy;
import com.example.behealthy3.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InstructionAdapter extends RecyclerView.Adapter<InstructionAdapter.ViewHolder> {

    private List<String> instructionsList;

    public void setInstructionsList(List<String> instructionsList) {
        this.instructionsList = instructionsList;
        notifyDataSetChanged(); // Refresh RecyclerView
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_support, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String instruction = instructionsList.get(position);
        holder.bind(instruction);
    }

    @Override
    public int getItemCount() {
        return instructionsList != null ? instructionsList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView instructionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            instructionTextView = itemView.findViewById(R.id.instructionTextView);
        }

        public void bind(String instruction) {
            instructionTextView.setText(instruction);
        }
    }
}
