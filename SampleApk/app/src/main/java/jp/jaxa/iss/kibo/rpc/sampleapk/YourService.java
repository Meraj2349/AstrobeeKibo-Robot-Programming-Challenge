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
    //private final String TAG = this.getClass().getSimpleName();
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
        target[6] = new Point(12.023d, -8.989d, 4.8305d);

        q_target[1] = new Quaternion(0.707f, 0f, 0f, 0.707f);
        q_target[2] = new Quaternion(0f, 0f, 0f, 1f);
        q_target[3] = new Quaternion(0.707f, 0f, 0f, 0.707f);
        q_target[4] = new Quaternion(-0.5f, 0.5f, -0.5f, 0.5f);
        q_target[5] = new Quaternion(1f, 0f, 0f, 0f);
        q_target[6] = new Quaternion(0.5f, 0.5f, -0.5f, -0.5f);

//        min_kz[1] = new Point(11.381944d, -8.566172d, 3.76203d);
//        min_kz[2] = new Point(11.381944d, -8.566172d, 3.76203d);
//        min_kz[3] = new Point(11.381944d, -8.566172d, 3.76203d);
//        min_kz[4] = new Point(11.381944d, -8.566172d, 3.76203d);
//        min_kz[5] = new Point(11.381944d, -8.566172d, 3.76203d);

        Point qr = new Point(11.381944d, -8.566172d, 3.76203d);
        Quaternion qn_qr = new Quaternion(0f, 0f, 0f, 1f);

        Point temp = new Point(10.4075d, -8.903d, 4.8465d);
        Quaternion q_temp = q_target[5];

        //try to move on target 1
        //api.moveTo(target[1],q_target[1],true); //failed
        //api.moveTo(target[2],q_target[2],true);
        api.moveTo(temp,q_temp,true);
        api.moveTo(target[5],q_target[5],true);

        Mat img = api.getMatNavCam();
        api.saveMatImage(img,"img.png");

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
//        api.flashlightControlFront(0.05f);
//
//        // get QR code content
//        String mQrContent = yourMethod();
//
//        // turn off the front flash light
//        api.flashlightControlFront(0.00f);
//
//
//
//        /* ********************************************************** */
//        /* write your own code to move Astrobee to the goal positiion */
//        /* ********************************************************** */
//
//        // send mission completion
//        api.reportMissionCompletion(mQrContent);
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
}
