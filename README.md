# com-tools-publish
基于SpringBoot的简易文件发布工具，提供文件下载功能
### 使用方法
* 配置服务端口号
```
server.port=8083
```
* 在配置文件中设置“发布文件的存放路径” 
```
例如：publish.path=D:/publish
```
* 将要发布的文件直接丢到上面配置的文件夹中
* 下载文件请求地址
```
http://localhost:8083/download/share?fileName=xxx
```
 
