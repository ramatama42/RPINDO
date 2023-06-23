package ramadhan.si6a.rpindo;

import com.google.gson.annotations.SerializedName;

public class ValueData {
    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    private T data;

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
