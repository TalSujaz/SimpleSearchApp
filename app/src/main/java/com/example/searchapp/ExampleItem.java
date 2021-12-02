package com.example.searchapp;

class ExampleItem {
    private int mImageResorce;
    private String mText1;
    private String mText2;

    public ExampleItem(int imageResorce,String text1,String text2){
        mImageResorce=imageResorce;
        mText1= text1;
        mText2=text2;
    }

    public int getImageResorce(){
        return mImageResorce;
    }

    public String getText1(){
        return mText1;
    }

    public String getText2(){
        return mText2;
    }
}
