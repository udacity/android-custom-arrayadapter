package demo.example.com.customarrayadapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by poornima-udacity on 6/26/15.
 */
public class AndroidFlavor implements Parcelable{
    String versionName;
    String versionNumber;
    int image; // drawable reference id

    public AndroidFlavor(String vName, String vNumber, int image)
    {
        this.versionName = vName;
        this.versionNumber = vNumber;
        this.image = image;
    }

    private AndroidFlavor(Parcel in){
        versionName = in.readString();
        versionNumber = in.readString();
        image = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String toString() { return versionName + "--" + versionNumber + "--" + image; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(versionName);
        parcel.writeString(versionNumber);
        parcel.writeInt(image);
    }

    public final Parcelable.Creator<AndroidFlavor> CREATOR = new Parcelable.Creator<AndroidFlavor>() {
        @Override
        public AndroidFlavor createFromParcel(Parcel parcel) {
            return new AndroidFlavor(parcel);
        }

        @Override
        public AndroidFlavor[] newArray(int i) {
            return new AndroidFlavor[i];
        }

    };
}