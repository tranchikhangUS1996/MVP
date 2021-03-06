// Generated by Dagger (https://google.github.io/dagger).
package com.example.lap60020_local.retrofit.DI.Module;

import com.example.lap60020_local.retrofit.Loader.TopRatedLoader;
import com.example.lap60020_local.retrofit.Model.IModel;
import com.example.lap60020_local.retrofit.Presenter.mIPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MyAdapterModule_ProvideTopPresenterFactory implements Factory<mIPresenter> {
  private final MyAdapterModule module;

  private final Provider<TopRatedLoader> topRatedLoaderProvider;

  private final Provider<IModel> modelProvider;

  public MyAdapterModule_ProvideTopPresenterFactory(
      MyAdapterModule module,
      Provider<TopRatedLoader> topRatedLoaderProvider,
      Provider<IModel> modelProvider) {
    this.module = module;
    this.topRatedLoaderProvider = topRatedLoaderProvider;
    this.modelProvider = modelProvider;
  }

  @Override
  public mIPresenter get() {
    return provideInstance(module, topRatedLoaderProvider, modelProvider);
  }

  public static mIPresenter provideInstance(
      MyAdapterModule module,
      Provider<TopRatedLoader> topRatedLoaderProvider,
      Provider<IModel> modelProvider) {
    return proxyProvideTopPresenter(module, topRatedLoaderProvider.get(), modelProvider.get());
  }

  public static MyAdapterModule_ProvideTopPresenterFactory create(
      MyAdapterModule module,
      Provider<TopRatedLoader> topRatedLoaderProvider,
      Provider<IModel> modelProvider) {
    return new MyAdapterModule_ProvideTopPresenterFactory(
        module, topRatedLoaderProvider, modelProvider);
  }

  public static mIPresenter proxyProvideTopPresenter(
      MyAdapterModule instance, TopRatedLoader topRatedLoader, IModel model) {
    return Preconditions.checkNotNull(
        instance.provideTopPresenter(topRatedLoader, model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
