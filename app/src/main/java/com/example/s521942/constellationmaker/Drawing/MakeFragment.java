package com.example.s521942.constellationmaker.Drawing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.s521942.constellationmaker.R;
import com.example.s521942.constellationmaker.Viewer.Drawings;

import static com.example.s521942.constellationmaker.R.layout.fragment_makenview;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MakeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MakeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MakeFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    DrawView drawView;
    View v=null;
    Button clear,save;
   // Drawings drawings=new Drawings();
    public Drawings.DrawItem drawItem;
    public Drawings drawings=new Drawings();
    //RadioButton red,blue,green;
    RadioGroup radioGroup;
    EditText nameEt;
    String name;

    private Context globalContext = null;
   // Activity activity;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MakeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MakeFragment newInstance(String param1, String param2) {
        MakeFragment fragment = new MakeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MakeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        globalContext = this.getActivity().getApplicationContext();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//     drawView=new DrawView(globalContext);
//        return drawView;

        v=inflater.inflate(fragment_makenview,container,false);
        clear=(Button)v.findViewById(R.id.ClearB);
        clear.setOnClickListener(this);

        nameEt=(EditText)v.findViewById(R.id.Et);

        //Toast.makeText()

        save=(Button)v.findViewById(R.id.SaveB);
        save.setOnClickListener(this);


        drawView=(DrawView)v.findViewById(R.id.DrawV);



        //drawView.setFocusableInTouchMode(true);
       // drawView.onTouch(this,MotionEvent);
       drawView.requestFocus();
        radioGroup=(RadioGroup)v.findViewById(R.id.radiogrp);
        radioGroup.setOnCheckedChangeListener(new radiocheckListener());

        return v;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        //drawView.requestFocus();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        name=nameEt.getText().toString();
        switch (v.getId()) {
            case R.id.ClearB:
                drawView.clearCanvas();
                break;
            case R.id.SaveB:
                if(name.equals("")){

                    Toast.makeText(getActivity(),"Enter name",Toast.LENGTH_LONG).show();
                    break;

                }
                else{


                    Drawings.addItem(new Drawings.DrawItem(name,drawView.pointList));
                    Toast.makeText(getActivity(),"item added",Toast.LENGTH_LONG).show();
                    ////drawView.earaseCanvas();
                }
                break;
        }

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        //public void clear(View v);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  drawView.requestFocus();
    }
    public class radiocheckListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.RbB:
                    drawView.paint.setColor(Color.BLUE);
                    break;
                case R.id.RbG:
                    drawView.paint.setColor(Color.GREEN);
                    break;
                case R.id.RbR:
                    drawView.paint.setColor(Color.RED);
                    break;
                default:
                    drawView.paint.setColor(Color.RED);
                    break;
            }

        }
    }
   // public void saveDrawing

}
