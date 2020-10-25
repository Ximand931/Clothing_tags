package com.happs.ximand.clothingtags.model

import android.database.Cursor
import com.happs.ximand.clothingtags.model.`object`.ClothingTag

class CursorToClothingTagMapper : Mapper<Cursor, ClothingTag> {

    override fun map(from: Cursor): ClothingTag {
        val titleIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_TITLE)
        val descriptionIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_DESCRIPTION)
        val washingIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_WASHING)
        val washingTempIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_WASHING_MAX_TEMP)
        val whiteningIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_WHITENING)
        val ironingIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_IRONING)
        val dryCleaningIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_DRY_CLEANING)
        val spinningIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_SPINNING)
        val dryingIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_DRYING)
        val twistIndex = from.getColumnIndex(ClothingTagSQLiteHelper.FIELD_CAN_BE_TWISTED)

        val clothingTag = ClothingTag(from.getString(titleIndex))
        clothingTag.description = from.getString(descriptionIndex)
        clothingTag.washingType = from.getInt(washingIndex)
        clothingTag.washingMaximumTemp = from.getInt(washingTempIndex)
        clothingTag.whiteningType = from.getInt(whiteningIndex)
        clothingTag.ironingType = from.getInt(ironingIndex)
        clothingTag.dryCleaningType = from.getInt(dryCleaningIndex)
        clothingTag.spinningType = from.getInt(spinningIndex)
        clothingTag.dryingType = from.getInt(dryingIndex)
        clothingTag.canBeTwisted = (from.getInt(twistIndex) == 1)

        return clothingTag
    }

}