package clmodding

import io.github.nickacpt.lightcraft.gradle.LightCraftGradleExtension

fun LightCraftGradleExtension.craftLandia() {
    val version = ClientVersion.LEGACY
    val currentHash = CraftLandiaVersionUtils.getLatestHash(version)

    customMinecraftVersionName = "craftlandia_${version.name.toLowerCase()}_${currentHash}"
    val mojangOfficialName = "mojang_official"
    this.defaultMappingsSourceNamespace = mojangOfficialName

    customMinecraftJarUrl = CraftLandiaVersionUtils.getJarUrl(version)
    extraPreMappingUrls = mutableListOf(
        "https://raw.githubusercontent.com/CLModding/intermediary/main/intermediary/${currentHash}.tiny", // Official CL -> intermediary
        "https://raw.githubusercontent.com/CLModding/intermediary/main/intermediary-vanilla.tiny" // intermediary -> mojang official
    )
    // Default mapping: mojang official -> named
    extraPostMappingUrls = mutableListOf(
        "https://raw.githubusercontent.com/CLModding/mappings-new/master/legacy/craftlandia.tiny" // intermediary -> named
    )
}