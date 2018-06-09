package com.example.lap60020_local.retrofit.Presenter;

import com.example.lap60020_local.retrofit.Loader.ISearchLoader;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.ISearchModel;

import java.util.List;

public class SearchPresenter extends Presenter implements IsearchPresenter {

    private ISearchModel MyModel;
    private String Query;
    private boolean isQuery;

    public SearchPresenter(ISearchLoader loader, ISearchModel model) {
        this.MyModel = model;
        this.MyModel.setPresenter(this);
        this.MyModel.setLoader(loader);
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
                        MyModel.queryMore(Query,page);
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

    @Override
    public void query(String squery) {
        // da co data
        if(isQuery) {
            isQuery = false;
            // is not loading and not query mode
            if (!isLoading) {
                Query = squery;
                // lock
                isLoading = true;
                // set page ve vi tri ban dau
                page = 1;
                MyView.addLoading();
                MyModel.query(squery,page);
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
    public void turnOnquery() {
        isQuery = true;
    }
}
