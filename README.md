# NotificationDemo

# 在Android app的开发中，app中启动一个Service，该Service在独立进程中运行，与服务器保持长连接，将服务器推送过来的消息在通知栏中显示，并设置点击动作，点击后跳转到app中对应的Activity。

# 目前遇到的问题是Service以独立进程运行，在收到消息并弹出通知后，app本身的进程有两种情况：
* #app正在运行
* #app已退出

# 第一种情况，直接将参数传入Intent并打开对应的Activity。
# 第二种情况，因为app已经退出，而要打开的Activity中的某些操作是需要依赖app的初始化的，这些初始化操作是在app启动过程中进行的。需要先启动app完成初始化，再跳转到目标Activity。


