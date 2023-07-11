package jp.jaxa.iss.kibo.rpc.sampleapk;

import android.media.Image;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

import java.util.List;
import gov.nasa.arc.astrobee.Result;
import gov.nasa.arc.astrobee.android.gs.MessageType;
import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

import org.apache.commons.logging.Log;
import org.opencv.core.Mat;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    //image index
    int img_index = 0;

    @Override
    protected void runPlan1(){
        // the mission starts
        //Log.i(TAG,"start mission");
        api.startMission();

        //initialization
        Point[] point = new Point[8];
        Quaternion[] q_point = new Quaternion[8];

        Point[] target = new Point[7];
        Quaternion[] q_target = new Quaternion[7];

        Point[] min_kz = new Point[6];
        Point[] max_kz = new Point[6];
        Point[] kiz = new Point[3];

        //initialize the array for every coordinates of KOZ
        Point[] koz_1= new Point[9];
        Point[] koz_2= new Point[9];
        Point[] koz_3= new Point[9];
        Point[] koz_4= new Point[9];
        Point[] koz_5= new Point[9];

        //storing all coordinates of KOZ
        //KOZ1 all coordinates
        koz_1[1]= new Point(10.783d,-9.8899d,4.8385d);
        koz_1[2]= new Point(11.071d,-9.8899d,4.8385d);
        koz_1[3]= new Point(11.071d,-9.6929,4.8385d);
        koz_1[4]= new Point(10.783d,-9.6929,4.8385d);
        koz_1[5]= new Point(11.071d,-9.6929,5.0665d);
        koz_1[6]= new Point(11.071d,-9.8899d,5.0665d);
        koz_1[7]= new Point(10.783d,-9.8899d,5.0665d);
        koz_1[8]= new Point(10.783d,-9.6929,5.0665d);

        //KOZ2 all coordinates
        koz_2[1]= new Point(10.8652d,-9.0734d,4.3861d);
        koz_2[2]= new Point(10.9628d,-9.0734d,4.3861d);
        koz_2[3]= new Point(10.9628d,-8.7314d,4.3861d);
        koz_2[4]= new Point(10.8652d,-8.7314d,4.3861d);
        koz_2[5]= new Point(10.9628d,-8.7314,4.6401d);
        koz_2[6]= new Point(10.9628d,-9.0734d,4.6401d);
        koz_2[7]= new Point(10.8652d,-9.0734d,4.6401d);
        koz_2[8]= new Point(10.8652d,-8.7314,4.6401d);

        //KOZ3 all coordinates
        koz_3[1]= new Point(10.185d,-8.38526d,4.1475d);
        koz_3[2]= new Point(11.665d,-8.38526d,4.1475d);
        koz_3[3]= new Point(11.665d,-8.2826d,4.1475d);
        koz_3[4]= new Point(10.185d,-8.2826d,4.1475d);
        koz_3[5]= new Point(11.665d,-8.2826d,4.6725d);
        koz_3[6]= new Point(11.665d,-8.38526d,4.6725d);
        koz_3[7]= new Point(10.185d,-8.38526d,4.6725d);
        koz_3[8]= new Point(10.185d,-8.2826d,4.6725d);

        //KOZ4 all coordinates
        koz_4[1]= new Point(10.7955d,-8.0635d,5.1055d);
        koz_4[2]= new Point(11.3525d,-8.0635d,5.1055d);
        koz_4[3]= new Point(11.3525d,-7.7305d,5.1055d);
        koz_4[4]= new Point(10.7955d,-7.7305d,5.1055d);
        koz_4[5]= new Point(11.3525d,-7.7305d,5.1305d);
        koz_4[6]= new Point(11.3525d,-8.0635d,5.1305d);
        koz_4[7]= new Point(10.7955d,-8.0635d,5.1305d);
        koz_4[8]= new Point(10.7955d,-7.7305,5.1305d);

        //KOZ5 all coordinates
        koz_5[1]= new Point(10.563d,-7.1449d,4.6544d);
        koz_5[2]= new Point(10.709d,-7.1449d,4.6544d);
        koz_5[3]= new Point(10.709d,-6.8099d,4.6544d);
        koz_5[4]= new Point(10.563d,-6.8099d,4.6544d);
        koz_5[5]= new Point(10.709d,-6.8099d,4.8164d);
        koz_5[6]= new Point(10.709d,-7.1449d,4.8164d);
        koz_5[7]= new Point(10.563d,-7.1449d,4.8164d);
        koz_5[8]= new Point(10.563d,-6.8099d,4.8164d);

        point[0] = new Point(9.815d, -9.806d, 4.293d);;
        point[1] = new Point(11.2746d, -9.92284d, 5.2988d);;
        point[2] = new Point(10.612d, -9.0709d, 4.48d);;
        point[3] = new Point(10.71d, -7.7d, 4.48d);;
        point[4] = new Point(10.51d, -6.7185d, 5.1804d);;
        point[5] = new Point(11.114d, -7.9756d, 5.3393d);;
        point[6] = new Point(11.355d, -8.9929d, 4.7818d);;
        point[7] = new Point(11.369d, -8.5518d, 4.48d);;

        q_point[0] = new Quaternion(1f, 0f, 0f, 0f);;
        q_point[1] = new Quaternion(0f, 0f, -0.707f, 0.707f);;
        q_point[2] = new Quaternion(0.5f, 0.5f, -0.5f, 0.5f);
        q_point[3] = new Quaternion(0f, 0.707f, 0f, 0.707f);
        q_point[4] = new Quaternion(0f, 0f, -1f, 1f);
        q_point[5] = new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f);
        q_point[6] = new Quaternion(0f, 0f, 0f, 1f);
        q_point[7] = new Quaternion(0f, 0.707f, 0f, 0.707f);

        target[1] = new Point(11.2625d, -10.58d, 5.3625d);
        target[2] = new Point(10.513384d, -9.085172d, 3.76203d);
        target[3] = new Point(10.6031d, -7.71007d, 3.76093d);
        target[4] = new Point(9.866984d, -6.673972d,5.09531d);
        target[5] = new Point(11.102d, -8.0304d, 5.9076d);
        target[6] = new Point(11.55d, -8.933d, 4.7175d);

        q_target[1] = new Quaternion(0.707f, 0f, 0f, 0.707f);
        q_target[2] = new Quaternion(0f, 0f, 0f, 1f);
        q_target[3] = new Quaternion(0.707f, 0f, 0f, 0.707f);
        q_target[4] = new Quaternion(-0.5f, 0.5f, -0.5f, 0.5f);
        q_target[5] = new Quaternion(1f, 0f, 0f, 0f);
        q_target[6] = new Quaternion(0.5f, 0.5f, -0.5f, -0.5f);

        Point qr = new Point(11.381944d, -8.566172d, 3.76203d);
        Quaternion qn_qr = new Quaternion(0f, 0f, 0f, 1f);

        //target 1
        Point temp1 = new Point(10.5d, -10.5d, 4.8d);
        Quaternion q_temp1 = q_target[1];

        api.moveTo(temp1,q_temp1,true);
        api.moveTo(target[1],q_target[1],true);



        //target 6
