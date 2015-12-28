## Handler概述
> `Handler`允许发送和处理`Message`或者`Runnable`对象,每当Handler创建的时候都与一个默认的
`Message Queue`所绑定
`Handler`有两个用途，一是定时发送`messages`和`runnbales`对，二是将一个`action`发送到另外
一个线程中处理。

## Handler项目概述
>+ SimpleExampleActivity:简单的演示了一下`Handler`的用法，使用`postDelayed()`方法将
`runnbale`对象里的代码放到UI线程中执行,或者使用post()方法。`Handler`必须在UI线程中
实例化，并且可以在其他线程中调用发送`Runnable`对象。
>+

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



## 更新日志
2015-12-29 添加



