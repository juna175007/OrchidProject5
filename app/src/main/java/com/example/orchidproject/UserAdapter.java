package com.example.orchidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
        Context context;
        ArrayList<User> userList;
        private FirebaseServices fbs;



        public UserAdapter(Context context, ArrayList<User> userList) {
            this.context = context;
            this.userList = userList;
            this.fbs = FirebaseServices.getInstance();
        }

        @NonNull
        @Override
        public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View v= LayoutInflater.from(context).inflate(R.layout.useritem,parent,false);
            return  new UserAdapter.MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
            User user = userList.get(position);
            holder.tvName.setText(user.getName());
            holder.tvPhone.setText(user.getPhone());
        }

        @Override
        public int getItemCount(){
            return userList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            TextView tvName, tvPhone;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                tvName=itemView.findViewById(R.id.tvNameUserItem);
                tvPhone=itemView.findViewById(R.id.tvPhoneUserItem);

            }
        }
    }

