# HexagonRecyclerView


## (1)依赖:

Gradle:

```
compile 'com.vander.hexlayout:hexlayout:1.0.3'
```

Maven:

```
<dependency>
  <groupId>com.vander.hexlayout</groupId>
  <artifactId>hexlayout</artifactId>
  <version>1.0.3</version>
  <type>pom</type>
</dependency>
```

Ivy:
```
<dependency org='com.vander.hexlayout' name='hexlayout' rev='1.0.3'>
  <artifact name='hexlayout' ext='pom' ></artifact>
</dependency>
```

## (2)效果:

### 默认模式:

![image](http://note.youdao.com/yws/api/personal/file/96E4848565064530B2A7132E45217B27?method=download&shareKey=0c62a8cf299fa9ab8abecefe562ca7b7)

### 无缝隙模式:

![image](http://note.youdao.com/yws/api/personal/file/136BB4282AEB43B4BEA32DB8BD50D806?method=download&shareKey=40d25480b34caeea1bea772db6dddad5)

### 首个Item变大模式:

![image](http://note.youdao.com/yws/api/personal/file/FC2722A5EC0D4C39AB806E2F82395191?method=download&shareKey=a0d1b0cb50d4a4bc5b9e0227dcee3be9)


## (3)特点:

这是个两列正六边形组成的蜂窝状RecyclerView,它具有的特点:

(1)支持设置正六边形的外切圆半径(也就是正六边形大小).

(2)支持设置正六边形蜂窝状的横向间距.

(3)支持设置正六边形的内部填充颜色.

(4)支持设置正六边形的外部边框颜色.

(5)可以设置填充模式:无边框,和有边框两种.

(6)支持当内容无法填充RecyclerView可以设置居中模式.

(7)是一个比较有特点的RecyclerView,并且源码里面注释丰富,欢迎Fork,欢迎Star,欢迎commit.

(8)后续会继续支持,会丰富库中多样的RecyclerView的布局.


## (4)基本使用方式:

具体使用请参考Simple,如果有Bug,请及时提Issue,或者邮箱反馈.

Adapter的ItemView

```
    <com.vander.hexlayout.PolygonItemView
        android:id="@+id/itemview"
        android:layout_width="110dp"
        android:layout_height="110dp"
        app:innerColor="@android:color/white"
        app:isFull="true"
        app:outerColor="#f5c421"
        app:outerWidth="1dp"
        app:radius="50dp" />
```

RecyclerView的LayoutManager

```
        PolygonLayoutManager manager = new PolygonLayoutManager(true);
        manager.setLandscapeInterval(0);
        mMainRv.setLayoutManager(manager);
```

### PolygonItemView各个属性含义:

```
app:innerColor="@android:color/white"

设置内部的填充颜色,默认为白色

app:outerColor="#f5c421"

设置正六边形的边框颜色,默认为#f5c421(浅黄)

app:radius="50dp"

设置正六边形的外切圆半径,如果不设置的话,
默认取最大外切圆半径,即 width/2

app:isFull="true"

设置正六边形的填充模式,默认存在边框

```

### PolygonLayoutManager

```
isGravityCenter 为传入参数

设置当内容无法填充RecyclerView的宽度的时候,是否居中


setLandscapeInterval(int value)

设置正六边形之间的横向缝隙大小
```


## PolygonItemView参数设置

| Name          | 介绍    |  对应方法  |   缺省值 |
| --------      | :-----:   | :----: |  :-----:  |
| mMaxRadius    | 当前正六边形的外切圆最大半径                              |   通过View的宽度计算得出    |  无              |
| mRadius       | 实际正六边形的外切圆的半径(直接控制正六边形的大小)        |       setRadius(int)        |  mMaxRadius      |
| mOuterWidth   | 绘制的边框宽度                                            |   setOuterWidth(int)        |   4              |
| mOuterColor   | 绘制的边框颜色                                            |   setOuterColor(int)        |    #f5c421       |
| mInnerColor   | 正六边形的内部颜色                                        |   setInnerColor(int)        |   白色white      |
| isFull        | 填充模式                                                  |   setViewFullMode(boolean)  |   true           |

## PolygonLayoutManager参数设置

| Name          | 介绍    |  对应方法  |   缺省值 |
| --------      | :-----:   | :----: |  :-----:  |
| mLandscapeInterval    | 正六边形之间的横向间隙                             |   setLandscapeInterval(int)    |   10              |

## 联系方式:

邮箱:issuperd@foxmail.com

欢迎Issue,欢迎Star,欢迎Fork,欢迎提意见.


## License

```
   Copyright (C) 2017 Wan Da Liu <issuperd@foxmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```