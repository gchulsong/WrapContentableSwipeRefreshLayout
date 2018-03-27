# WrapContentableSwipeRefreshLayout
SwipeRefreshLayout with wrap_content available for properties of child View
<br/>
<br/>
<br/>
Hi developers.

As many android developers know,<br/>
android.support.v4.widget.SwipeRefreshLayout does not allow<br/>
the WrapContent attribute on child views.

However, we need to use the property in the SwipeRefreshLayout<br/>
when we implement the UI according to the designers' demand.

This layout was made for such a time.


## Difference from SwipeRefreshLayout

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#333333"
    >

    <android.support.v4.widget.SwipeRefreshLayout
        android:layout_gravity="bottom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#FF0000"
        >

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:padding="10dp"
            android:background="#0000FF"
            >

            <FrameLayout
                android:layout_width="match_parent"
                android:layout_height="50dp"
                android:layout_marginTop="2dp"
                android:background="#AAAAAA"
                >

                <TextView
                    android:layout_gravity="center"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="row 1"
                    android:textSize="12dp"
                    android:textColor="#333333"
                    />
            </FrameLayout>
    
            ...

        </LinearLayout>
    </android.support.v4.widget.SwipeRefreshLayout>
</FrameLayout>
```
![Preview](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/asis_preview.png){:height="36px" width="36px"}


```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#333333"
    >

    <com.gchulsong.wrapcontentableswiperefreshlayout.WrapContentableSwipeRefreshLayout
        android:layout_gravity="bottom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#FF0000"
        >

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:padding="10dp"
            android:background="#0000FF"
            >

            <FrameLayout
                android:layout_width="match_parent"
                android:layout_height="50dp"
                android:layout_marginTop="2dp"
                android:background="#AAAAAA"
                >

                <TextView
                    android:layout_gravity="center"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="row 1"
                    android:textSize="12dp"
                    android:textColor="#333333"
                    />
            </FrameLayout>

            ...

        </LinearLayout>
    </com.gchulsong.wrapcontentableswiperefreshlayout.WrapContentableSwipeRefreshLayout>
</FrameLayout>
```
![Preview](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/tobe_preview.png width="206" height="335")


## Usage

This layout uses the code from SwipeRefreshLayout,<br/>
so you can use all the features of SwipeRefreshLayout 100% equally.<br/>
So, usage is no different from SwipeRefreshLayout.

As shown in the picture below, any view such as ScrollView, ListView,<br/>
and RecyclerView works well for child view.<br/>
If there are parts that do not work well, please fix them by using PR.

ScrollView | ListView | RecylerView
-----------|----------|------------
![ScrollView example](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/example_scrollview.gif)|![ListView example](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/example_listview.gif)|![RecyclerView example](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/example_recyclerview.gif)


## Practice

The following figure shows this layout in Prism Live Studio,<br/>
an app I am participating in as a developer.<br/>

[PRISM Live Studio](https://play.google.com/store/apps/details?id=com.prism.live)

![PrismLiveStudio](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/example_prism.gif)

It's a great live broadcast tool<br/>
and I hope you will use it a lot.

Thank you,<br/>
Jake.


## License
```
------------------------------------------------------------
"THE BEERWARE LICENSE" (Revision 42):
gchulsong@gmail.com wrote this code. As long as you retain
this notice, you can do whatever you want with this stuff.
If we meet someday, and you think this stuff is worth it,
you can buy me a beer in return.
------------------------------------------------------------
```
