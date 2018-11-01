package com.example.maximovd.weather;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentTest extends Fragment {

    private TextView textViewFragment;
    private Button plus;
    private int counterValue;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("LifeCicleFragment", "Fragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        String instantState;
        if (savedInstanceState == null)
            instantState = getString(R.string.first_launch);
        else instantState = getString(R.string.relaunch);
        Log.i("LifeCicleFragment", "Fragment onCreate " + instantState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initViewsFragment(view);
        setOnIncreaseClickListener();
        String instantState;
        if (savedInstanceState == null)
            instantState = getString(R.string.first_launch);
        else {
            instantState = getString(R.string.relaunch);
        }
        Log.i("LifeCicleFragment", "Fragment onCreateView " + instantState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("LifeCicleFragment", "Fragment onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LifeCicleFragment", "Fragment onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("LifeCicleFragment", "Fragment onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("LifeCicleFragment", "Fragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("LifeCicleFragment", "Fragment onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("LifeCicleFragment", "Fragment onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("LifeCicleFragment", "Fragment onDetach");
    }

    private void initViewsFragment(View view) {
        textViewFragment = view.findViewById(R.id.textView);
        plus = view.findViewById(R.id.plus);
        if (counterValue!=0) textViewFragment.setText(String.valueOf(counterValue));

    }

    private void setOnIncreaseClickListener() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterValue = Integer.parseInt(textViewFragment.getText().toString());
                String text = String.valueOf(++counterValue);
                textViewFragment.setText(text);
            }
        });
    }
}


