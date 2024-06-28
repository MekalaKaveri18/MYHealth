package com.example.behealthy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.behealthy3.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SupportActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private EditText messageInput;
    private Button sendButton;
    private ListView messageListView;
    private List<Message> messageList;
    private MessageListAdapter messageAdapter;
    private String currentUserId; // Store current user ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        currentUserId = mAuth.getCurrentUser().getUid(); // Get current user ID

        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);
        messageListView = findViewById(R.id.messageListView);

        messageList = new ArrayList<>();
        messageAdapter = new MessageListAdapter(this, messageList);
        messageListView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        loadMessages();
    }

    private void loadMessages() {
        // Query messages where either sender or receiver is current user
        Query query = mDatabase.child("messages")
                .orderByChild("senderId_receiverId")
                .equalTo(currentUserId + "_" + currentUserId);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                messageList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Message message = snapshot.getValue(Message.class);
                    messageList.add(message);
                }
                messageAdapter.notifyDataSetChanged();
                messageListView.setSelection(messageAdapter.getCount() - 1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SupportActivity.this, "Failed to load messages.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendMessage() {
        String messageText = messageInput.getText().toString().trim();
        if (!messageText.isEmpty()) {
            String messageId = mDatabase.child("messages").push().getKey(); // Generate unique message ID
            String userId = mAuth.getCurrentUser().getUid();

            Message message = new Message(messageId, userId, messageText);

            mDatabase.child("messages").child(messageId).setValue(message)
                    .addOnSuccessListener(aVoid -> {
                        messageInput.setText("");
                        Toast.makeText(SupportActivity.this, "Message sent.", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(SupportActivity.this, "Failed to send message.", Toast.LENGTH_SHORT).show();
                    });
        } else {
            Toast.makeText(this, "Please enter a message.", Toast.LENGTH_SHORT).show();
        }
    }
}
