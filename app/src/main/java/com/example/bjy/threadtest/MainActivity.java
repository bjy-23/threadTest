package com.example.bjy.threadtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bjy.threadtest.test2.Data;
import com.example.bjy.threadtest.test1.Thread1;
import com.example.bjy.threadtest.test2.Data2;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello  = (TextView) findViewById(R.id.tv_hello);
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                test1();
                test2();
            }
        });
    }
    public void test2(){
        final Data2 data = new Data2();

        //写操作
//        for (int i = 0; i < 3; i++) {
//            new Thread(new Runnable() {
//                public void run() {
//                    for (int j = 0; j < 1; j++) {
//                        data.set(new Random().nextInt(30));
//                    }
//                }
//            },"Thread"+i).start();
//        }

        //读操作
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        data.get();
                    }
                }
            },"Thread"+(3+i)).start();
        }
    }

    public void test1(){
        for (int i=0;i<40;i++){
            Log.e(Thread.currentThread().getName(),"createThread"+(i+1));
            Thread1 thread1 = new Thread1("Thread"+(i+1));
            thread1.start();
        }
    }
    /*
    * 02-09 16:15:53.832 16820-16820/com.example.bjy.threadtest E/main: createThread1
02-09 16:15:53.832 16820-16820/com.example.bjy.threadtest E/main: createThread2
02-09 16:15:53.832 16820-16820/com.example.bjy.threadtest E/main: createThread3
02-09 16:15:53.832 16820-16820/com.example.bjy.threadtest E/main: createThread4
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread5
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread6
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread7
02-09 16:15:53.842 16820-17102/com.example.bjy.threadtest E/Thread3: 奇数     1
02-09 16:15:53.842 16820-17102/com.example.bjy.threadtest E/Thread3: 10: 90
02-09 16:15:53.842 16820-17101/com.example.bjy.threadtest E/Thread2: 奇数     2
02-09 16:15:53.842 16820-17101/com.example.bjy.threadtest E/Thread2: 20: 80
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread8
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread9
02-09 16:15:53.842 16820-17100/com.example.bjy.threadtest E/Thread1: 偶数     3
02-09 16:15:53.842 16820-17100/com.example.bjy.threadtest E/Thread1: 10: 90
02-09 16:15:53.842 16820-17103/com.example.bjy.threadtest E/Thread4: 奇数     4
02-09 16:15:53.842 16820-17103/com.example.bjy.threadtest E/Thread4: 20: 80
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread10
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread11
02-09 16:15:53.842 16820-17105/com.example.bjy.threadtest E/Thread6: 偶数     5
02-09 16:15:53.842 16820-17105/com.example.bjy.threadtest E/Thread6: 10: 90
02-09 16:15:53.842 16820-17104/com.example.bjy.threadtest E/Thread5: 奇数     6
02-09 16:15:53.842 16820-17104/com.example.bjy.threadtest E/Thread5: 20: 80
02-09 16:15:53.842 16820-17106/com.example.bjy.threadtest E/Thread7: 偶数     7
02-09 16:15:53.842 16820-17106/com.example.bjy.threadtest E/Thread7: 10: 90
02-09 16:15:53.842 16820-17107/com.example.bjy.threadtest E/Thread8: 奇数     8
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread12
02-09 16:15:53.842 16820-17107/com.example.bjy.threadtest E/Thread8: 20: 80
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread13
02-09 16:15:53.842 16820-17109/com.example.bjy.threadtest E/Thread10: 奇数     9
02-09 16:15:53.842 16820-17109/com.example.bjy.threadtest E/Thread10: 30: 70
02-09 16:15:53.842 16820-17111/com.example.bjy.threadtest E/Thread12: 奇数     10
02-09 16:15:53.842 16820-17111/com.example.bjy.threadtest E/Thread12: 40: 60
02-09 16:15:53.842 16820-16820/com.example.bjy.threadtest E/main: createThread14
02-09 16:15:53.842 16820-17108/com.example.bjy.threadtest E/Thread9: 偶数     11
02-09 16:15:53.852 16820-17108/com.example.bjy.threadtest E/Thread9: 30: 70
02-09 16:15:53.852 16820-17114/com.example.bjy.threadtest E/Thread13: 偶数     12
02-09 16:15:53.852 16820-17110/com.example.bjy.threadtest E/Thread11: 奇数     13
02-09 16:15:53.852 16820-17114/com.example.bjy.threadtest E/Thread13: 20: 80
02-09 16:15:53.852 16820-17110/com.example.bjy.threadtest E/Thread11: 30: 70
02-09 16:15:53.852 16820-16820/com.example.bjy.threadtest E/main: createThread15
02-09 16:15:53.852 16820-16820/com.example.bjy.threadtest E/main: createThread16
02-09 16:15:53.852 16820-16820/com.example.bjy.threadtest E/main: createThread17
02-09 16:15:53.852 16820-16820/com.example.bjy.threadtest E/main: createThread18
02-09 16:15:53.852 16820-17116/com.example.bjy.threadtest E/Thread15: 偶数     14
02-09 16:15:53.852 16820-17116/com.example.bjy.threadtest E/Thread15: 20: 80
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread19
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread20
02-09 16:15:53.862 16820-17117/com.example.bjy.threadtest E/Thread16: 偶数     15
02-09 16:15:53.862 16820-17117/com.example.bjy.threadtest E/Thread16: 10: 90
02-09 16:15:53.862 16820-17119/com.example.bjy.threadtest E/Thread18: 奇数     16
02-09 16:15:53.862 16820-17119/com.example.bjy.threadtest E/Thread18: 20: 80
02-09 16:15:53.862 16820-17115/com.example.bjy.threadtest E/Thread14: 偶数     17
02-09 16:15:53.862 16820-17115/com.example.bjy.threadtest E/Thread14: 10: 90
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread21
02-09 16:15:53.862 16820-17118/com.example.bjy.threadtest E/Thread17: 偶数     18
02-09 16:15:53.862 16820-17118/com.example.bjy.threadtest E/Thread17: 0: 100
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread22
02-09 16:15:53.862 16820-17120/com.example.bjy.threadtest E/Thread19: 奇数     19
02-09 16:15:53.862 16820-17120/com.example.bjy.threadtest E/Thread19: 10: 90
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread23
02-09 16:15:53.862 16820-17121/com.example.bjy.threadtest E/Thread20: 偶数     20
02-09 16:15:53.862 16820-17121/com.example.bjy.threadtest E/Thread20: 0: 100
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread24
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread25
02-09 16:15:53.862 16820-17125/com.example.bjy.threadtest E/Thread24: 偶数     21
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread26
02-09 16:15:53.862 16820-17124/com.example.bjy.threadtest E/Thread23: 奇数     22
02-09 16:15:53.862 16820-17124/com.example.bjy.threadtest E/Thread23: 10: 90
02-09 16:15:53.862 16820-17123/com.example.bjy.threadtest E/Thread22: 偶数     23
02-09 16:15:53.862 16820-17123/com.example.bjy.threadtest E/Thread22: 0: 100
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread27
02-09 16:15:53.862 16820-17122/com.example.bjy.threadtest E/Thread21: 偶数     24
02-09 16:15:53.862 16820-16820/com.example.bjy.threadtest E/main: createThread28
02-09 16:15:53.872 16820-17127/com.example.bjy.threadtest E/Thread26: 奇数     25
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread29
02-09 16:15:53.872 16820-17127/com.example.bjy.threadtest E/Thread26: 10: 90
02-09 16:15:53.872 16820-17126/com.example.bjy.threadtest E/Thread25: 偶数     26
02-09 16:15:53.872 16820-17126/com.example.bjy.threadtest E/Thread25: 0: 100
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread30
02-09 16:15:53.872 16820-17128/com.example.bjy.threadtest E/Thread27: 奇数     27
02-09 16:15:53.872 16820-17128/com.example.bjy.threadtest E/Thread27: 10: 90
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread31
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread32
02-09 16:15:53.872 16820-17129/com.example.bjy.threadtest E/Thread28: 奇数     28
02-09 16:15:53.872 16820-17129/com.example.bjy.threadtest E/Thread28: 20: 80
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread33
02-09 16:15:53.872 16820-17130/com.example.bjy.threadtest E/Thread29: 偶数     29
02-09 16:15:53.872 16820-17130/com.example.bjy.threadtest E/Thread29: 10: 90
02-09 16:15:53.872 16820-17132/com.example.bjy.threadtest E/Thread31: 奇数     30
02-09 16:15:53.872 16820-17132/com.example.bjy.threadtest E/Thread31: 20: 80
02-09 16:15:53.872 16820-17131/com.example.bjy.threadtest E/Thread30: 奇数     31
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread34
02-09 16:15:53.872 16820-17131/com.example.bjy.threadtest E/Thread30: 30: 70
02-09 16:15:53.872 16820-17133/com.example.bjy.threadtest E/Thread32: 偶数     32
02-09 16:15:53.872 16820-17133/com.example.bjy.threadtest E/Thread32: 20: 80
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread35
02-09 16:15:53.872 16820-17134/com.example.bjy.threadtest E/Thread33: 偶数     33
02-09 16:15:53.872 16820-17134/com.example.bjy.threadtest E/Thread33: 10: 90
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread36
02-09 16:15:53.872 16820-17136/com.example.bjy.threadtest E/Thread35: 偶数     34
02-09 16:15:53.872 16820-17136/com.example.bjy.threadtest E/Thread35: 0: 100
02-09 16:15:53.872 16820-16820/com.example.bjy.threadtest E/main: createThread37
02-09 16:15:53.882 16820-16820/com.example.bjy.threadtest E/main: createThread38
02-09 16:15:53.882 16820-17137/com.example.bjy.threadtest E/Thread36: 偶数     35
02-09 16:15:53.882 16820-17135/com.example.bjy.threadtest E/Thread34: 奇数     35
02-09 16:15:53.882 16820-17135/com.example.bjy.threadtest E/Thread34: 10: 90
02-09 16:15:53.882 16820-16820/com.example.bjy.threadtest E/main: createThread39
02-09 16:15:53.882 16820-17138/com.example.bjy.threadtest E/Thread37: 奇数     36
02-09 16:15:53.882 16820-17138/com.example.bjy.threadtest E/Thread37: 20: 80
02-09 16:15:53.882 16820-17139/com.example.bjy.threadtest E/Thread38: 偶数     37
02-09 16:15:53.882 16820-17139/com.example.bjy.threadtest E/Thread38: 10: 90
02-09 16:15:53.882 16820-16820/com.example.bjy.threadtest E/main: createThread40
02-09 16:15:53.882 16820-17141/com.example.bjy.threadtest E/Thread39: 偶数     38
02-09 16:15:53.882 16820-17141/com.example.bjy.threadtest E/Thread39: 0: 100
02-09 16:15:53.882 16820-17142/com.example.bjy.threadtest E/Thread40: 奇数     39
02-09 16:15:53.882 16820-17142/com.example.bjy.threadtest E/Thread40: 10: 90

    * */
}
