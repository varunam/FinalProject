package com.udacity.gradle.builtidbigger;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.testproject.com.jokeslib_android.DisplayJokeActivity;

/**
 * Created by varun.am on 30/09/18
 */
public class MainActivityFragment extends Fragment {
    
    public String joke_loaded = null;
    
    public static MainActivityFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    public MainActivityFragment() {
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        
        return root;
    }

    public void launchJokeActivity(Context context) {
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_KEY, joke_loaded);
        //Toast.makeText(context, loadedJoke, Toast.LENGTH_LONG).show();
        context.startActivity(intent);
        //progressBar.setVisibility(View.GONE);
    }
    
}
