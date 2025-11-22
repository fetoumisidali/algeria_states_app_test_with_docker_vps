package com.example.demo.state;

/*
    @Author Fetoumi Sidali
    @Created 11/22/2025
*/
public interface Views {

    interface Base {}
    interface Arabic extends Base{}
    interface English extends Base{}
    interface Full extends Arabic,English {}
}
