package clmodding

internal enum class ClientVersion(
    val description: String,
    val versionIdentifier: String = "",
    val launcherVersionIdentifier: String = "$versionIdentifier-CraftLandia",
    val downloadedFile: String = launcherVersionIdentifier
) {
    LEGACY("1.5.2 Legacy", "1.5", "1.5.2-CraftLandia"),
    CHRONOS("1.8 Chronos", "1.8", downloadedFile = "mf_CraftLandia"),
}