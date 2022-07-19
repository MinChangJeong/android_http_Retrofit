package com.frontend.app.util;

import com.google.gson.annotations.SerializedName;

public class JsonResponse {

    @SerializedName("REPL_CD")
    private String status;

    @SerializedName("REPL_MSG")
    private String success;

    @SerializedName("USER_NAME")
    private String username;
}
