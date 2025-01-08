package vn.com.LaptopShop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadFileService {
    private final ServletContext servletContext;

    public UploadFileService(ServletContext servletContext){
        this.servletContext =  servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file,String targetFolder){
        String finalName = "";
        try {
            byte[] bytes;
            bytes = file.getBytes();
            if(file.isEmpty())
                return"";
            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return finalName;
    }
}