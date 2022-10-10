package edu.info.aen.tprecyclerviewfragment.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import edu.info.aen.tprecyclerviewfragment.MainActivity;
import edu.info.aen.tprecyclerviewfragment.R;
import edu.info.aen.tprecyclerviewfragment.RvDetailActivity;
import edu.info.aen.tprecyclerviewfragment.adapters.CouleursAdapter;
import edu.info.aen.tprecyclerviewfragment.viewmodels.ColorViewModel;

public class RvFragment extends Fragment {

    ColorViewModel mViewModel;

    public RvFragment() {
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
        return inflater.inflate(R.layout.fragment_rv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.mViewModel = new ViewModelProvider(requireActivity()).get(ColorViewModel.class);

        int[] images = {R.drawable.rouge, R.drawable.vert, R.drawable.bleu, R.drawable.jaune, R.drawable.orange, R.drawable.violet, R.drawable.rose, R.drawable.marron, R.drawable.gris, R.drawable.cyan};
        String[] titles = getResources().getStringArray(R.array.couleur);
        String[] descriptions = getResources().getStringArray(R.array.description);
        RecyclerView recyclerView = requireView().findViewById(R.id.rv_couleurs);
        CouleursAdapter adapter = new CouleursAdapter(getContext(), titles, descriptions, images);
        adapter.setListener(position -> {
            mViewModel.setSelectedColorTitle(titles[position]);
            mViewModel.setSelectedColorImage(images[position]);
            mViewModel.setSelectedColorDescription(descriptions[position]);
            Navigation.findNavController(view).navigate(R.id.action_rvFragment_to_detailFragment);
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}