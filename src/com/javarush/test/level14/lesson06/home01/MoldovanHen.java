package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Волковы on 10.08.2016.
 */
class MoldovanHen extends Hen {

    int getCountOfEggsPerMonth()
    {
        return 100;
    }

    String getDescription(){
        return super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }

}
