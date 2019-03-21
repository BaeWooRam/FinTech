package com.example.fintech.util;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentUtils {
    public static void NavigateToFragment(Fragment fragment, FragmentManager manager, int container_id) {
        FragmentTransaction transaction = manager.beginTransaction().replace(container_id, fragment);
        transaction.commit();
    }

    public static void StackNavigateToFragment(Fragment fragment, FragmentManager manager, int container_id, String AddToBackStack) {
        FragmentTransaction transaction = manager.beginTransaction().replace(container_id, fragment).addToBackStack(AddToBackStack);
        transaction.commit();
    }
}
