#MultiLayout 模块
> 本模块介绍了各种布局的使用
## 模块构成
> LinearLayout
> RelativeLayout

## LinearLayout
### 功能
> 线性布局，该布局内的子控件以水平或者垂直的方式排列
### 属性
> `android:orientation`：子类控件的排列方式，`vertical`:垂直，`horizontal`:水平
> `andorid:gravity`：子类控件的位置。常用的值有：`center_vertical`,`center_horizontal`,`center`,`right`,`left`,`buttom`。
#### 以下属性用于子类控件
> `android:layout_gravity`：指本身在当前父容器的XY的位置
> `android:layout_weight`：指本身控件占当前父容器的一个比例

## RelativeLayout
### 功能
> 相对布局，该布局内的子控件将以控件之间的相对位置或者子控件相对父类容器的位置的方式排列
### 属性
#### 子类控件相对父类控件的位置
> `android:layout_alignParentLeft`='true' 子控件相对当前父类容器靠左边
> `android:layout_marginLeft'='41dp' 子类控件距离父类容器左边的距离
> `andorid:layout_centerInParent`='true' 子类控件相对父类容器即水平又垂直居中
> `android:layout_centerHorizontal`='true' 子类控件相对父类容器水平居中
> `android:layout_centerVertical`='true' 子类控件相对父类容器垂直居中
#### 子类控件相对子类控件的位置
> `android:layout_below`： 该控件位于给定ID控件的底部
> `android:layout_toRightOf`：该控件位于给定ID控件的右边
> `android:layout_above`：该控件位于给定ID控件的上面
> `android:layout_toLeftOf`：该控件位于给定ID控件的左边
> `android:layout_alignBaseline`：与给定ID控件的内容在一条线上
> `android:layout_alignBottom`：底部边缘与给定ID的底部边缘对齐
> `android:layout_alignLeft' : 左边缘对齐
> `android:layout_alignRight`：右边缘对齐
> `android:layout_alignTop`： 顶部对齐

## FrameLayout
### 功能
> 帧布局，该布局所有的子元素都放置在左上角，后面的元素会覆盖前面的元素。
### 属性
> `andorid:gravity`：使控件居中显示

## TableLayout
### 功能
> 表格布局，以行列的形式管理子控件，每一行为一个`TableRow`或者一个`View`对象。
表格布局将占满父容器本身。
### 属性
#### 全局属性，即TableLayout所用的属性
>`android:collapseColumns`：隐藏列，序号从0开始，可以用逗号隔开
>`android:shrinkColumns`：允许收缩列，序号从0开始，可以用逗号隔开，可以用*匹配所有列
>`android:stretchColumns`：允许拉伸列，序号从0开始，可以用逗号隔开，可以用*匹配所有列
> *同一列允许同时拉伸和收缩*
#### 内部属性，即子控件所用的属性
>`android:layout_column`：设置控件在第几行显示,从0开始
>`android:layout_span`：控件占据的列宽

## AutoLayout
### 功能
> 可以使不同的布局文件匹配不同的分辨率。该库的详细介绍参见[AutoLayout](https://github.com/hongyangAndroid/AndroidAutoLayout)
### 