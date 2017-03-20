package se.quizmaniacs.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.quizmaniacs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InGameSpinFragment extends Fragment {


    public InGameSpinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spin, container, false);
    }

}
