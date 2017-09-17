# CompatToast
基于zhitaocai/ToastCompat_Deprecated 项目上进行修改的.兼容小米和7.1系统的Toast;

### 问题提出:在Android 的应用管理中,如果用户禁止了通知权限,那么你的App将无法收到Toast通知.这是由于Toast是通过INotificationManager服务进行Toast的显示的.当用户禁止了通知权限,INotificationManager服务被禁止了.而Toast的show是通过enqueueToast方法进行管理的.


### 问题解决
1. 自定义队列维护Toast的显示与隐藏;
2. 使用反射方法调用Toast的show和hide方法.绕过MIUI 8 6.8.18以上的小米手机上的悬浮窗权限;
3. 适配7.1系统;


用法:

`
CompatToast.makeText(context,"A Toast",Toast.LENGTH_SHORT).show();
`