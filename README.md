# LionIQ 数据狮 Android SDK

LionIQ 数据狮专注于移动端电商插件开发，让任何APP快速完善电商功能。

## 简介
本Android库包含: 

- `libs/lioniq.aar` Android 插件
- `example/LioniqAndroidDemo` 简单接入示例，该示例仅供参考。

## 版本要求
Android SDK 要求 android 4.3 及以上版本.

## 安装


### 手动导入
1. 下载 SDK 后, 直接拖动 `lioniq.aar` 到项目libs目录里。

2. 在项目的build.gradle里面添加项目依赖:

````
    repositories{
        flatDir{
        dirs 'libs' //aar的目录地址
        }
    }

    dependencies {
        compile(name: 'lioniq', ext: 'aar')
    }
````



**关于如何使用 SDK 请参考 [开发者中心](http://docs.lioniq.com/)**
欢迎加入官方QQ技术群: 258693280
或邮件: dev@lioniq.com





