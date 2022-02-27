package clmodding

import java.net.URL

internal object CraftLandiaVersionUtils {
    val updatesUrl = "https://updater.craftlandia.com.br/v3/updates.json"

    fun getLatestHash(version: ClientVersion): String {
        return CraftLandiaUpdates.fromJson(URL(updatesUrl).readText())
            .files[version.versionIdentifier]?.firstOrNull {
            it.file.endsWith("${version.downloadedFile}.jar")
        }?.hash
            ?: throw Exception("Unable to find launcher version jar with identifier \"${version.downloadedFile}\"")
    }

    fun getJarUrl(version: ClientVersion): String {
        val updates = CraftLandiaUpdates.fromJson(URL(updatesUrl).readText())
        val list = updates.files[version.versionIdentifier]

        val versionDefinitionFile =
            list?.firstOrNull {
                it.file.endsWith("${version.downloadedFile}.jar")
            } ?: run {
                throw Exception("Unable to find launcher version jar with identifier \"${version.downloadedFile}\"")
            }

        return (updates.base.removeSuffix("/") + "/" + versionDefinitionFile.file)
    }

}