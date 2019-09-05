package nikitaverma.example.com.preferences;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class HelpFragment  extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference2, rootKey);
    }
}