//        {
//
//            //try to move on temp6
//            Point temp6 = new Point(11d, -8.989d, 5.1d);
//            Quaternion q_temp6 = new Quaternion(1f, 0f, 0f, 0f);
//            api.moveTo(temp6, q_temp6, true);
//
//            //taking image
//            tk_Img();
//
//            //try to move on target 6
//            api.moveTo(target[6], q_target[5], true);
//            //taking image
//            tk_Img();
//
//            api.laserControl(true);
//            api.takeTargetSnapshot(6);
//
//            //Target 5
//            Point temp5 = new Point(11.689d, -8.2826d, 4.6725d);
//            Quaternion q_temp5 = new Quaternion(0.5f, 0.5f, 0.5f, -0.5f);
//
//            //api.moveTo(temp5,q_temp5,true);
//
//
//            api.moveTo(target[5], q_temp5, true);
//            tk_Img();
//
//            api.laserControl(true);
//            api.takeTargetSnapshot(5);
//
//        }
        //ar tag read kore center coordinate dectect korbi

//        while (true){
//            // get the list of active target id
//            List<Integer> list = api.getActiveTargets();
//
//            // move to a point
//
//
//
//            // get a camera image
//            Mat image = api.getMatNavCam();
//
//            // irradiate the laser
//            api.laserControl(true);
//
//            // take active target snapshots
//            int target_id = 1;
//            api.takeTargetSnapshot(target_id);
//
//            /* ************************************************ */
//            /* write your own code and repair the ammonia leak! */
//            /* ************************************************ */
//
//            // get remaining active time and mission time
//            List<Long> timeRemaining = api.getTimeRemaining();
//
//            // check the remaining milliseconds of mission time
//            if (timeRemaining.get(1) < 60000){
//                break;
//            }
//
//            loop_counter++;
//            if (loop_counter == 2){
//                break;
//            }
//        }
        // turn on the front flash light
        api.flashlightControlFront(0.05f);
//
//        // get QR code content
        String mQrContent = yourMethod();
//
//        // turn off the front flash light
        api.flashlightControlFront(0.00f);
//
//
//
//        /* ********************************************************** */
//        /* write your own code to move Astrobee to the goal positiion */
//        /* ********************************************************** */
//
//        // send mission completion
        api.reportMissionCompletion(mQrContent);
    }

    @Override
    protected void runPlan2(){
        // write your plan 2 here
    }

    @Override
    protected void runPlan3(){
        // write your plan 3 here
    }

    // You can add your method
    private String yourMethod(){
        return "your method";
    }
    public void tk_Img(){
        //taking image
        Mat img = api.getMatNavCam();
        api.saveMatImage(img,"Nav_mat "+String.valueOf(img_index)+".png");
        img = api.getMatDockCam();
        api.saveMatImage(img,"dock_mat "+String.valueOf(img_index)+".png");
        img_index++;
    }
}
