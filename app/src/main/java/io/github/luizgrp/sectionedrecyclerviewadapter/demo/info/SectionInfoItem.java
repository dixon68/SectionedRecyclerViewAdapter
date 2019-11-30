package io.github.luizgrp.sectionedrecyclerviewadapter.demo.info;

import android.os.Parcel;
import android.os.Parcelable;

public class SectionInfoItem implements Parcelable {

    private final int adapterPosition;
    private final int positionInSection;
    private final int sectionItemViewType;

    SectionInfoItem(final int adapterPosition, final int positionInSection, final int sectionItemViewType) {
        this.adapterPosition = adapterPosition;
        this.positionInSection = positionInSection;
        this.sectionItemViewType = sectionItemViewType;
    }

    public int getAdapterPosition() {
        return adapterPosition;
    }

    int getPositionInSection() {
        return positionInSection;
    }

    int getSectionItemViewType() {
        return sectionItemViewType;
    }

    private SectionInfoItem(Parcel in) {
        adapterPosition = in.readInt();
        positionInSection = in.readInt();
        sectionItemViewType = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(adapterPosition);
        dest.writeInt(positionInSection);
        dest.writeInt(sectionItemViewType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SectionInfoItem> CREATOR = new Creator<SectionInfoItem>() {
        @Override
        public SectionInfoItem createFromParcel(Parcel in) {
            return new SectionInfoItem(in);
        }

        @Override
        public SectionInfoItem[] newArray(int size) {
            return new SectionInfoItem[size];
        }
    };
}
