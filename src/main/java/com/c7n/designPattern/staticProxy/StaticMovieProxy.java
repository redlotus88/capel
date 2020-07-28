package com.c7n.designPattern.staticProxy;

public class StaticMovieProxy implements Movie {

    RealMovie realMovie;

    public StaticMovieProxy(RealMovie realMovie) {
        super();
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        realMovie.play();
    }
}
