package net.axay.kspigot.serialization

import net.axay.kspigot.main.ValueHolder

interface SpigotSerializable<T> {
    /**
     * Converts this serializable object
     * into the corresponding spigot object.
     */
    fun toSpigot(): T
}

interface SpigotSerializableCompanion<T>

/**
 * @return A json string.
 */
fun SpigotSerializable<*>.serialize(pretty: Boolean = true): String = ValueHolder.getGson(pretty).toJson(this)

/**
 * Deserializes the given json string and
 * returns the deserialized object.
 */
@Suppress("unused")
inline fun <reified T> SpigotSerializableCompanion<T>.deserialize(json: String): T =
    ValueHolder.getGson().fromJson(json, T::class.java)