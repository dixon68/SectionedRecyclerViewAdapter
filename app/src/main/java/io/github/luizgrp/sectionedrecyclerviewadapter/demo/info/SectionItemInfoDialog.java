package io.github.luizgrp.sectionedrecyclerviewadapter.demo.info;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SectionItemInfoDialog extends DialogFragment {

    private static final String SECTION_INFO_ITEM_KEY = "SectionInfoItemKey";
    private static final String SECTION_INFO_KEY = "SectionInfoKey";

    private SectionItemInfoDialog() {
        // this should be instantiated via factory method
    }

    private SectionInfoItem getSectionInfoItem() {
        final Bundle bundle = requireArguments();
        if (!bundle.containsKey(SECTION_INFO_ITEM_KEY)) {
            throw new IllegalStateException("Fragment " + this + " does not have a SectionInfoItem argument.");
        } else {
            return bundle.getParcelable(SECTION_INFO_ITEM_KEY);
        }
    }

    private SectionInfo getSectionInfo() {
        final Bundle bundle = requireArguments();
        if (!bundle.containsKey(SECTION_INFO_KEY)) {
            throw new IllegalStateException("Fragment " + this + " does not have a SectionInfo argument.");
        } else {
            return bundle.getParcelable(SECTION_INFO_KEY);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable final Bundle savedInstanceState) {
        final SectionInfoItem sectionInfoItem = getSectionInfoItem();
        final SectionInfo sectionInfo = getSectionInfo();

        final StringBuilder sb = new StringBuilder();
        final String lineBreaker = "\n";
        sb.append("Position in adapter: ").append(sectionInfoItem.getAdapterPosition()).append(lineBreaker);
        sb.append("Position in section: ").append(sectionInfoItem.getPositionInSection()).append(lineBreaker);
        sb.append("Section item view type: ").append(sectionInfoItem.getSectionItemViewType()).append(lineBreaker);
        sb.append("Section position: ").append(sectionInfo.getSectionPosition()).append(lineBreaker);
        sb.append("Section has header? ").append(sectionInfo.isHeaded()).append(lineBreaker);
        if (sectionInfo.isHeaded()) {
            sb.append("Section header position: ").append(sectionInfo.getSectionHeaderPosition()).append(lineBreaker);
        }
        sb.append("Section has footer? ").append(sectionInfo.isFooted()).append(lineBreaker);
        if (sectionInfo.isFooted()) {
            sb.append("Section footer position: ").append(sectionInfo.getSectionFooterPosition()).append(lineBreaker);
        }

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Section Item Info")
                .setMessage(sb.toString())
                .setPositiveButton("Close", null);

        return builder.create();
    }

    public static SectionItemInfoDialog getInstance(@NonNull final SectionInfoItem sectionInfoItem, final SectionInfo sectionInfo) {
        final SectionItemInfoDialog sectionItemInfoDialog = new SectionItemInfoDialog();
        final Bundle args = new Bundle();

        args.putParcelable(SECTION_INFO_ITEM_KEY, sectionInfoItem);
        args.putParcelable(SECTION_INFO_KEY, sectionInfo);

        sectionItemInfoDialog.setArguments(args);

        return sectionItemInfoDialog;
    }
}
