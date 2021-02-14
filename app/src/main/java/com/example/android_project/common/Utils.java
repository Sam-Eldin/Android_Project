package com.example.android_project.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public final class Utils
{

    static Utils mInstance;
    private Utils(){}

    public static byte[] ImageToByteArray(String ImagePath){
        Bitmap bitmap = BitmapFactory.decodeFile(ImagePath);
        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100 /* Ignored for PNGs */, blob);
        return blob.toByteArray();
    }
    public static Bitmap BitmapFromBytes(byte[] bitmapdata){
        return BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
    }


/**
    // convert from bitmap to byte array
    public static byte[] getBytes(ImageButton bitmap) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] data = stream.toByteArray();
//        Uri imageUri = imageReturnedIntent.getData();
//        InputStream imageStream = getContentResolver().openInputStream(imageUri);
//        Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
//        bitmap.setImageBitmap(selectedImage);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        selectedImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byte[] data = stream.toByteArray();

        return data;

    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

 */

}

