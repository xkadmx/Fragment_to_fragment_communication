package com.example.fragment_to_fragment_communication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SelectorFragment extends Fragment implements View.OnClickListener, KeyListener {
    private static final String TAG = "SelectorFragment";

    //widgets
    private Button btnFragmentA, btnFragmentB, btnFragmentC;
    private EditText mMessage;
    //vars

    private IMainActivity mIMainActivity;


    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMainActivity.setToolbarTitle(getTag());
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector, container, false);

        mMessage = view.findViewById(R.id.message);
        btnFragmentA = view.findViewById(R.id.btn_fragment_a);
        btnFragmentB = view.findViewById(R.id.btn_fragment_b);
        btnFragmentC = view.findViewById(R.id.btn_fragment_c);

        btnFragmentA.setKeyListener(this);
        btnFragmentB.setKeyListener(this);
        btnFragmentC.setKeyListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        String message = mMessage.getText().toString();
        switch (view.getId()){
            case R.id.btn_fragment_a :{
                mIMainActivity.inflateFragment(getTag(), message);

                break;
            }
            case R.id.btn_fragment_b :{
                break;
            }
            case R.id.btn_fragment_c     :{
                break;
            }
        }


    }
    @Override public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity) getActivity();
    }


    @Override public int getInputType() {
        return 0;
    }

    @Override public boolean onKeyDown(View view, Editable text, int keyCode, KeyEvent event) {
        return false;
    }

    @Override public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
        return false;
    }

    @Override public boolean onKeyOther(View view, Editable text, KeyEvent event) {
        return false;
    }

    @Override public void clearMetaKeyState(View view, Editable content, int states) {

    }
}
