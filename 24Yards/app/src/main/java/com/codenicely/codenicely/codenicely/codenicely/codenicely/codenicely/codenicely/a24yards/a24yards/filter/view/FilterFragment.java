package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.filter.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view.HomeActivity;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.presenter.SearchPresenter;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.presenter.SearchPresenterImpl;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.provider.RetrofitSearchProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.view.SearchView;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FilterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterFragment extends Fragment implements SearchView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    private List<String> bedroom_list =  new ArrayList<String>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String loc,locality;
    private CheckBox bhk_1,bhk_2,bhk_3,bhk_4,bhk_5plus;
    private EditText locality_etxt;
    private TextView search_text,min_price,max_price,lacs,crores;
    private RadioButton radioButton;
    private int minValue_int,maxValue_int;
    private Button btn_filter;
    private CardView card_search_filter;
    private Toolbar toolbar;

    private SearchPresenter searchPresenter;

    private OnFragmentInteractionListener mListener;

    public FilterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilterFragment newInstance(String param1, String param2) {
        FilterFragment fragment = new FilterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        initialize(view);
        toolbar.setTitle("Filter");
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(),R.color.white));
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getContext(),R.drawable.back_arrow_ic_white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(), HomeActivity.class);
                startActivity(i);

            }
        });
  /*
        card_search_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                            .build(getActivity());
                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
                } catch (GooglePlayServicesRepairableException e) {
                    // TODO: Handle the error.
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    // TODO: Handle the error.
                    e.printStackTrace();
                }

            }
        });
*/
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) view.findViewById(R.id.rangeSeekbar);
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                minValue_int = Integer.parseInt(minValue.toString());
                maxValue_int = Integer.parseInt(maxValue.toString());
                if (minValue_int >= 100){
                    rangeSeekbar.setSteps(100);
                    lacs.setText("Crores");
                    min_price.setText(String.valueOf(minValue_int/100));
                }
                else{
                    lacs.setText("Lacs");
                    rangeSeekbar.setSteps(5);
                }
                if (maxValue_int >= 100){
                    rangeSeekbar.setSteps(100);
                    max_price.setText(String.valueOf(maxValue_int/100));
                }
                else{
                    rangeSeekbar.setSteps(5);
                    crores.setText("Lacs");
                }
            }
        });

        bhk_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bhk_1.isChecked()){
                    bedroom_list.add(bhk_1.getText().toString());
                }
            }
        });

        bhk_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bhk_2.isChecked()){
                    bedroom_list.add(bhk_2.getText().toString());
                }
            }
        });

        bhk_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bhk_3.isChecked()){
                    bedroom_list.add(bhk_3.getText().toString());
                }
            }
        });

        bhk_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bhk_4.isChecked()){
                    bedroom_list.add(bhk_4.getText().toString());
                }
            }
        });
        bhk_5plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bhk_5plus.isChecked()){
                    bedroom_list.add(bhk_5plus.getText().toString());
                }
            }
        });

        locality = locality_etxt.getText().toString().trim();
        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPresenter = new SearchPresenterImpl(new RetrofitSearchProvider(),FilterFragment.this);
                searchPresenter.getSearchData("",loc,min_price.getText().toString(),max_price.getText().toString(),bedroom_list,"");
            }
        });

        return view;
    }

    public void initialize(View view){
        card_search_filter = (CardView) view.findViewById(R.id.card_search_filter);
       // search_text = (TextView) view.findViewById(R.id.search_txt_filter);
        locality_etxt = (EditText) view.findViewById(R.id.locality_filter);
        bhk_1 = (CheckBox) view.findViewById(R.id.checkbox1_bhk);
        bhk_2 = (CheckBox) view.findViewById(R.id.checkbox2_bhk);
        bhk_3 = (CheckBox) view.findViewById(R.id.checkbox3_bhk);
        bhk_4 = (CheckBox) view.findViewById(R.id.checkbox4_bhk);
        bhk_5plus = (CheckBox) view.findViewById(R.id.checkbox5plus_bhk);
        min_price = (TextView) view.findViewById(R.id.min_txt);
        max_price = (TextView) view.findViewById(R.id.max_txt);
        lacs = (TextView) view.findViewById(R.id.txt_lacs);
        crores = (TextView) view.findViewById(R.id.txt_crores);
        btn_filter = (Button) view.findViewById(R.id.filter_btn);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar_filter);

    }


/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Place place = PlaceAutocomplete.getPlace(getContext(),data);
                Log.i(TAG, "Place: " + place.getName());
                loc = place.getName().toString();
                search_text.setText(loc);
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(getContext(), data);
                // TODO: Handle the error.
                Log.i(TAG, status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }

        }
    }
    */

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @Override
    public void showSearchStatus(boolean status) {

    }

    @Override
    public void showError(String message) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
