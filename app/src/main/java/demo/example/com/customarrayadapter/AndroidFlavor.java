package demo.example.com.customarrayadapter;

/**
 * Created by poornima-udacity on 6/26/15.
 */
public class AndroidFlavor {
    String versionName;
    String versionNumber;
    int image; // drawable reference id

    public AndroidFlavor(String vName, String vNumber, int image)
    {
        this.versionName = vName;
        this.versionNumber = vNumber;
        this.image = image;
    }

}