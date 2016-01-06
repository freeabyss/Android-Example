## Handler概述
> `Handler`是为了解决多线程并发问题。
>+ 防止多个线程更新UI导致界面错乱
>+ 如果对所有UI进行加锁又会造成性能问题。

> 为解决以上问题，Android提供了一套更新UI的机制。
> `Handler`允许发送和处理`Message`或者`Runnable`对象,每当Handler创建的时候都与一个默认的
`Message Queue`所绑定
## 实例概述
>+ PostExampleActivity:简单的演示了一下`Handler`中的`postDelayed()`方法，将
`runnbale`对象里的代码放到UI线程中执行。`Handler`必须在UI线程中
实例化，并且可以在其他线程中调用发送`Runnable`对象。
>+ MessageExampleyActivyty:演示了使用`Handler`中的`sendMessage()`方法

## Handler 原理
> `Handler`封装了消息的发送（主要包括消息发送给谁）。`Looper`包含一个消息队列也就是`MessageQueue`,所有的
> `Handler`发送的消息都走向这个消息队列。
>`Looper.Looper`是一个死循环，不断的从`MessageQueue`中取消息。
> 每个`Handler`实例都会在内部与`Looper`关联，在`Handler`中发送消息，其实是向`MessageQueue`队列中发送消息。
> **总结：** `Handler`负责发送消息，`Looper`负责接收并将消息回传给`Handler`自己，`MessageQueue`是存储消息的容器。
>
> `Looper`类作为一个线程开启一个消息循环，新诞生的线程是不会开启消息循环的，系统会自动为主线程创建`Looper`对象，
并且开启消息循环。`Looper`对象通过`MessageQueue`来存放消息和事件，一个线程只能有一个`Looper`和`MessageQueue`。
参见`Looper`源码：
```java
    private static void prepare(boolean quitAllowed) {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper(quitAllowed));
    }
```
> `Handler`创建时默认与当前线程中的`Looper`绑定，UI线程会自动创建一个`Looper`。而在其他线程中创建`Handler`实例之前
需要调用`Looper.prepare()`方法来创建一个新的`Looper`。并且在最后需要调用`Looper.loop()`开启消息循环。另外`loop()`
后面的代码不会被执行，除非调用`quit()`。
## Handler常用函数
>* obtainMessage():从`Message pool`中获取新的`Message`实例，并且将`Message`的目标指向`Handler`自身。推荐
使用该方法创建`Message`示例,如果不想指定target，可以直接调用`Message.obtain()`
>* `otainMessage` 其他的重装方法与`obtainMessage()`相同，只不过会设置`Message`中的参数
>* `post`:执行指定的线程。线程中的代码是在UI线程中执行的，因此可以访问UI。
>* `sendMessage`:发送指定的消息。发送之后会调用`Handler.handleMessage(Messgae)`
  该函数是在UI线程中被调用的。
>* `postAtTime` : 指定执行线程执行的时间。
>* `postDelayed` : 延迟指定时间后执行线程。
>* 每个`Handler`实例都默认关联一个`MessageQueue`实例(该实例好像是唯一的),实际上`post`,`postAtTime`,`postDelayed`,
`sendMessage`,`sendEmptyMessage`,`sendEmptyMessageDelayed`,`sendEmptyMessageAtTime`,`sendMessageDelayed`,
`sendMessageAtTime`这几个函数最终都会调用`MessageQueue.enqueueMessage(Message msg, long when)`函数。
如果未指定时间，则when的值默认为`SystemClock.uptimeMillis()`
xxxAtTime系列的函数直接指定了when的值，而xxxDelayed系列的函数when等于`SystemClock.uptimeMillis()` + `delayedTime`
>* `postAtFrontOfQueue` ，`sendMessageAtFrontOfQueue`: 该函数容易卡死线程，引发未知问题，除非特殊情况不然不要调用。
实际上该函数最终也调用了`MessageQueue.enqueueMessage(Message msg, long when)`，只不过when的值为0.

## Handler注意事项
> 可以给Handler传递一个Callback回调函数，该函数会在`handleMessage()`之前调用，并根据其返回值来决定是否执行
`handleMessage()`函数。Callback的作用是用来拦截消息。
> 建议使用`Handler.obtainMessage`或者`Message.obtain`来获取Message实例。



## 更新日志
2015-12-29 添加



