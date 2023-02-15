package com.example.snsbrowser.testing.model

import com.example.snsbrowser.domain.model.YoutubeChannel

val testYoutubeChannel1 = YoutubeChannel(
    channelId = "UCeg5g-vWgtgzQ0cYNV2Cyow",
    channelTitle = "토스",
    description = "토스, 새로운 차원의 금융 토스 공식 유튜브 채널입니다.",
    thumbnail = "https://yt3.ggpht.com/2bsQ4yzU3k7p2BByX53LR7FRMAsHWFrJtis8WXel6UDzgZsyOcrBgIn_DdRgULJaVikI22uZ=s88-c-k-c0xffffffff-no-rj-mo"
)

val testYoutubeChannel2 = YoutubeChannel(
    channelId = "UCZ_njPaFCKrZcMQV6VFK6sw",
    channelTitle = "제이크 토익스피킹",
    description = "제이크 토익스피킹 공식 유튜브 채널.",
    thumbnail = "https://yt3.ggpht.com/dATZzaPWJUcwPa4NUynTFLaq_ID8OblZrAUllHpWkRnFAl0j-DwOQDXYYWXDtrgZwl43EXQxOQ=s88-c-k-c0xffffffff-no-rj-mo"
)

val testYoutubeChannels = listOf(testYoutubeChannel1, testYoutubeChannel2)