package com.example.abel.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adaptercls extends RecyclerView.Adapter<Adaptercls.MyViewHolder> {

    Context c;
    ArrayList<Holdercls> holder;
    public Adapter(Context c,ArrayList<Holdercls> h){
        holder=h;
        c=this.c;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(c).inflate(R.layout.cardview,parent,attachToRoot:false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.name.setText(holder.get(Position).getName());
        holder.email.setText(holder.get(Position).getEmail());
        holder.username.setText(holder.get(Position).getUsername());
        holder.mobile.setText(holder.get(Position).getMobile());
        holder.gender.setText(holder.get(Position).getGender());
    }

    @Override
    public int getItemCount() {
        return holder.size;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
 TextView email,name,gender,username,mobile;
      username=( TextView)itemView.findViewById(R.id.username3);
        gender=( TextView)itemView.findViewById(R.id.gender3);
        email=( TextView)itemView.findViewById(R.id.emial3);
        mobile=( TextView)itemView.findViewById(R.id.mobile3);
        name=( TextView)itemView.findViewById(R.id.name3);


       public MyViewHolder(View itemView) {
           super(itemView);
       }
   }



}
