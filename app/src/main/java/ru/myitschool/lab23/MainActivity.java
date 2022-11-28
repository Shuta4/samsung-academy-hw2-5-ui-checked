package ru.myitschool.lab23;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Checkable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ui-checked";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        CoordinatorLayout root = binding.getRoot();
        setContentView(root);
        binding.showAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder text = new StringBuilder();
                for (short i = 0; i < root.getChildCount(); i++) {
                    View view = root.getChildAt(i);
                    String viewId = getId(view);
                    Log.d(TAG, "viewId: " + viewId);
                    if (viewId.equals("ru.myitschool.lab23:id/chip_material")) {
                        text.append(checkableInformation(
                                (Checkable) view, getResources().getString(R.string.chip_material))
                            ).append("\n");
                    }
                    if (viewId.equals("ru.myitschool.lab23:id/check_box_material")) {
                        text.append(checkableInformation(
                                (Checkable) view, getResources().getString(R.string.check_box_material))
                        ).append("\n");
                    }
                    if (viewId.equals("ru.myitschool.lab23:id/switch_material")) {
                        text.append(checkableInformation(
                                (Checkable) view, getResources().getString(R.string.switch_material))
                        ).append("\n");
                    }
                    if (viewId.equals("ru.myitschool.lab23:id/toggle_button")) {
                        text.append(checkableInformation(
                                (Checkable) view, getResources().getString(R.string.toggle_button))
                        ).append("\n");
                    }
                }
                binding.summaryText.setText(text.toString());
            }
        });
    }

    private static String getId(View view) {
        if (view.getId() == View.NO_ID) return "no-id";
        else return view.getResources().getResourceName(view.getId());
    }

    private static String checkableInformation(Checkable checkable, String cannonicalName) {
        return cannonicalName + ":" + checkable.isChecked();
    }
}
