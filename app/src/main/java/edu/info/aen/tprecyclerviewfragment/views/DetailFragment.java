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
import edu.info.aen.tprecyclerviewfragment.databinding.FragmentDetailBinding;
import edu.info.aen.tprecyclerviewfragment.viewmodels.ColorViewModel;

public class DetailFragment extends Fragment {
    ColorViewModel mViewModel;
    FragmentDetailBinding binding;

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
        this.binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mViewModel = new ViewModelProvider(requireActivity()).get(ColorViewModel.class);
        this.binding.rvDetailRvTitle.setText(mViewModel.getSelectedColorTitle());
        this.binding.rvDetailTvSubtitle.setText(mViewModel.getSelectedColorDescription());
        this.binding.rvDetailImage.setImageResource(mViewModel.getSelectedColorImage());
    }
}