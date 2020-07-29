package com.torrentcome.lalala.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006J\u0018\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/torrentcome/lalala/ui/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/torrentcome/lalala/data/Repo;", "(Lcom/torrentcome/lalala/data/Repo;)V", "getRandom", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/torrentcome/lalala/dto/Wrapper;", "search", "text", "", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.torrentcome.lalala.data.Repo repository = null;
    
    @org.jetbrains.annotations.Nullable()
    public final io.reactivex.rxjava3.core.Observable<com.torrentcome.lalala.dto.Wrapper> getRandom() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.reactivex.rxjava3.core.Observable<com.torrentcome.lalala.dto.Wrapper> search(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.torrentcome.lalala.data.Repo repository) {
        super();
    }
}