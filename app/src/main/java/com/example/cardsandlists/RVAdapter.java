package com.example.cardsandlists;

/**
 * Created by jeevansai on 18/10/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;


import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    Context ctx;
    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        List<Person> personss=new ArrayList<Person>();
        CardView cv;
        Context ctx;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView,Context ctx,List<Person> personss) {
            super(itemView);
            this.ctx=ctx;
            this.personss=personss;
            itemView.setOnClickListener(this);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Person pers=this.personss.get(position);
            Intent i=new Intent(this.ctx,PersonDetails.class);
            i.putExtra("image_id",pers.photoId);
            i.putExtra("name",pers.name);
            i.putExtra("age",pers.age);
            this.ctx.startActivity(i);
        }
    }

    List<Person> persons;

    RVAdapter(List<Person> persons, Context ctx){
        this.persons = persons;
        this.ctx=ctx;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v,ctx,persons);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}