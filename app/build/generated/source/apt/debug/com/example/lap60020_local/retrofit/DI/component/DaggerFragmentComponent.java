// Generated by Dagger (https://google.github.io/dagger).
package com.example.lap60020_local.retrofit.DI.component;

import com.example.lap60020_local.retrofit.DI.Module.AdapterModule;
import com.example.lap60020_local.retrofit.DI.Module.AdapterModule_ProvideAdapterFactory;
import com.example.lap60020_local.retrofit.DI.Module.AdapterModule_ProvideLinearlayoutManagerFactory;
import com.example.lap60020_local.retrofit.UI.MyAdapter;
import com.example.lap60020_local.retrofit.UI.NowPlayingFragment;
import com.example.lap60020_local.retrofit.UI.NowPlayingFragment_MembersInjector;
import com.example.lap60020_local.retrofit.UI.PopularFragment;
import com.example.lap60020_local.retrofit.UI.PopularFragment_MembersInjector;
import com.example.lap60020_local.retrofit.UI.SearchFragment;
import com.example.lap60020_local.retrofit.UI.SearchFragment_MembersInjector;
import com.example.lap60020_local.retrofit.UI.TopRatedFragment;
import com.example.lap60020_local.retrofit.UI.TopRatedFragment_MembersInjector;
import com.example.lap60020_local.retrofit.UI.UpComingFragment;
import com.example.lap60020_local.retrofit.UI.UpComingFragment_MembersInjector;
import dagger.internal.Preconditions;

public final class DaggerFragmentComponent implements FragmentComponent {
  private AdapterModule adapterModule;

  private DaggerFragmentComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  private MyAdapter getMyAdapter() {
    return AdapterModule_ProvideAdapterFactory.proxyProvideAdapter(
        adapterModule,
        AdapterModule_ProvideLinearlayoutManagerFactory.proxyProvideLinearlayoutManager(
            adapterModule));
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.adapterModule = builder.adapterModule;
  }

  @Override
  public void inject(PopularFragment fragment) {
    injectPopularFragment(fragment);
  }

  @Override
  public void inject(TopRatedFragment fragment) {
    injectTopRatedFragment(fragment);
  }

  @Override
  public void inject(UpComingFragment fragment) {
    injectUpComingFragment(fragment);
  }

  @Override
  public void inject(NowPlayingFragment fragment) {
    injectNowPlayingFragment(fragment);
  }

  @Override
  public void inject(SearchFragment fragment) {
    injectSearchFragment(fragment);
  }

  private PopularFragment injectPopularFragment(PopularFragment instance) {
    PopularFragment_MembersInjector.injectAdapter(instance, getMyAdapter());
    return instance;
  }

  private TopRatedFragment injectTopRatedFragment(TopRatedFragment instance) {
    TopRatedFragment_MembersInjector.injectAdapter(instance, getMyAdapter());
    return instance;
  }

  private UpComingFragment injectUpComingFragment(UpComingFragment instance) {
    UpComingFragment_MembersInjector.injectAdapter(instance, getMyAdapter());
    return instance;
  }

  private NowPlayingFragment injectNowPlayingFragment(NowPlayingFragment instance) {
    NowPlayingFragment_MembersInjector.injectAdapter(instance, getMyAdapter());
    return instance;
  }

  private SearchFragment injectSearchFragment(SearchFragment instance) {
    SearchFragment_MembersInjector.injectAdapter(instance, getMyAdapter());
    return instance;
  }

  public static final class Builder {
    private AdapterModule adapterModule;

    private Builder() {}

    public FragmentComponent build() {
      if (adapterModule == null) {
        throw new IllegalStateException(AdapterModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerFragmentComponent(this);
    }

    public Builder adapterModule(AdapterModule adapterModule) {
      this.adapterModule = Preconditions.checkNotNull(adapterModule);
      return this;
    }
  }
}