package com.kalexia.compattoast_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kalexia.toastlib.toast.CompatToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void makeText(View v){
//        CompatToast.makeText(this,"Toast.makeText", Toast.LENGTH_SHORT).show();
        ToastUtils.makeText("makeToast---text");
    }

    public void makeDrawable(View v){
//        View inflate = getLayoutInflater().inflate(R.layout.view_toast, null);
//        CompatToast.makeView(this,inflate,Toast.LENGTH_SHORT).show();
        ToastUtils.makeText(R.drawable.succ,"drawable");

    }

    public void makeView(View v){
        View inflate = getLayoutInflater().inflate(R.layout.view_custom_toast, null);

        ToastUtils.makeCustomView(inflate);


    }
}
