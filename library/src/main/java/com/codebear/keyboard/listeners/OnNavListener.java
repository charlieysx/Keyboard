package com.codebear.keyboard.listeners;

/**
 * description:
 * <p>
 * Created by CodeBear on 2017/8/1.
 */

public interface OnNavListener {
    /**
     * navigationBar open
     *
     * @param height navigationBar height
     */
    void onNavOpen(int height);

    /**
     * navigationBar close
     */
    void onNavClose();
}
