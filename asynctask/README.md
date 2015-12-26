## AsyncTask Overview
> AsyncTask简化了异步操作，它允许你在后台完成一些计算，并且可以在UI线程中获取计算结果。
> AsyncTask适用于处理一下简短的操作，官方建议:a few seconds at the most。
> 如果你需要保持线程运行很长一段时间，推举使用java.util.concurrent包下的[Executor](http://www.android-doc.com/reference/java/util/concurrent/Executor.html)、[ThreadPoolExecutor](http://www.android-doc.com/reference/java/util/concurrent/ThreadPoolExecutor.html)和 [FutureTask](http://www.android-doc.com/reference/java/util/concurrent/FutureTask.html)

## AsyncTask Guides
> AsyncTask需要定义三种类型，分别是Params、Progess和Result，不需要的参数可以使用Void类型代替.
> 四个步骤：onPreExecute、doInBackground、onProgressUpdate和onPostExecute 

### 常用函数说明
> * execute(Params...) : 执行任务，该方法中的参数，会传递给doInBackground(Params...)方法
> * onPreExecute:在doInBackground(Params...)函数之前调用,运行在UI线程中，例如可以在该函数中初始化进度条
> * doInBackground(Params...) : 后台计算，用来运行耗时的任务，该方法的参数来自execute(Params...)函数中的参数
> * publishProgress(Progress...) : 一般在doInBackground(Params..)函数中调用，该函数会调用publishProgress(Progress...)函数
> * onProgressUpdate(Progress...) : 一般用来更新一个或多个进度条，该函数的参数来自publishProgress(Progress...)函数
> * onPostExecute(Result result) : 在后台计算完成后被调用。参数来自于doInBackground(Params...)函数的返回值. <br>
如果cancel(boolean)方法被调用，该方法将不会被调用。
> * cancel(boolean) : 该函数可以在任意时刻被调用，调用后isCancelled()返回true。因此如若需要取消，<br>
需在doInBackground(Params...)函数中定期检测isCancelled()函数的返回值。
> * onCancelled(Result) : cancel(boolean)函数被调用后，该函数会被调用。如果不重载该方法的话，也可以重载onCancelled()



## 注意事项
> * AsyncTask类必须在UI线程中加载
> * AsyncTask实例必须在UI线程中创建
> * execute函数必须在UI线程中调用
> * 不要调用onPreExecute(),onPostExecute(),doInBackground(Params...),onProgressUpdate(Progress)
> * 一个实例仅能被调用一次，第二次调用会抛出异常


[AsyncTask API参考](http://www.android-doc.com/reference/android/os/AsyncTask.html)

