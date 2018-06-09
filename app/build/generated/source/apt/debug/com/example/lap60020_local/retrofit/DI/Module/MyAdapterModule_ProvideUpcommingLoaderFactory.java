// Generated by Dagger (https://google.github.io/dagger).
package com.example.lap60020_local.retrofit.DI.Module;

import com.example.lap60020_local.retrofit.Loader.UpcomingLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class MyAdapterModule_ProvideUpcommingLoaderFactory
    implements Factory<UpcomingLoader> {
  private final MyAdapterModule module;

  public MyAdapterModule_ProvideUpcommingLoaderFactory(MyAdapterModule module) {
    this.module = module;
  }

  @Override
  public UpcomingLoader get() {
    return provideInstance(module);
  }

  public static UpcomingLoader provideInstance(MyAdapterModule module) {
    return proxyProvideUpcommingLoader(module);
  }

  public static MyAdapterModule_ProvideUpcommingLoaderFactory create(MyAdapterModule module) {
    return new MyAdapterModule_ProvideUpcommingLoaderFactory(module);
  }

  public static UpcomingLoader proxyProvideUpcommingLoader(MyAdapterModule instance) {
    return Preconditions.checkNotNull(
        instance.provideUpcommingLoader(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
