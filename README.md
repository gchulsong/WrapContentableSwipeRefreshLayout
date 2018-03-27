# WrapContentableSwipeRefreshLayout
SwipeRefreshLayout with wrap_content available for properties of child View


Hi developers.

As many android developers know,
android.support.v4.widget.SwipeRefreshLayout does not allow
the WrapContent attribute on child views.

However, we need to use the property in the SwipeRefreshLayout
when we implement the UI according to the designers' demand.

This layout was made for such a time.


SwipeRefreshLayout | WrapContentableSwipeRefreshLayout
-------------------|----------------------------------
![SRL](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/asis_code.png) | ![WCSRL](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/tobe_code.png)
![SRL](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/asis_preview.png) | ![WCSRL](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/tobe_preview.png)

This layout uses the code from SwipeRefreshLayout,
so you can use all the features of SwipeRefreshLayout 100% equally.
So, usage is no different from SwipeRefreshLayout.


As shown in the picture below, any view such as ScrollView, ListView,
and RecyclerView works well for child view.
If there are parts that do not work well, please fix them by using PR.

The following figure shows this layout in Prism Live Studio,
an app I am participating in as a developer.

ScrollView | ListView | RecylerView
-----------|----------|------------
![ScrollView example](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/example_scrollview.gif) | ![ListView example](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/example_listview.gif) |![RecyclerView example](https://github.com/gchulsong/WrapContentableSwipeRefreshLayout/blob/master/screenshot/example_recyclerview.gif)

It's a great live broadcast delivery tool
and I hope you will use it a lot.

Thank you,
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
