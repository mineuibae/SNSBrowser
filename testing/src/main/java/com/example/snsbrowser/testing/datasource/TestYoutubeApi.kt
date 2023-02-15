package com.example.snsbrowser.testing.datasource

import com.example.snsbrowser.common.di.NetworkModule
import com.example.snsbrowser.data.youtube.datasource.remote.response.YoutubeSearchListResponse
import com.example.snsbrowser.data.youtube.datasource.remote.retrofit.YoutubeApi
import kotlinx.serialization.decodeFromString

class TestYoutubeApi : YoutubeApi {

    private val json = NetworkModule.providesNetworkJson()

    override suspend fun search(
        part: String,
        pageToken: String?,
        q: String,
        type: String,
        maxResults: Int,
        key: String
    ): YoutubeSearchListResponse {
        return when {
            q.contains("토스") -> {
                json.decodeFromString(testYoutubeSearchListResponse1)
            }
            q.contains("안드로이드") -> {
                json.decodeFromString(testYoutubeSearchListResponse2)
            }
            else -> {
                json.decodeFromString(testYoutubeSearchListResponse3)
            }
        }
    }
}

private val testYoutubeSearchListResponse1 = """
    {
      "kind": "youtube#searchListResponse",
      "etag": "TKuOnpPBCBgiMb2PRsQlMGMEmKA",
      "nextPageToken": "CAUQAA",
      "regionCode": "KR",
      "pageInfo": {
        "totalResults": 11829,
        "resultsPerPage": 2
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
        }
      ]
    }
""".trimIndent()

