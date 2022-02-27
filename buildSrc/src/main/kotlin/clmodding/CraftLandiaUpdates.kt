package clmodding

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

internal val craftLandiaMapper = jacksonObjectMapper().apply {
    propertyNamingStrategy = PropertyNamingStrategies.LOWER_CAMEL_CASE
    setSerializationInclusion(JsonInclude.Include.NON_NULL)
    disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
}

internal data class CraftLandiaUpdates(
    val base: String,
    val updater: UpdaterInfo,
    val files: Map<String, List<UpdateFile>>
) {
    fun toJson() = craftLandiaMapper.writeValueAsString(this)

    companion object {
        fun fromJson(json: String) = craftLandiaMapper.readValue<CraftLandiaUpdates>(json)
    }
}

internal data class UpdateFile(
    val file: String,
    val hash: String,
    val force: Boolean
)

internal data class UpdaterInfo(
    val version: Long? = null,
    val file: String? = null
)
