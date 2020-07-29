package com.torrentcome.lalala.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/torrentcome/lalala/di/ApiModule;", "", "()V", "provideGiphyService", "Lcom/torrentcome/lalala/api/GiphyService;", "app_debug"})
@dagger.Module()
public final class ApiModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.torrentcome.lalala.api.GiphyService provideGiphyService() {
        return null;
    }
    
    public ApiModule() {
        super();
    }
}