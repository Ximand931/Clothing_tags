package com.happs.ximand.clothingtags.model.`object`

class ClothingTag {
    var title: String = ""
    var id: Int = -1
    var imageId: Int? = null
    var description: String? = null
    var washingType: Int = 0
    var washingMaximumTemp: Int = 0
    var whiteningType: Int = 0
    var ironingType: Int = 0
    var dryCleaningType: Int = 0
    var spinningType: Int = 0
    var dryingType: Int = 0
    var canBeTwisted: Boolean = true

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ClothingTag

        if (title != other.title) return false
        if (id != other.id) return false
        if (imageId != other.imageId) return false
        if (description != other.description) return false
        if (washingType != other.washingType) return false
        if (washingMaximumTemp != other.washingMaximumTemp) return false
        if (whiteningType != other.whiteningType) return false
        if (ironingType != other.ironingType) return false
        if (dryCleaningType != other.dryCleaningType) return false
        if (spinningType != other.spinningType) return false
        if (dryingType != other.dryingType) return false
        if (canBeTwisted != other.canBeTwisted) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + id
        result = 31 * result + (imageId ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + washingType
        result = 31 * result + washingMaximumTemp
        result = 31 * result + whiteningType
        result = 31 * result + ironingType
        result = 31 * result + dryCleaningType
        result = 31 * result + spinningType
        result = 31 * result + dryingType
        result = 31 * result + canBeTwisted.hashCode()
        return result
    }


}