package com.codebear.keyboard.listeners;

/**
 * description:
 * <p>
 * Created by CodeBear on 2017/8/1.
 */

public interface OnKeyboardListener {
    /**
     * keyboard open
     *
     * @param height keyboard height
     */
    void onKeyboardOpen(int height);

    /**
     * keyboard close
     */
    void onKeyboardClose();
}
