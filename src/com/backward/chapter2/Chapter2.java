package com.backward.chapter2;

/**
 * 测试Java代码调用动态库dll文件
 */
public class Chapter2 {

    //生成dll的路径
    private static final String DLL_PATH = "C:\\Users\\justi\\source\\repos\\DllMain\\x64\\Release\\DLLMain.dll";

    public static void main(String[] args) {
        System.load(DLL_PATH);
//      System.loadLibrary("DLLMain"); //DLLMain.dll 文件需要配置到环境变量中
        Chapter2 chapter2 = new Chapter2();
        chapter2.sayHello();
    }

    public native void sayHello();
}
