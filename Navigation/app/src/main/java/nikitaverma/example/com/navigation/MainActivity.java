package nikitaverma.example.com.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    AppBarConfiguration appBarConfiguration;
    Activity activity;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Toast.makeText(getApplicationContext(), "Hiii", Toast.LENGTH_LONG).show();

            switch (item.getItemId()) {
                case R.id.transactionFragment:
                    Navigation.findNavController(activity, R.id.nav_host_fragment).navigate(R.id.transactionFragment);

                    break;
                case R.id.chooseReciepeFragment:
//                    if (navGraph != null)
//                        Navigation.findNavController(activity, R.id.nav_host_fragment).;
//                    else
                    Navigation.findNavController(activity, R.id.nav_host_fragment).navigate(R.id.chooseReciepeFragment);
                    //   navGraph = Navigation.findNavController(activity, R.id.nav_host_fragment).;
                    break;
                case R.id.balanceFragment:
                    Navigation.findNavController(activity, R.id.nav_host_fragment).navigate(R.id.balanceFragment);
                    break;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        //  Toolbar toolbar = findViewById(R.id.toolbar);
        //   NavigationUI.setupWithNavController(toolbar,navController, appBarConfiguration);
        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNav, navController);
        NavGraph navGraph = navController.getGraph();
        navController.setGraph(navGraph);

        /*AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(Navigation.findNavController(this, R.id.nav_host_fragment).getGraph()).build();
   */
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.chooseReciepeFragment:
                Toast.makeText(getApplicationContext(), "Hiii", Toast.LENGTH_LONG).show();

        }
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}
