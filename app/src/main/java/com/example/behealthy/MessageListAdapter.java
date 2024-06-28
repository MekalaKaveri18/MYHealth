package com.example.behealthy;
import com.example.behealthy3.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MessageListAdapter extends ArrayAdapter<Message> {

    private Context context;
    private List<Message> messageList;

    public MessageListAdapter(@NonNull Context context, @NonNull List<Message> messageList) {
        super(context, 0, messageList);
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        Message message = getItem(position);

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Determine layout based on message type
            if (message.getUserId().equals("currentUserId")) {
                convertView = inflater.inflate(R.layout.activity_support, parent, false);
            } else {
                convertView = inflater.inflate(R.layout.activity_support, parent, false);
            }

            viewHolder.messageTextView = convertView.findViewById(R.id.messageInput);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set message text
        if (message != null) {
            viewHolder.messageTextView.setText(message.getText());
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView messageTextView;
    }
}
