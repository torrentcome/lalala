package com.torrentcome.lalala.data;

import com.torrentcome.lalala.api.GiphyService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Repo_Factory implements Factory<Repo> {
  private final Provider<GiphyService> giphyServiceProvider;

  public Repo_Factory(Provider<GiphyService> giphyServiceProvider) {
    this.giphyServiceProvider = giphyServiceProvider;
  }

  @Override
  public Repo get() {
    return newInstance(giphyServiceProvider.get());
  }

  public static Repo_Factory create(Provider<GiphyService> giphyServiceProvider) {
    return new Repo_Factory(giphyServiceProvider);
  }

  public static Repo newInstance(GiphyService giphyService) {
    return new Repo(giphyService);
  }
}
