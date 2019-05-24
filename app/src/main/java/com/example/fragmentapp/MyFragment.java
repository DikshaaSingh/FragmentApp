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

public class MyFragment extends Fragment {
    private EditText editText;
    private Button buttonOk;
    private MyFragmentListener listener;
    public interface MyFragmentListener{
        void onInputASent(CharSequence input);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_fragment_layout, container, false);
        editText= v.findViewById(R.id.edit_text);
        buttonOk=v.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=editText.getText();
               listener.onInputASent(input);
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
        if (context instanceof MyFragmentListener) {
            listener = (MyFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    +"must implement FragmentAListener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
         listener=null;

    }

}


