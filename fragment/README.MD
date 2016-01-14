# Fragment
> `Fragment`是一个片段，可以想像成`Activity`的模块化，拥有`Activity`类似的生命周期，并且可以关联布局文件。
> `Fragment`必须依赖`Activity`，可以被`Activity`动态的添加删除，有利于项目的模块化。
> `Fragment`可以被设计成可重复使用的`Activity`组件。
## 1 在activity运行时添加fragment
> * 首先创建一个`fragment`继承自`Fragment`类。
> * 重写`onCreateView()`方法来定义布局。
> * 如果处理API 11以下版本的`fragment`需要使用Support Library提供的`FragmentActivity`。
> * 在`Activity`的布局中包含一个空的`FrameLayout`作为`fragment`的容器。
> * 通过`FragmentManager`来管理`Fragment`的添加，移除、替换以及其他操作。
## 2 Fragment之间的交互
> `Fragment`之间的交互需要通过其关联的`activity`，不应该直接交互。
### 2.1 Fragment与Activity之间的交互
> * 为了让`fragment`与`acivity`之间交互，需要在`Fragment`类中定义一个接口，并在`activity`中实现。
> * `Fragment`在`onAttach()`方法中获得接口的实现，然后调用接口的方法来与`Activity`交互。
> * 宿主`acitivty`通过`findFragmentById()`方法获取`fragment`实例，然后调用该`fragment`的public方法传递消息。


