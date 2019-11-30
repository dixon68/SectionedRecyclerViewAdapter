package io.github.luizgrp.sectionedrecyclerviewadapter.demo.info;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class SectionInfoItemFactory {

    public static SectionInfoItem create(
            final int itemAdapterPosition,
            final SectionedRecyclerViewAdapter sectionedAdapter
    ) {
        return new SectionInfoItem(
                itemAdapterPosition,
                sectionedAdapter.getPositionInSection(itemAdapterPosition),
                sectionedAdapter.getSectionItemViewType(itemAdapterPosition)
        );
    }
}
