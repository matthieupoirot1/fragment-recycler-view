package edu.info.aen.tprecyclerviewfragment.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.info.aen.tprecyclerviewfragment.R;
import edu.info.aen.tprecyclerviewfragment.viewmodels.ColorViewModel;

public class DetailFragment extends Fragment {
    ColorViewModel mViewModel;
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mViewModel = new ViewModelProvider(requireActivity()).get(ColorViewModel.class);
        TextView titleTv = requireView().findViewById(R.id.rv_detail_rv_title);
        TextView descriptionTv = requireView().findViewById(R.id.rv_detail_tv_subtitle);
        ImageView image = requireView().findViewById(R.id.rv_detail_image);

        titleTv.setText(mViewModel.getSelectedColorTitle());
        descriptionTv.setText(mViewModel.getSelectedColorDescription());
        image.setImageResource(mViewModel.getSelectedColorImage());
    }
}