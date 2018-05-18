package com.example.thiago.quizproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolderVIew>{

    protected List<String> words = new ArrayList<>();
    //delegate
    private ViewHolderContract viewHolderContract;

    //initializing delegate
    public ListAdapter(ViewHolderContract viewHolderContract){
        this.viewHolderContract = viewHolderContract;
    }

    public void addNewWord(String word){
        words.add(word);
        notifyDataSetChanged();
    }

    @Override
    public ListAdapter.MyHolderVIew onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View layout = LayoutInflater.from(context).inflate(R.layout.quiz_item_list, parent, false);
        return new MyHolderVIew(layout);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyHolderVIew holder, int position) {
        //get model
        String word = words.get(position);
        //fill cell
        holder.text_item.setText(word);
        //get reference by view
        View view = holder.itemView;
        //pass to delegate
        view.setOnClickListener(
                viewHolderContract.onClick(view, position)
        );


    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public class MyHolderVIew extends RecyclerView.ViewHolder {

        ImageView image_list;
        TextView text_item;

        public MyHolderVIew(View itemView) {
            super(itemView);
            image_list = itemView.findViewById(R.id.image_list);
            text_item = itemView.findViewById(R.id.text_item);
        }
    }

    //delegate
    public interface ViewHolderContract{
        View.OnClickListener onClick(View view, int position);
    }
}
