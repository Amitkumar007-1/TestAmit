package Loader;

import android.app.ProgressDialog;
import android.content.Context;

public class Loader extends ProgressDialog {
    public Loader(Context context) {
        super(context);
        setMessage("Please wait...");
        setCancelable(false);
    }

}
