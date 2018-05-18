package com.example.thiago.quizproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thiago.quizproject.ListAdapter;
import com.example.thiago.quizproject.R;

public class ListFragment extends Fragment implements ListAdapter.ViewHolderContract {

    public static ListFragment newInstance(){
        Bundle args = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    FragmentContract fragmentContact;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            fragmentContact = (FragmentContract) context;
        }catch (Exception e){

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        RecyclerView rcView = view.findViewById(R.id.fragment_list);
        ListAdapter listAdapter = new ListAdapter(this);
        rcView.setAdapter(listAdapter);
        rcView.setLayoutManager(new LinearLayoutManager(getContext()));
        //return string from my model 
        listAdapter.addNewWord("Rd-D2");
        listAdapter.addNewWord("C3-PO");

        return view;
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
