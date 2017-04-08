package com.corecanarias.telegramimages

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * TODO: Include javadoc
 */
class Img42Uploader {

    String uploadImage(String path) {

        File fileToUpload = new File(path)

        MultipartUtility post = new MultipartUtility("http://uploadpie.com/", "UTF-8")
        post.addFormField("MAX_FILE_SIZE", "3145728")
        post.addFormField("upload", "1")
        post.addFormField("expire", "1")

        post.addFilePart("uploadedfile", fileToUpload);
        List<String> response = post.finish();
        String html = response.join(" ")
//        println html
//        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> <html xmlns=\"http://www.w3.org/1999/xhtml\"> <head> <title>Upload Pie - The Simple Image Sharing Tool</title> <link rel=\"stylesheet\" type=\"text/css\" media=\"screen, projection\" href=\"styles/style.css\" /> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> <meta name=\"keywords\" content=\"upload,image,text,host,expire,pie,transfer,ftp,easy,tool,collaboration,share,exchange,bake,simple\" /> <meta name=\"description\" content=\"Upload Pie is a simple no fuss tool for temporarily sharing images and text files, allowing you to view the files within a browser window for a chosen amount of time.\" /> <link rel=\"icon\" type=\"image/png\" href=\"favicon.png\" /> </head> <body> <div id=\"page\"> \t<div id=\"pagecontent\">         <div id=\"bakefile\">             <div id=\"formtop\">                 <img src=\"images/uploaded.png\" alt=\"uploaded\" title=\"Your file is located at\" />                 <input type=\"text\" id=\"uploaded\" value=\"http://uploadpie.com/uQAuu\" onclick=\"auto_select();\" readonly=\"readonly\" /> \t\t        <script type=\"text/javascript\" src=\"autoselect.js\"></script> \t\t\t</div>             <div id=\"formbottom\">                 <p id=\"bakeanotheru\"><a href=\"http://uploadpie.com/\"><img src=\"images/bake_another.png\" alt=\"bake another\" title=\"Bake another?\"></a></p>             </div>         </div>         <div id=\"footer\"> \t\t\t<div id=\"more\"><a href=\"mailto:hello@uploadpie.com\">Support</a> <a  href=\"privacy.html\">Privacy</a> <a href=\"legalese.html\">Legalese</a></div> \t\t\t<div id=\"copy\">&copy; 2016 <a href=\"http://studiosquid.co.uk/\" target=\"_blank\" title=\"Design by Mark Dormand\">MD</a> &amp; <a href=\"http://rihards.com/\" target=\"_blank\" title=\"Development by Rihards Steinbergs\">RS</a></div>         </div> \t</div> </div> <script type=\"text/javascript\">var gaJsHost = ((\"https:\" == document.location.protocol) ? \"https://ssl.\" : \"http://www.\");document.write(unescape(\"%3Cscript src='\" + gaJsHost + \"google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E\"));</script> <script type=\"text/javascript\">try {var pageTracker = _gat._getTracker(\"UA-9208019-1\");pageTracker._trackPageview();} catch(err) {}</script> </body> </html>"

        String regex = ".*<input type=\"text\" id=\"uploaded\" value=\"(.+?)\" .*"
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html)
        if(m.find()) {
            String imageUrl = m.group(1)
            println "https://images.google.com/searchbyimage?image_url=${imageUrl}"
            return "https://images.google.com/searchbyimage?image_url=${imageUrl}"
        }
        return null
    }

    File downloadImage(String url) {

        File downloadedFile = HttpDownloadUtility.downloadFile(url, "/tmp")
        return downloadedFile
    }
}
