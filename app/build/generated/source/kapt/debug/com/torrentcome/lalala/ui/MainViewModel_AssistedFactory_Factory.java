package com.torrentcome.lalala.ui;

import com.torrentcome.lalala.data.Repo;
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
public final class MainViewModel_AssistedFactory_Factory implements Factory<MainViewModel_AssistedFactory> {
  private final Provider<Repo> repositoryProvider;

  public MainViewModel_AssistedFactory_Factory(Provider<Repo> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MainViewModel_AssistedFactory get() {
    return newInstance(repositoryProvider);
  }

  public static MainViewModel_AssistedFactory_Factory create(Provider<Repo> repositoryProvider) {
    return new MainViewModel_AssistedFactory_Factory(repositoryProvider);
  }

  public static MainViewModel_AssistedFactory newInstance(Provider<Repo> repository) {
    return new MainViewModel_AssistedFactory(repository);
  }
}
