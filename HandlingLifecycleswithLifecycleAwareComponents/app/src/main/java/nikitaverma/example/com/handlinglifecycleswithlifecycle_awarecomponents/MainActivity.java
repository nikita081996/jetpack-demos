package nikitaverma.example.com.handlinglifecycleswithlifecycle_awarecomponents;

import android.arch.lifecycle.LifecycleOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MainActivityObserver());
        Log.i(TAG, "Owner_OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Owner_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Owner_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Owner_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Owner_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Owner_onDestroy");
    }


}
