package com.example.thiago.quizproject.fragments;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thiago.quizproject.ListAdapter;
import com.example.thiago.quizproject.R;
import com.example.thiago.quizproject.model.Question;

public class ListFragment extends Fragment implements ListAdapter.ViewHolderContract {

    public static ListFragment newInstance(){
        Bundle args = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    FragmentContract fragmentContact;

    TextView textView;
    ImageView imageView;
    RecyclerView rcView;
    ListAdapter listAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            fragmentContact = (FragmentContract) context;
        }catch (Exception e){

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        //set text question
        textView = view.findViewById(R.id.textview_question);
        //set propertly image question
        imageView = view.findViewById(R.id.image_question);
        //set items
        listAdapter = new ListAdapter(this);
        //
        rcView = view.findViewById(R.id.fragment_list);
        rcView.setAdapter(listAdapter);
        rcView.setLayoutManager(new LinearLayoutManager(getContext()));
        //return string from my model
        return view;
    }

    public void setQuestion(Question question){
        listAdapter.cleanList();
        textView.setText(question.getDesriptionQuestion());
        imageView.setBackgroundColor(Color.parseColor("#e74c3c"));
        for(int i = 0; i < question.getItems().size(); i++){
            listAdapter.addNewWord(question.getItems().get(i).getDescriptionItem());
            //put the item icon
        }
    }

    @Override
    public View.OnClickListener onClick(View view, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContact.selectIndex(position);
            }
        };// return item model
    }

}
