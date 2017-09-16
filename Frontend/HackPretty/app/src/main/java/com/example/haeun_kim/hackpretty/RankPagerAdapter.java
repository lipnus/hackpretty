package com.example.haeun_kim.hackpretty;

import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;

import java.util.Locale;



public class RankPagerAdapter extends android.support.v13.app.FragmentPagerAdapter {

    //탭뷰 제목
    private String title1;
    private String title2;
    private String title3;
    private String title4;



    public RankPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Log.d("FFF", "getItem(" + position +")");

        return RankPagerFragment.PlaceholderFragment.newInstance(position + 1);
    }


    //전체 페이지수
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int getItemPosition(Object object) {
        // TODO Auto-generated method stub
        return POSITION_NONE;
    }

    //탭을 사용할 경우 탭에 표시될 제목
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return title1;
            case 1:
                return title2;
            case 2:
                return title3;
            case 3:
                return title4;
        }
        return null;
    }


    //탭뷰의 제목설정
    public void setTabTitle(String title1, String title2, String title3, String title4){

        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.title4 = title4;
    }

}
