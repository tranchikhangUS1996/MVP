package com.example.lap60020_local.retrofit.Presenter;

import com.example.lap60020_local.retrofit.Loader.MyLoader;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.IModel;

import java.util.List;

public class mPresenter extends Presenter implements mIPresenter {

    IModel MyModel;

    public mPresenter(MyLoader loader, IModel model) {
        this.MyModel = model;
        this.MyModel = model;
        this.MyModel.setPresenter(this);
        this.MyModel.setLoader(loader);
    }

    @Override
    public void load() {
        // da co data
        if(total==0) {
            // is not loading and not query mode
            if (!isLoading) {
                // lock
                isLoading = true;
                MyView.addLoading();
                MyModel.load(page);
            }
        }
        else {
            List<Movie> data = MyModel.getData();
            if(curentThres<NSHOW) {
                curentThres = data.size() > NSHOW ? NSHOW : data.size();
            }
            MyView.restoreData(MyModel.getData(),curentThres);
        }
    }

    @Override
    public void loadMore(int Threshold, int lastVisibleItem) {
        curentThres = lastVisibleItem;
        if(!isLoading) {
            // need load more
            if(Threshold <= lastVisibleItem + 1) {
                isLoading = true;
                if(Threshold == total) {
                    // load from internet
                    page++;
                    if(page<=limit) {
                        MyView.addLoading();
                        MyModel.loadMore(page);
                    } else {
                        isLoading = false;
                    }
                }
                else {
                    // load from list
                    int newthreshold = ((total - Threshold) > NSHOW) ? Threshold + NSHOW : total;
                    // notify
                    MyView.showmore(Threshold, newthreshold);
                    isLoading = false;
                }
            }
        }
    }
}
