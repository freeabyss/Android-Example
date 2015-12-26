package ml.abyss.app.asynctask;

/**
 * 后台操作，先用一个延时程序代替耗时的后台任务，例如网络链接等
 * Created by abyss on 26/12/2015.
 */
public class BackgroundOperator {
    /**
     * 延时程序
     * @param i  单位毫秒
     */
    public  void backgroundProgress(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
