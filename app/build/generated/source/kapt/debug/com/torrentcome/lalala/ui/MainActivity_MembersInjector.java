package com.torrentcome.lalala.ui;

import com.torrentcome.lalala.data.Repo;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Repo> repositoryProvider;

  public MainActivity_MembersInjector(Provider<Repo> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<Repo> repositoryProvider) {
    return new MainActivity_MembersInjector(repositoryProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectRepository(instance, repositoryProvider.get());
  }

  @InjectedFieldSignature("com.torrentcome.lalala.ui.MainActivity.repository")
  public static void injectRepository(MainActivity instance, Repo repository) {
    instance.repository = repository;
  }
}
