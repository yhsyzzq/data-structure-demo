package com.zzq.demo.charpter6;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * 删除多层深度的文件夹和文件
 *
 */
public class DirectoryDeletor {
    //文件夹所嵌套的层数
    public static int totalSize;
    //计数器
    public static int count;
    //每次删除的数量  是100
    public static int num=0;
    //每次删除的数量  是100
    public static boolean first=true;
    public static void main(String[] args) {
        File file = new File("D:\\dpap_v2.0.1\\workspaces\\dg-branch");
        try {
            long firstTime=System.currentTimeMillis();
            while(true){
                //初始化计数器
                count=0;
                totalSize=totalSize-199;

                //开始执行删除操作
                delAll(file);
                if(totalSize<1){
                    break;
                }
            }
            long okTime=System.currentTimeMillis();
            System.out.println("总共耗时:"+((okTime-firstTime)/1000)+"秒");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /**
     * 删除文件夹下所有内容，包括此文件夹删除文件夹下所有内容，包括此文件夹
     *
     * @param f
     * @throws IOException
     */
    public static void delAll(File f) throws IOException {

        File[] sub=f.listFiles();
        //如果是第一次进来
        if (first) {
            if(sub !=null && sub.length>0){
                System.out.println(sub[0].getAbsolutePath());
                count++;
                delAll(sub[0]);
            }else {
                totalSize=count;
                first=false;
                System.out.println("===总共有"+totalSize+"层文件夹===");
            }
            //及时清空,否则会出现栈内存溢出StackOverflowError
            sub=null;
        }else {
            if(sub !=null && sub.length>0){
                count++;
                if(totalSize-count<100){
                    FileUtils.deleteDirectory(f);
                    System.out.println(">>>还有"+(count-1)+"层文件夹没有删除");
                }/*else if(totalSize-count<100){
                    //重新遍历
                    //FileUtils.deleteDirectory(f);
                    delAllLast(f);
                    System.out.println(f.getAbsolutePath());
                }*/else {
                    delAll(sub[0]);
                }

            }
            //及时清空,否则会出现堆内存溢出
            sub=null;
        }

    }


}
