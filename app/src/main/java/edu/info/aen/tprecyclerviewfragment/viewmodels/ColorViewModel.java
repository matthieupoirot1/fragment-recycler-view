package edu.info.aen.tprecyclerviewfragment.viewmodels;

import androidx.lifecycle.ViewModel;

public class ColorViewModel extends ViewModel {
    private String selectedColorTitle = "";
    private int selectedColorImage = -1;
    private String selectedColorDescription = "";

    public String getSelectedColorTitle() {
        return selectedColorTitle;
    }

    public void setSelectedColorTitle(String selectedColorTitle) {
        this.selectedColorTitle = selectedColorTitle;
    }

    public int getSelectedColorImage() {
        return selectedColorImage;
    }

    public void setSelectedColorImage(int selectedColorImage) {
        this.selectedColorImage = selectedColorImage;
    }

    public String getSelectedColorDescription() {
        return selectedColorDescription;
    }

    public void setSelectedColorDescription(String selectedColorDescription) {
        this.selectedColorDescription = selectedColorDescription;
    }
}
