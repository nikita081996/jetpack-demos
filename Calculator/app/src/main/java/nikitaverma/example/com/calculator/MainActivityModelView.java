package nikitaverma.example.com.calculator;

import android.view.View;
import android.widget.AdapterView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class MainActivityModelView extends BaseObservable {


    String enterValueEt;

    String calculatedValueTv;

    private int enterSpinner = 3;

    private int calculatedSpinner;

    public String getEnterValueEt() {
        return enterValueEt;
    }

    public void setEnterValueEt(String enterValueEt) {
        this.enterValueEt = enterValueEt;
    }

    @Bindable
    public String getCalculatedValueTv() {
        return calculatedValueTv;
    }

    public void setCalculatedValueTv(String calculatedValueTv) {
        this.calculatedValueTv = calculatedValueTv;
        notifyPropertyChanged(BR.calculatedValueTv);
    }

  /*//  @Bindable
    //Make your variable @Bindable if you need to programmatically change it.
    public int getSelectedItemPosition() {
        return selectedItemPosition;
    }

    public void setSelectedItemPosition(int selectedItemPosition) {
        this.selectedItemPosition = selectedItemPosition;
    }*/

    public void buttonClick(MainActivityModelView mainActivityModelView) {
      //  Toast.makeText(App.getContext(), mainActivityModelView.getEnterSpinner() + "", Toast.LENGTH_LONG).show();
    }

    public int getEnterSpinner() {
        return enterSpinner;
    }

    public void setEnterSpinner(int enterSpinner) {
        this.enterSpinner = enterSpinner;
        if (getEnterValueEt() != null && !getEnterValueEt().isEmpty()) {
            calculate(getEnterValueEt());
        }
    }

    public int getCalculatedSpinner() {
        return calculatedSpinner;
    }

    public void setCalculatedSpinner(int calculatedSpinner) {
        this.calculatedSpinner = calculatedSpinner;
        if (getEnterValueEt() != null && !getEnterValueEt().isEmpty()) {
            calculate(getEnterValueEt());
        }
    }

    public void onTextChanged(CharSequence c, int start, int end, int count) {
        //   Toast.makeText(App.getContext(), c+ " "+ start+" "+ end+" "+ count, Toast.LENGTH_LONG).show();
        String s = c + "";
        if (!s.isEmpty())
            calculate(s);
        else
            setCalculatedValueTv("");

    }

    void calculate(String s) {
        float f = Float.parseFloat(s);
        if (s.isEmpty()) {
            return;
        }
        if (getEnterSpinner() < getCalculatedSpinner()) {
            int diff = getCalculatedSpinner() - getEnterSpinner();
            int mul = 1;
            while (diff > 0) {
                mul = mul * 10;
                diff--;
            }
            float cal = f * mul;
            String cal1 = cal + "";
            setCalculatedValueTv(cal1);
        } else if (getEnterSpinner() > getCalculatedSpinner()) {
            int diff = getEnterSpinner() - getCalculatedSpinner();
            int mul = 1;
            while (diff > 0) {
                mul = mul * 10;
                diff--;
            }
            float cal = f / mul;
            String cal1 = cal + "";
            setCalculatedValueTv(cal1);
        } else {
            setCalculatedValueTv(s);
        }

    }

    public void OnCalculatedSpinnerSelectItem(AdapterView<?> parent, View view, int position, long id) {
        setCalculatedSpinner(position);
     //   Toast.makeText(App.getContext(), position + " CalculatedSpinner", Toast.LENGTH_LONG).show();
    }

    public void OnEnterSpinnerSelectItem(AdapterView<?> parent, View view, int position, long id) {
        setEnterSpinner(position);
     //   Toast.makeText(App.getContext(), position + " EnterSpinner", Toast.LENGTH_LONG).show();
    }

}
