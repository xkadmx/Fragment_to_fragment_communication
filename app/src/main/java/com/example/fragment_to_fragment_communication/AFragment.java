package com.example.fragment_to_fragment_communication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AFragment extends Fragment {





    private static final String TAG = "AFragment";
    //widgets
    private TextView mDisplayMessage;



    //vars

    private IMainActivity iMainActivity;
    private String mIncommingMessage = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMainActivity.setToolbarTitle(getTag());

        Bundle bundle = this.getArguments();
        if(bundle != null){
            mIncommingMessage = bundle.getString(getString(R.string.intent_message));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        mDisplayMessage = view.findViewById(R.id.incomming_message);

        setIncommingMessage();
        return view;
    }

    private void  setmIncommingMessage(){
        if(!mIncommingMessage.equals("")){
            mDisplayMessage.setText(mIncommingMessage);
        }
    }
    @Override public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (MainActivity) getActivity();
    }
}
