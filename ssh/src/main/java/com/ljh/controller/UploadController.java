package com.ljh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * UploadController
 *
 * @author ljh
 * created on 2022/4/4 21:59
 */
@Controller
public class UploadController {

    private String DESKTOP_PATH;

    @PostConstruct
    public void init() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        DESKTOP_PATH = fsv.getHomeDirectory().getPath() + File.separator;
    }

    @GetMapping("upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String path = DESKTOP_PATH + "copy-" + file.getOriginalFilename();
            try {
                Files.copy(file.getInputStream(), Paths.get(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("result", "success");
        return "success";
    }

    @PostMapping("upload2")
    public String upload2(HttpServletRequest request) {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (resolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> fileNames = multiRequest.getFileNames();
            while (fileNames.hasNext()) {
                MultipartFile file = multiRequest.getFile(fileNames.next());
                if (file != null) {
                    String path = DESKTOP_PATH + "copy-" + file.getOriginalFilename();
                    try {
                        file.transferTo(Paths.get(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        request.setAttribute("result", "success");
        return "success";
    }
}
