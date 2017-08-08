package com.rxjava2.android.samples.utils;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.rxjava2.android.samples.model.ApiUser;
import com.rxjava2.android.samples.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 27/08/16.
 */
public class Utils {

    private Utils() {
        // This class in not publicly instantiable.
    }

    public static List<User> getUserList() {

        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.firstname = "Able";
        userOne.lastname = "Black";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.firstname = "Bly";
        userTwo.lastname = "Cane";
        userList.add(userTwo);

        User userThree = new User();
        userThree.firstname = "Candy";
        userThree.lastname = "Donut";
        userList.add(userThree);

        return userList;
    }

    public static List<ApiUser> getApiUserList() {

        List<ApiUser> apiUserList = new ArrayList<>();

        ApiUser apiUserOne = new ApiUser();
        apiUserOne.firstname = "Able";
        apiUserOne.lastname = "Black";
        apiUserList.add(apiUserOne);

        ApiUser apiUserTwo = new ApiUser();
        apiUserTwo.firstname = "Bly";
        apiUserTwo.lastname = "Cane";
        apiUserList.add(apiUserTwo);

        ApiUser apiUserThree = new ApiUser();
        apiUserThree.firstname = "Candy";
        apiUserThree.lastname = "Donut";
        apiUserList.add(apiUserThree);

        return apiUserList;
    }

    public static List<User> convertApiUserListToUserList(List<ApiUser> apiUserList) {

        List<User> userList = new ArrayList<>();

        for (ApiUser apiUser : apiUserList) {
            User user = new User();
            user.firstname = apiUser.firstname;
            user.lastname = apiUser.lastname;
            userList.add(user);
        }

        return userList;
    }

    public static List<User> getUserListWhoLovesBaseball() {

        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.id = 1;
        userOne.firstname = "Able";
        userOne.lastname = "Black";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.id = 2;
        userTwo.firstname = "Bly";
        userTwo.lastname = "Cane";
        userList.add(userTwo);

        return userList;
    }


    public static List<User> getUserListWhoLovesFootball() {

        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.id = 1;
        userOne.firstname = "Able";
        userOne.lastname = "Black";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.id = 3;
        userTwo.firstname = "Bly";
        userTwo.lastname = "Cane";
        userList.add(userTwo);

        return userList;
    }


    public static List<User> filterUserWhoLovesBoth(List<User> baseballFans, List<User> footballFans) {
        List<User> userWhoLovesBoth = new ArrayList<User>();
        for (User baseballFan : baseballFans) {
            for (User footballFan : footballFans) {
                if (baseballFan.id == footballFan.id) {
                    userWhoLovesBoth.add(baseballFan);
                }
            }
        }
        return userWhoLovesBoth;
    }

    public static void logError(String TAG, Throwable e) {
        if (e instanceof ANError) {
            ANError anError = (ANError) e;
            if (anError.getErrorCode() != 0) {
                // received ANError from server
                // error.getErrorCode() - the ANError code from server
                // error.getErrorBody() - the ANError body from server
                // error.getErrorDetail() - just a ANError detail
                Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
            } else {
                // error.getErrorDetail() : connectionError, parseError, requestCancelledError
                Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
            }
        } else {
            Log.d(TAG, "onError errorMessage : " + e.getMessage());
        }
    }

}
