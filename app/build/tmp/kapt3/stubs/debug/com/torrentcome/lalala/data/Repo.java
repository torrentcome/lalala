package com.torrentcome.lalala.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bJ\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/torrentcome/lalala/data/Repo;", "", "giphyService", "Lcom/torrentcome/lalala/api/GiphyService;", "(Lcom/torrentcome/lalala/api/GiphyService;)V", "getGiphyService", "()Lcom/torrentcome/lalala/api/GiphyService;", "setGiphyService", "ok", "", "random", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/torrentcome/lalala/dto/Wrapper;", "search", "text", "app_debug"})
@javax.inject.Singleton()
public final class Repo {
    @org.jetbrains.annotations.NotNull()
    private com.torrentcome.lalala.api.GiphyService giphyService;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String ok() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.reactivex.rxjava3.core.Observable<com.torrentcome.lalala.dto.Wrapper> random() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.reactivex.rxjava3.core.Observable<com.torrentcome.lalala.dto.Wrapper> search(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.torrentcome.lalala.api.GiphyService getGiphyService() {
        return null;
    }
    
    public final void setGiphyService(@org.jetbrains.annotations.NotNull()
    com.torrentcome.lalala.api.GiphyService p0) {
    }
    
    @javax.inject.Inject()
    public Repo(@org.jetbrains.annotations.NotNull()
    com.torrentcome.lalala.api.GiphyService giphyService) {
        super();
    }
}