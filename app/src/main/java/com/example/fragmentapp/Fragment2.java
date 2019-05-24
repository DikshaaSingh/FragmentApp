package com.example.fragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentapp.R;

public class Fragment2 extends Fragment {
    private EditText editText;
    private Button buttonOk;
    private Fragment2Listener listener;
    public interface  Fragment2Listener{
        void onInputBSent(CharSequence input);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, container, false);
        editText= v.findViewById(R.id.edit_text);
        buttonOk=v.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=editText.getText();
                listener.onInputBSent(input);
            }
        });
        return  v;
    }
    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  Fragment2Listener) {
            listener = ( Fragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    +"must implement  Fragment2Listener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;

    }

}
