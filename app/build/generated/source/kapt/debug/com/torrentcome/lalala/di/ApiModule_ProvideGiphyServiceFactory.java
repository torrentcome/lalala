package com.torrentcome.lalala.di;

import com.torrentcome.lalala.api.GiphyService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiModule_ProvideGiphyServiceFactory implements Factory<GiphyService> {
  private final ApiModule module;

  public ApiModule_ProvideGiphyServiceFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public GiphyService get() {
    return provideGiphyService(module);
  }

  public static ApiModule_ProvideGiphyServiceFactory create(ApiModule module) {
    return new ApiModule_ProvideGiphyServiceFactory(module);
  }

  public static GiphyService provideGiphyService(ApiModule instance) {
    return Preconditions.checkNotNull(instance.provideGiphyService(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
