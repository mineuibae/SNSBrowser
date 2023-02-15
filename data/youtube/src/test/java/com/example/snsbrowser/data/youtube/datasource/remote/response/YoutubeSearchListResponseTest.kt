package com.example.snsbrowser.data.youtube.datasource.remote.response

import com.example.snsbrowser.common.di.NetworkModule
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class YoutubeSearchListResponseTest {

    private lateinit var json: Json

    @Before
    fun init() {
        json = NetworkModule.providesNetworkJson()
    }

    @Test
    fun test_youtube_search_list_response() {
        val testResponse = json.decodeFromString<YoutubeSearchListResponse>(testYoutubeSearchListResponse)
        val testYoutubeChannels = testResponse.items.map { it.asModel() }
        val testYoutubeChannel = testYoutubeChannels.first { it.channelTitle == "토스" }

        assertTrue {
            testYoutubeChannel.channelTitle == "토스"
        }
    }
}

private val testYoutubeSearchListResponse = """
    {
      "kind": "youtube#searchListResponse",
      "etag": "TKuOnpPBCBgiMb2PRsQlMGMEmKA",
      "nextPageToken": "CAUQAA",
      "regionCode": "KR",
      "pageInfo": {
        "totalResults": 11829,
        "resultsPerPage": 5
      },
      "items": [
        {
          "kind": "youtube#searchResult",
          "etag": "xZKjo5Coy6kVq7OAnyxZ06OHYQY",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCeg5g-vWgtgzQ0cYNV2Cyow"
          },
          "snippet": {
            "publishedAt": "2014-04-01T02:53:32Z",
            "channelId": "UCeg5g-vWgtgzQ0cYNV2Cyow",
            "title": "토스",
            "description": "토스, 새로운 차원의 금융 토스 공식 유튜브 채널입니다.",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/2bsQ4yzU3k7p2BByX53LR7FRMAsHWFrJtis8WXel6UDzgZsyOcrBgIn_DdRgULJaVikI22uZ=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/2bsQ4yzU3k7p2BByX53LR7FRMAsHWFrJtis8WXel6UDzgZsyOcrBgIn_DdRgULJaVikI22uZ=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/2bsQ4yzU3k7p2BByX53LR7FRMAsHWFrJtis8WXel6UDzgZsyOcrBgIn_DdRgULJaVikI22uZ=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "토스",
            "liveBroadcastContent": "upcoming",
            "publishTime": "2014-04-01T02:53:32Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "q-aGKz4SkGnle9lzzEYGNJzwpX0",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCZ_njPaFCKrZcMQV6VFK6sw"
          },
          "snippet": {
            "publishedAt": "2013-09-10T06:54:21Z",
            "channelId": "UCZ_njPaFCKrZcMQV6VFK6sw",
            "title": "제이크 토익스피킹",
            "description": "제이크 토익스피킹 공식 유튜브 채널.",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/dATZzaPWJUcwPa4NUynTFLaq_ID8OblZrAUllHpWkRnFAl0j-DwOQDXYYWXDtrgZwl43EXQxOQ=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/dATZzaPWJUcwPa4NUynTFLaq_ID8OblZrAUllHpWkRnFAl0j-DwOQDXYYWXDtrgZwl43EXQxOQ=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/dATZzaPWJUcwPa4NUynTFLaq_ID8OblZrAUllHpWkRnFAl0j-DwOQDXYYWXDtrgZwl43EXQxOQ=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "제이크 토익스피킹",
            "liveBroadcastContent": "upcoming",
            "publishTime": "2013-09-10T06:54:21Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "QGagvxrSwzNB3UYVZ0jG61boUMo",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCvzXo9p9D9cPaPwy20RXPXQ"
          },
          "snippet": {
            "publishedAt": "2010-11-13T07:56:04Z",
            "channelId": "UCvzXo9p9D9cPaPwy20RXPXQ",
            "title": "악토스:Octos.Oct5th",
            "description": "Auto(Car) Detailing 세차 취미러의 셀프세차 영상 인스타그램 @Oct5th 안녕하세요! 제주에서 셀프세차를 즐기고 취미로 영상 촬영 ...",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/tZRuzDtVH-QtmY2EfrXrBEJ00SAwC6xcqo2v4XobwUELlZwJAckprAj8EUEfZgQpF9ZFWij0=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/tZRuzDtVH-QtmY2EfrXrBEJ00SAwC6xcqo2v4XobwUELlZwJAckprAj8EUEfZgQpF9ZFWij0=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/tZRuzDtVH-QtmY2EfrXrBEJ00SAwC6xcqo2v4XobwUELlZwJAckprAj8EUEfZgQpF9ZFWij0=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "악토스:Octos.Oct5th",
            "liveBroadcastContent": "none",
            "publishTime": "2010-11-13T07:56:04Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "a3D8h_YZJaWyDexX171VoXOvDeY",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCFO2c-x9A5xEXENbK908GYQ"
          },
          "snippet": {
            "publishedAt": "2018-09-04T07:22:02Z",
            "channelId": "UCFO2c-x9A5xEXENbK908GYQ",
            "title": "집토스",
            "description": "",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJXguTWlSjTiyeK1b64CtHDf6rn_Rb4c9yLBXIIr2A=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJXguTWlSjTiyeK1b64CtHDf6rn_Rb4c9yLBXIIr2A=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJXguTWlSjTiyeK1b64CtHDf6rn_Rb4c9yLBXIIr2A=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "집토스",
            "liveBroadcastContent": "none",
            "publishTime": "2018-09-04T07:22:02Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "LUGIgAtSm9itaASuUH1C6ICd2YE",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCiH1oe8qBlIfQVxkpcU-TeA"
          },
          "snippet": {
            "publishedAt": "2021-01-26T12:51:04Z",
            "channelId": "UCiH1oe8qBlIfQVxkpcU-TeA",
            "title": "토스봇",
            "description": "",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJU_gSf-BhrckJUCnYItpyBbMSMwaKjztMiiPoRm=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJU_gSf-BhrckJUCnYItpyBbMSMwaKjztMiiPoRm=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJU_gSf-BhrckJUCnYItpyBbMSMwaKjztMiiPoRm=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "토스봇",
            "liveBroadcastContent": "upcoming",
            "publishTime": "2021-01-26T12:51:04Z"
          }
        }
      ]
    }
""".trimIndent()