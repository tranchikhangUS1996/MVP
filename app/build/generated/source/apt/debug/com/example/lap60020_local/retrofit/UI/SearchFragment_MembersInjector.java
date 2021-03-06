// Generated by Dagger (https://google.github.io/dagger).
package com.example.lap60020_local.retrofit.UI;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class SearchFragment_MembersInjector implements MembersInjector<SearchFragment> {
  private final Provider<MyAdapter> adapterProvider;

  public SearchFragment_MembersInjector(Provider<MyAdapter> adapterProvider) {
    this.adapterProvider = adapterProvider;
  }

  public static MembersInjector<SearchFragment> create(Provider<MyAdapter> adapterProvider) {
    return new SearchFragment_MembersInjector(adapterProvider);
  }

  @Override
  public void injectMembers(SearchFragment instance) {
    injectAdapter(instance, adapterProvider.get());
  }

  public static void injectAdapter(SearchFragment instance, MyAdapter adapter) {
    instance.adapter = adapter;
  }
}
