package com.learningjava;

public class Part01_BasicGrammar {
    public static void main(StringPractice[] args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.CupSize.SUPER_LARGE;
    }
}

class FreshJuice {
    /**
     *
     */
    //;;;
        /*Nihao*/
    enum CupSize {
        MID, LARGE, SUPER_LARGE
    }

    CupSize size;
}