package com.torrentcome.lalala.ui;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.torrentcome.lalala.data.Repo;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class MainViewModel_AssistedFactory implements ViewModelAssistedFactory<MainViewModel> {
  private final Provider<Repo> repository;

  @Inject
  MainViewModel_AssistedFactory(Provider<Repo> repository) {
    this.repository = repository;
  }

  @Override
  @NonNull
  public MainViewModel create(@NonNull SavedStateHandle arg0) {
    return new MainViewModel(repository.get());
  }
}
