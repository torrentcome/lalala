package com.torrentcome.lalala.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\'J\u001c\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/torrentcome/lalala/api/GiphyService;", "", "random", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/torrentcome/lalala/dto/Wrapper;", "search", "text", "", "app_debug"})
public abstract interface GiphyService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "gifs/random?api_key=zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6&tag=&rating=g")
    public abstract io.reactivex.rxjava3.core.Observable<com.torrentcome.lalala.dto.Wrapper> random();
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "gifs/search?api_key=zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6&q={q}&limit=25&offset=0&rating=g&lang=en")
    public abstract io.reactivex.rxjava3.core.Observable<com.torrentcome.lalala.dto.Wrapper> search(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "q")
    java.lang.String text);
}