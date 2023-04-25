package com.devestan.ciia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    List<Message> messagelist;

    public MessageAdapter(List<Message> messageList){
        this.messagelist = messageList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatview = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, null);
        return new MyViewHolder(chatview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Message message = messagelist.get(position);
    if (message.getSentBy().equals(Message.SENT_BY_ME)){
        holder.leftChatView.setVisibility(View.GONE);
        holder.rightChatView.setVisibility(View.VISIBLE);
        holder.txtChatViewRight.setText(message.getMessage());
    } else {
        holder.rightChatView.setVisibility(View.GONE);
        holder.leftChatView.setVisibility(View.VISIBLE);
        holder.txtChatViewLeft.setText(message.getMessage());
    }
    }

    @Override
    public int getItemCount() {
        return messagelist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        LinearLayout leftChatView, rightChatView;
        TextView txtChatViewLeft, txtChatViewRight;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            leftChatView = itemView.findViewById(R.id.leftChatView);
            rightChatView = itemView.findViewById(R.id.rightChatView);
            txtChatViewLeft = itemView.findViewById(R.id.txtChatViewLeft);
            txtChatViewRight = itemView.findViewById(R.id.txtChatViewRight);
        }
    }
}
