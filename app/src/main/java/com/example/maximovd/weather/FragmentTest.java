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

    private final String bundleKeyFragment = "bundle_key_fragment";
    private TextView textViewFragment;
    private Button plus;



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
            restoreCounterValue(savedInstanceState);
        }
        Log.i("LifeCicleFragment", "Fragment onCreateView " + instantState);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String instantState;
        if (savedInstanceState == null)
            instantState = getString(R.string.first_launch);
        else instantState = getString(R.string.relaunch);
        Log.i("LifeCicleFragment", "Fragment onCreate " + instantState);
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
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("LifeCicleFragment", "Fragment onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("LifeCicleFragment", "Fragment onActivityCreated");
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(bundleKeyFragment, Integer.parseInt(textViewFragment.getText().toString()));
        super.onSaveInstanceState(outState);
        Log.i("LifeCicleFragment", "Fragment onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("LifeCicleFragment", "Fragment onRestoreInstanceState");
    }

    private void initViewsFragment(View view) {
        textViewFragment = view.findViewById(R.id.textView);
        plus = view.findViewById(R.id.plus);
    }

    private void setOnIncreaseClickListener() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counterValue = Integer.parseInt(textViewFragment.getText().toString());
                String text = String.valueOf(++counterValue);
                textViewFragment.setText(text);
            }
        });
    }
    private void restoreCounterValue(Bundle savedInstanceState) {
        String count = String.valueOf(savedInstanceState.getInt(bundleKeyFragment, 0));
        textViewFragment.setText(count);
    }
}


