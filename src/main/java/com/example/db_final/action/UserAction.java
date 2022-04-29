package com.example.db_final.action;

import javax.servlet.http.HttpSession;

public class UserAction {
    public boolean islogined(HttpSession session) {
        if(session.getAttribute("user") != null)
            return true;
        return false;
    }
}
