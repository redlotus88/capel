package com.c7n.designPattern.staticProxy;

public class MovieTest {

    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        StaticMovieProxy proxy = new StaticMovieProxy(realMovie);
        proxy.play();
    }
}
