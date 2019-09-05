package nikitaverma.example.com.handlinglifecycleswithlifecycle_awarecomponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;


public class MainActivityObserver implements LifecycleObserver {
    String TAG = this.getClass().getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        Log.i(TAG, "Observer_OnCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart(){
        Log.i(TAG, "Observer_onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(){
        Log.i(TAG, "Observer_onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(){
        Log.i(TAG, "Observer_onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(){
        Log.i(TAG, "Observer_onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(){
        Log.i(TAG, "Observer_onDestroy");
    }
}