private val testYoutubeSearchListResponse2 = """
    {
      "kind": "youtube#searchListResponse",
      "etag": "_UN6irZ6TpLLP1RuLLnbTA06SqA",
      "nextPageToken": "CAUQAA",
      "regionCode": "KR",
      "pageInfo": {
        "totalResults": 11213,
        "resultsPerPage": 5
      },
      "items": [
        {
          "kind": "youtube#searchResult",
          "etag": "CUWgBGhWAbKRsvRxLrg-6W2vfbQ",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UC9M7-jzdU8CVrQo1JwmIdWA"
          },
          "snippet": {
            "publishedAt": "2007-09-01T08:29:37Z",
            "channelId": "UC9M7-jzdU8CVrQo1JwmIdWA",
            "title": "Android",
            "description": "With over 2.5 billion active devices, Android powers communication around the world. Stay connected on the latest news and ...",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJX5pm7-CovyIYb_0Rum3nmvavni2BFKERyhjbAfEzw=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJX5pm7-CovyIYb_0Rum3nmvavni2BFKERyhjbAfEzw=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJX5pm7-CovyIYb_0Rum3nmvavni2BFKERyhjbAfEzw=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "Android",
            "liveBroadcastContent": "upcoming",
            "publishTime": "2007-09-01T08:29:37Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "5Hds0V5EvffZcT92Z3GH7_aaS84",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCz9n4yRsYYryRjrSCK0-YWA"
          },
          "snippet": {
            "publishedAt": "2014-07-23T00:34:07Z",
            "channelId": "UCz9n4yRsYYryRjrSCK0-YWA",
            "title": "오준석의 생존코딩",
            "description": "교육하고 책 쓰는 개발자 오준석입니다. 저서 - 오준석의 플러터 생존코딩 - 오준석의 안드로이드 생존코딩 코틀린편 - 될 때까지 ...",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJXDa_ydm75rLV0THNSgL2sPemds7DULWaKCBVHF=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJXDa_ydm75rLV0THNSgL2sPemds7DULWaKCBVHF=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJXDa_ydm75rLV0THNSgL2sPemds7DULWaKCBVHF=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "오준석의 생존코딩",
            "liveBroadcastContent": "none",
            "publishTime": "2014-07-23T00:34:07Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "BIt2YizXzalA2qrkLaFp0QkQazo",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCVHFbqXqoYvEWM1Ddxl0QDg"
          },
          "snippet": {
            "publishedAt": "2007-11-09T18:05:25Z",
            "channelId": "UCVHFbqXqoYvEWM1Ddxl0QDg",
            "title": "Android Developers",
            "description": "Welcome to the official Android Developers YouTube channel. Get the latest Android news, best practices, live videos, ...",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/OWAcq1Yu0stdx87oWaZNPMLWYhAyrGhmDTPyi13jlmfAGkkLO5RgYnLGoaXqG_ZOWXCiuqKk=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/OWAcq1Yu0stdx87oWaZNPMLWYhAyrGhmDTPyi13jlmfAGkkLO5RgYnLGoaXqG_ZOWXCiuqKk=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/OWAcq1Yu0stdx87oWaZNPMLWYhAyrGhmDTPyi13jlmfAGkkLO5RgYnLGoaXqG_ZOWXCiuqKk=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "Android Developers",
            "liveBroadcastContent": "none",
            "publishTime": "2007-11-09T18:05:25Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "G74-zLkAinPNr77483S0_r335Qs",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCEdsGM2ALcUGkUCNSMAthLg"
          },
          "snippet": {
            "publishedAt": "2018-11-28T13:41:43Z",
            "channelId": "UCEdsGM2ALcUGkUCNSMAthLg",
            "title": "hongdroid홍드로이드",
            "description": "안녕하세요 모바일 앱 개발자 홍드로이드 라고 합니다. 이 채널에서는 IT 업계에서의 앱 개발자는 어떻게 하루를 보낼까 궁금해 하시는 ...",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJW_nnHtj6oAvOt7xXAlr4Pl9OKQcJfr45yV_xrv=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJW_nnHtj6oAvOt7xXAlr4Pl9OKQcJfr45yV_xrv=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/ytc/AL5GRJW_nnHtj6oAvOt7xXAlr4Pl9OKQcJfr45yV_xrv=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "hongdroid홍드로이드",
            "liveBroadcastContent": "upcoming",
            "publishTime": "2018-11-28T13:41:43Z"
          }
        },
        {
          "kind": "youtube#searchResult",
          "etag": "iXyuabL_-GOQpCWCfLGww2w9x5I",
          "id": {
            "kind": "youtube#channel",
            "channelId": "UCP63kyZYjstgn_jbtIT-UIg"
          },
          "snippet": {
            "publishedAt": "2021-09-01T04:36:11Z",
            "channelId": "UCP63kyZYjstgn_jbtIT-UIg",
            "title": "안드로이드",
            "description": "김민찬의 댄스교실 바운스볼 지훈이.",
            "thumbnails": {
              "default": {
                "url": "https://yt3.ggpht.com/9l57nDkZ8BZnkZv9VNYqZ-aLCIxKG8oqAouwsm2Gc8tv_z0DriqC5K7Q5deTx3Xse0BOp5ZU=s88-c-k-c0xffffffff-no-rj-mo"
              },
              "medium": {
                "url": "https://yt3.ggpht.com/9l57nDkZ8BZnkZv9VNYqZ-aLCIxKG8oqAouwsm2Gc8tv_z0DriqC5K7Q5deTx3Xse0BOp5ZU=s240-c-k-c0xffffffff-no-rj-mo"
              },
              "high": {
                "url": "https://yt3.ggpht.com/9l57nDkZ8BZnkZv9VNYqZ-aLCIxKG8oqAouwsm2Gc8tv_z0DriqC5K7Q5deTx3Xse0BOp5ZU=s800-c-k-c0xffffffff-no-rj-mo"
              }
            },
            "channelTitle": "안드로이드",
            "liveBroadcastContent": "none",
            "publishTime": "2021-09-01T04:36:11Z"
          }
        }
      ]
    }

""".trimIndent()

private val testYoutubeSearchListResponse3 = """
    {
      "kind": "youtube#searchListResponse",
      "etag": "",
      "regionCode": "KR",
      "pageInfo": {
        "totalResults": 0,
        "resultsPerPage": 5
      },
      "items": []
    }

""".trimIndent()