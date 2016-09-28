package com.word.swag.text.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.word.swag.text.Activity.MainActivity;
import com.word.swag.text.R;
import com.word.swag.text.StringText.Calculate;

/**
 * Created by ThanhDat on 12/31/15.
 */
public class InputTextFragmentNew extends DialogFragment implements View.OnClickListener,
        TextWatcher{

    private TextView tv_cancel;
    private TextView tv_done;
    private TextView tv_count_text;
    private EditText edt_input_text;
    private View vi_delete_text;
    private Context context = getActivity();

    public static InputTextFragmentNew newInstance(){
        return new InputTextFragmentNew();
    }

    public OnSentTextListener mListener;

    public interface OnSentTextListener{
        public void OnSentText(String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnSentTextListener) {
            mListener = (OnSentTextListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_text, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        init(getView());
        getTextToActivity();
        showKeyboard();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    public void init(View view){
        tv_cancel = (TextView)view.findViewById(R.id.tv_cancel);
        tv_done = (TextView)view.findViewById(R.id.tv_done);
        tv_count_text = (TextView)view.findViewById(R.id.tv_count_text);
        edt_input_text = (EditText)view.findViewById(R.id.edt_input_text);
        vi_delete_text = (View)view.findViewById(R.id.vi_delete_text);
        tv_cancel.setOnClickListener(this);
        tv_done.setOnClickListener(this);
        edt_input_text.setOnClickListener(this);
        vi_delete_text.setOnClickListener(this);
        edt_input_text.addTextChangedListener(this);
        edt_input_text.requestFocus();
        edt_input_text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cancel:
                hideKeyboard(getActivity());
                getFragmentManager().popBackStack();
                break;
            case R.id.tv_done:
                MatchingText();
                break;
            case R.id.edt_input_text:
                break;
            case R.id.vi_delete_text:
                if (edt_input_text.getText() != null) edt_input_text.setText("");
                break;
        }
    }

    public void getTextToActivity(){
        String text = getArguments().getString("text");
        if (text == "DOUBLE TAB TO EDIT TEXT HERE"){
            edt_input_text.setText("");
        }else {
            edt_input_text.setText(text);
        }
    }

    public void showKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager)
                MainActivity.getmContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(edt_input_text, InputMethodManager.SHOW_IMPLICIT);
        edt_input_text.setSelection(edt_input_text.getText().length());
    }

    public void hideKeyboard(Activity activity){

        InputMethodManager inputMethodManager = (InputMethodManager)
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if(view == null) {
            view = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void CheckTextBeginSent(){
        if (Calculate.countSpace(edt_input_text.getText().toString()) == 0){
            edt_input_text.getText().insert(edt_input_text.length(), " ");
            mListener.OnSentText(edt_input_text.getText().toString());
        }else {
            mListener.OnSentText(edt_input_text.getText().toString());
        }
    }


    public void MatchingText(){
        if (edt_input_text.getText().toString().isEmpty()){
            showDialogError();
            hideKeyboard(getActivity());
        }else {
            CheckTextBeginSent();
            hideKeyboard(getActivity());
            getFragmentManager().popBackStack();
            mListener.OnSentText(edt_input_text.getText().toString());
        }
    }

    public void showDialogError(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Please input text from here!")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showKeyboard();
                    }
                });
                builder.create();
                builder.show();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        tv_count_text.setText(String.valueOf(charSequence.length()));
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }
}
