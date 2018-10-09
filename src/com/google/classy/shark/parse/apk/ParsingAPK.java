/**
 * 
 */
package com.google.classy.shark.parse.apk;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import com.google.classyshark.Shark;

/**
 * @author 10007610
 *
 */
public class ParsingAPK {

	/**
	 * 
	 */
	public ParsingAPK() {
	}
	
    public static String parseApk2ManifestStr(File apkFile){
        if(apkFile!=null && apkFile.exists()){
            Shark shark = Shark.with(apkFile);
            return shark.getManifest();
        }
        return null;
    }

    public static void parseManifestXmlFile(String manifestStr) throws DocumentException {
        if(manifestStr!=null&&!manifestStr.trim().equals("")){
            Document document = DocumentHelper.parseText(manifestStr);
            Node node = document.selectSingleNode("//manifest");
            String packageName = node.valueOf("@package");
            String versionName = node.valueOf("@versionName");
            String versionCode =  node.valueOf("@versionCode");
            System.out.println("****************get apk info like these : \n "+"packageName = "+packageName+",\n versionName = "+versionName+", \n versionCode = "+versionCode);
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String androidManifestStr = parseApk2ManifestStr(new File("D:\\ParseAPK\\pro999.apk"));
        System.out.println("--------------AndroidManifest.xml content : \n"+androidManifestStr+"\n -----------------");
        try {
            parseManifestXmlFile(androidManifestStr);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
	}

}
