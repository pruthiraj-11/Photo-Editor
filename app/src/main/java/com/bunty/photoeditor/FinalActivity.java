package com.bunty.photoeditor;

import static com.bunty.photoeditor.MainActivity.imageUri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bunty.photoeditor.databinding.ActivityFinalBinding;
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;

public class FinalActivity extends AppCompatActivity {

    ActivityFinalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);

        dsPhotoEditorIntent.setData(imageUri);
        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "My Editor");

        int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};
        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);


        startActivityForResult(dsPhotoEditorIntent, 200);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 200:
                    Uri outputUri = data.getData();
                     binding.imageView.setImageURI(outputUri);
                    break;
            }
        }
    }
}