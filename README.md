# ClassyShark2ParseAPK
使用android-classyshark工具包实现解析APK并读取包名版本信息功能

关于classyshark： https://github.com/google/android-classyshark
本项目采用release 8.2版本的JAR包

Shark可以直接从APK文件中读取AndroidManifest.xml文件，并返回字符串形式的文件内容。
本项目针对返回的字符串内容，采用Dom4j来解析XML，得到包名版本信息。
