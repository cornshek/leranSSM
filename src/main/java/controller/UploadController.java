package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.UploadedImageFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile imageFile)
            throws IOException {
        String name = "固定名字的图片.jpg";
        File file = new File(request.getServletContext().getRealPath("/image"), name);
        file.getParentFile().mkdirs();
        imageFile.getImage().transferTo(file);

        ModelAndView modelAndView = new ModelAndView("showUploadFile");
        modelAndView.addObject("imageName", name);
        return modelAndView;

    }
}
