package com.example.snsbrowser.common.di

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class JsonTest {

    private lateinit var json: Json

    @Before
    fun init() {
        json = NetworkModule.providesNetworkJson()
    }

    @Test
    fun test_encode_to_string() {
        val testEncodeToString = json.encodeToString(testSerializable)
        assertEquals(testEncodeToString, "{\"id\":\"1\",\"description\":\"test description\"}")
    }

    @Test
    fun test_decode_from_string() {
        val testDecodeFromString = json.decodeFromString<TestSerializable>("{\"id\":\"1\",\"description\":\"test description\"}")
        assertEquals(testDecodeFromString, testSerializable)
    }
}

val testSerializable = TestSerializable("1", "test description")

@Serializable
data class TestSerializable(
    val id: String,
    val description: String
)