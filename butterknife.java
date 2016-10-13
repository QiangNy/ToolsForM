/**
butterknife 的使用

project build.gradle file

1.添加依赖
    dependencies {
        classpath 'com.android.tools.build:gradle:2.1.0'
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'//添加这一行
  
    }

2.将butterknife包从project中引用

ext {
    butternife = 'com.jakewharton:butterknife:8.4.0'
    butternifeapt = 'com.jakewharton:butterknife-compiler:8.4.0'
}

module build.gradle

3.
apply plugin: 'com.android.application'
apply plugin: 'com.neenbedankt.android-apt' //添加这一行

//将依赖包导进module
compile rootProject.ext.butternife
apt rootProject.ext.butternife

4.android studio 添加butterknife插件
plugin中导入, 右键activity 中布局资源,选择generate
*/
