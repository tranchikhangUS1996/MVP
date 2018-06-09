// Generated by Dagger (https://google.github.io/dagger).
package com.example.lap60020_local.retrofit.UI;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class NowPlayingFragment_MembersInjector
    implements MembersInjector<NowPlayingFragment> {
  private final Provider<MyAdapter> adapterProvider;

  public NowPlayingFragment_MembersInjector(Provider<MyAdapter> adapterProvider) {
    this.adapterProvider = adapterProvider;
  }

  public static MembersInjector<NowPlayingFragment> create(Provider<MyAdapter> adapterProvider) {
    return new NowPlayingFragment_MembersInjector(adapterProvider);
  }

  @Override
  public void injectMembers(NowPlayingFragment instance) {
    injectAdapter(instance, adapterProvider.get());
  }

  public static void injectAdapter(NowPlayingFragment instance, MyAdapter adapter) {
    instance.adapter = adapter;
  }
}
