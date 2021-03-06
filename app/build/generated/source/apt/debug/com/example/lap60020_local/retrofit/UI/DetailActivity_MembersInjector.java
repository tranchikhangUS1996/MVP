// Generated by Dagger (https://google.github.io/dagger).
package com.example.lap60020_local.retrofit.UI;

import com.example.lap60020_local.retrofit.Model.Data.MyApi;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DetailActivity_MembersInjector implements MembersInjector<DetailActivity> {
  private final Provider<MyApi> apiProvider;

  public DetailActivity_MembersInjector(Provider<MyApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  public static MembersInjector<DetailActivity> create(Provider<MyApi> apiProvider) {
    return new DetailActivity_MembersInjector(apiProvider);
  }

  @Override
  public void injectMembers(DetailActivity instance) {
    injectApi(instance, apiProvider.get());
  }

  public static void injectApi(DetailActivity instance, MyApi api) {
    instance.api = api;
  }
}
