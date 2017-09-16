package com.example.haeun_kim.hackpretty;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


//프래그먼트
public class RankPagerFragment {

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);

            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            int viewNum = getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView;
            Context context;

            Log.d("SSFF", "지금: " + viewNum);

            try{
                switch(viewNum){
                    case 1:
                        rootView = setFragment1(container, inflater);
                        break;
                    case 2:
                        rootView = setFragment2(container, inflater);
                        break;
                    case 3:
                        rootView = setFragment3(container, inflater);
                        break;
                    default:
                        rootView = setFragment1(container, inflater);
                        break;
                }

            }catch (Exception e){

                rootView = setFragment1(container, inflater);
            }

            return rootView;
        }//onCreateView


        public View setFragment1(ViewGroup container, LayoutInflater inflater){

            View rootView;
            final Context context;

            rootView = inflater.inflate(R.layout.fragment_analysis_layout, container, false);
            context = rootView.getContext();

            PieChart mPieChart = (PieChart) rootView.findViewById(R.id.piechart);

            mPieChart.addPieSlice(new PieModel("Freetime", 75, Color.parseColor("#ff93c0")));
            mPieChart.addPieSlice(new PieModel("Sleep", 25, Color.parseColor("#CCCCCC")));

            mPieChart.startAnimation();

            ProgressBar bar1 = (ProgressBar) rootView.findViewById(R.id.progressBar);
            ProgressBar bar2 = (ProgressBar) rootView.findViewById(R.id.progressBar2);
            ProgressBar bar3 = (ProgressBar) rootView.findViewById(R.id.progressBar3);

            bar1.getProgressDrawable().setColorFilter(
                    Color.rgb(255, 104, 104), android.graphics.PorterDuff.Mode.SRC_IN);

            bar2.getProgressDrawable().setColorFilter(
                    Color.rgb(255, 222, 104), android.graphics.PorterDuff.Mode.SRC_IN);

            bar3.getProgressDrawable().setColorFilter(
                    Color.rgb(140, 237, 135), android.graphics.PorterDuff.Mode.SRC_IN);
            return rootView;
        }

        public View setFragment2(ViewGroup container, LayoutInflater inflater){

            View rootView;
            final Context context;

            rootView = inflater.inflate(R.layout.fragment_ingredient_layout, container, false);
            context = rootView.getContext();
            return rootView;
        }


        public View setFragment3(ViewGroup container, LayoutInflater inflater){

            View rootView;
            final Context context;

            rootView = inflater.inflate(R.layout.fragment_review_layout, container, false);
            context = rootView.getContext();

            FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
            fab.setOnClickListener((v) -> {
                Intent intent = new Intent(getActivity(), ReviewActivity.class);
                startActivity(intent);
            });
            return rootView;
        }


    }
}
