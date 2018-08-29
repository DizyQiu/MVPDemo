package com.comwave.mvpdemo;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

public class PresenterComl implements IPresenter {
    private IShowView iShowView;

    public PresenterComl(IShowView iShowView){
        this.iShowView = iShowView;
    }


    @SuppressLint("StaticFieldLeak")
    @Override
    public void show() {
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                for(int i=0;i<10;i++){
                    Log.i("MVPS:","正在下载...预计剩余时间 " + (10 - i) + "秒");
                    SystemClock.sleep(1000);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                iShowView.show("Hello MVP!");
            }
        }.execute();

    }

    @Override
    public void showToast() {
        iShowView.shoeToast("This is Show Toast");

    }
}
